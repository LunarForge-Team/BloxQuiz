package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.User
import com.example.data.UserRepository
import com.example.model.Language
import com.example.model.PlacesData
import com.example.model.RobloxPlace
import com.example.model.PlaceScene
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    enum class Screen {
        LOGIN, REGISTER, MAIN_HUB
    }

    enum class Tab {
        QUIZ, LEADERBOARD, PROFILE
    }

    enum class QuizDifficulty {
        NORMAL, HARD, NIGHTMARE
    }

    private val _currentScreen = MutableStateFlow(Screen.LOGIN)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _currentTab = MutableStateFlow(Tab.QUIZ)
    val currentTab: StateFlow<Tab> = _currentTab.asStateFlow()

    private val _language = MutableStateFlow(Language.RU)
    val language: StateFlow<Language> = _language.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _message = MutableStateFlow<String?>(null)
    val message: StateFlow<String?> = _message.asStateFlow()

    val leaderboard: StateFlow<List<User>>

    private val _difficulty = MutableStateFlow(QuizDifficulty.NORMAL)
    val difficulty: StateFlow<QuizDifficulty> = _difficulty.asStateFlow()

    private val _currentLevel = MutableStateFlow(1)
    val currentLevel: StateFlow<Int> = _currentLevel.asStateFlow()

    private val _currentScene = MutableStateFlow<PlaceScene?>(null)
    val currentScene: StateFlow<PlaceScene?> = _currentScene.asStateFlow()

    private val _currentPlace = MutableStateFlow<RobloxPlace>(PlacesData.places.first())
    val currentPlace: StateFlow<RobloxPlace> = _currentPlace.asStateFlow()

    private val _options = MutableStateFlow<List<RobloxPlace>>(emptyList())
    val options: StateFlow<List<RobloxPlace>> = _options.asStateFlow()

    private val _selectedOption = MutableStateFlow<RobloxPlace?>(null)
    val selectedOption: StateFlow<RobloxPlace?> = _selectedOption.asStateFlow()

    private val _hasAnswered = MutableStateFlow(false)
    val hasAnswered: StateFlow<Boolean> = _hasAnswered.asStateFlow()

    private val _isCorrect = MutableStateFlow(false)
    val isCorrect: StateFlow<Boolean> = _isCorrect.asStateFlow()

    private val _scoreDelta = MutableStateFlow(0)
    val scoreDelta: StateFlow<Int> = _scoreDelta.asStateFlow()

    init {
        val database = AppDatabase.getDatabase(application)
        repository = UserRepository(database.userDao())
        
        leaderboard = repository.leaderboard.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

        generateNewQuestion()
    }

    fun switchLanguage() {
        _language.value = if (_language.value == Language.RU) Language.EN else Language.RU
    }

    fun setScreen(screen: Screen) {
        _currentScreen.value = screen
        _message.value = null
    }

    fun setTab(tab: Tab) {
        _currentTab.value = tab
    }

    fun clearMessage() {
        _message.value = null
    }


    fun login(usernameInput: String, passwordInput: String) {
        val trimmedUser = usernameInput.trim()
        val trimmedPass = passwordInput.trim()

        if (trimmedUser.isEmpty() || trimmedPass.isEmpty()) {
            _message.value = "empty_fields"
            return
        }

        viewModelScope.launch {
            val user = repository.getUserByUsername(trimmedUser)
            if (user != null && user.passwordHash == trimmedPass) {
                _currentUser.value = user
                _currentScreen.value = Screen.MAIN_HUB
                _message.value = null
            } else {
                _message.value = "invalid_credentials"
            }
        }
    }

    fun register(usernameInput: String, passwordInput: String, nicknameInput: String) {
        val trimmedUser = usernameInput.trim()
        val trimmedPass = passwordInput.trim()
        val trimmedNick = nicknameInput.trim()

        if (trimmedUser.isEmpty() || trimmedPass.isEmpty() || trimmedNick.isEmpty()) {
            _message.value = "empty_fields"
            return
        }

        viewModelScope.launch {
            val newUser = User(
                username = trimmedUser,
                passwordHash = trimmedPass,
                nickname = trimmedNick,
                highestScore = 0,
                currentScore = 0,
                highestLevelNormal = 0,
                highestLevelHard = 0,
                highestLevelNightmare = 0
            )
            val success = repository.registerUser(newUser)
            if (success) {
                _currentUser.value = newUser
                _currentScreen.value = Screen.MAIN_HUB
                _message.value = "register_success"
            } else {
                _message.value = "user_exists"
            }
        }
    }

    fun logout() {
        _currentUser.value = null
        _currentScreen.value = Screen.LOGIN
        _currentTab.value = Tab.QUIZ
    }

    fun setDifficulty(diff: QuizDifficulty) {
        _difficulty.value = diff
        _currentLevel.value = 1
        _selectedOption.value = null
        _hasAnswered.value = false
        _isCorrect.value = false
        _scoreDelta.value = 0
        generateNewQuestion()
    }

    fun restartGame() {
        _currentLevel.value = 1
        _selectedOption.value = null
        _hasAnswered.value = false
        _isCorrect.value = false
        _scoreDelta.value = 0
        generateNewQuestion()
    }

    fun generateNewQuestion() {
        if (_hasAnswered.value) {
            if (_isCorrect.value) {
                _currentLevel.value += 1
            } else {
                _currentLevel.value = 1
            }
        }

        _selectedOption.value = null
        _hasAnswered.value = false
        _isCorrect.value = false
        _scoreDelta.value = 0

        val totalList = PlacesData.places
        if (totalList.isEmpty()) return
        val chosenTarget = totalList.random()
        _currentPlace.value = chosenTarget

        val chosenScene = if (chosenTarget.scenes.isNotEmpty()) {
            chosenTarget.scenes.random()
        } else {
            PlaceScene(
                emoji = chosenTarget.emoji,
                enHint = chosenTarget.enHint,
                ruHint = chosenTarget.ruHint,
                themeColor = chosenTarget.themeColor
            )
        }
        _currentScene.value = chosenScene

        val neededIncorrect = when (_difficulty.value) {
            QuizDifficulty.NORMAL -> 2
            QuizDifficulty.HARD -> 4
            QuizDifficulty.NIGHTMARE -> 8
        }

        val incorrectCandidates = totalList.filter { it.id != chosenTarget.id }.shuffled()
        val incorrectSubset = incorrectCandidates.take(minOf(neededIncorrect, incorrectCandidates.size))

        val finalOptions = (incorrectSubset + chosenTarget).shuffled()
        _options.value = finalOptions
    }

    fun answerQuestion(option: RobloxPlace) {
        if (_hasAnswered.value) return

        _selectedOption.value = option
        _hasAnswered.value = true

        val isAnswerCorrect = option.id == _currentPlace.value.id
        _isCorrect.value = isAnswerCorrect

        val points = when (_difficulty.value) {
            QuizDifficulty.NORMAL -> 15
            QuizDifficulty.HARD -> 25
            QuizDifficulty.NIGHTMARE -> 50
        }

        viewModelScope.launch {
            val activeUser = _currentUser.value
            if (activeUser != null) {
                val updatedScore: Int
                
                if (isAnswerCorrect) {
                    _scoreDelta.value = points
                    updatedScore = activeUser.currentScore + points
                    val currentLvl = _currentLevel.value

                    val updatedUser = when (_difficulty.value) {
                        QuizDifficulty.NORMAL -> {
                            val isNewRecordLvl = currentLvl > activeUser.highestLevelNormal
                            activeUser.copy(
                                currentScore = updatedScore,
                                highestLevelNormal = if (isNewRecordLvl) currentLvl else activeUser.highestLevelNormal,
                                highestScore = maxOf(activeUser.highestScore, updatedScore),
                                lastActiveTimestamp = System.currentTimeMillis()
                            )
                        }
                        QuizDifficulty.HARD -> {
                            val isNewRecordLvl = currentLvl > activeUser.highestLevelHard
                            activeUser.copy(
                                currentScore = updatedScore,
                                highestLevelHard = if (isNewRecordLvl) currentLvl else activeUser.highestLevelHard,
                                highestScore = maxOf(activeUser.highestScore, updatedScore),
                                lastActiveTimestamp = System.currentTimeMillis()
                            )
                        }
                        QuizDifficulty.NIGHTMARE -> {
                            val isNewRecordLvl = currentLvl > activeUser.highestLevelNightmare
                            activeUser.copy(
                                currentScore = updatedScore,
                                highestLevelNightmare = if (isNewRecordLvl) currentLvl else activeUser.highestLevelNightmare,
                                highestScore = maxOf(activeUser.highestScore, updatedScore),
                                lastActiveTimestamp = System.currentTimeMillis()
                            )
                        }
                    }

                    repository.updateUser(updatedUser)
                    _currentUser.value = updatedUser
                } else {
                    val penalty = 5
                    _scoreDelta.value = -penalty
                    updatedScore = maxOf(0, activeUser.currentScore - penalty)
                    
                    val updatedUser = activeUser.copy(
                        currentScore = updatedScore,
                        lastActiveTimestamp = System.currentTimeMillis()
                    )
                    repository.updateUser(updatedUser)
                    _currentUser.value = updatedUser
                }
            }
        }
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
