package com.example.model

enum class Language {
    RU, EN
}

object Translation {
    private val keys = mapOf(
        "app_title" to mapOf(Language.RU to "BloxQuiz - Викторина", Language.EN to "BloxQuiz - Quiz"),
        "subtitle" to mapOf(Language.RU to "Угадай плейс в Роблокс!", Language.EN to "Guess the Roblox Place!"),
        "login_title" to mapOf(Language.RU to "Авторизация", Language.EN to "Sign In"),
        "register_title" to mapOf(Language.RU to "Регистрация", Language.EN to "Register"),
        "username_label" to mapOf(Language.RU to "Имя пользователя / логин", Language.EN to "Username"),
        "password_label" to mapOf(Language.RU to "Пароль", Language.EN to "Password"),
        "nickname_label" to mapOf(Language.RU to "Никнейм (отображаемое имя)", Language.EN to "Nickname (display name)"),
        "button_login" to mapOf(Language.RU to "Войти", Language.EN to "Sign In"),
        "button_register" to mapOf(Language.RU to "Создать аккаунт", Language.EN to "Create Account"),
        "no_account" to mapOf(Language.RU to "Нет аккаунта? Зарегистрироваться", Language.EN to "No account? Register here"),
        "have_account" to mapOf(Language.RU to "Уже есть аккаунт? Войти", Language.EN to "Already have an account? Login"),
        "empty_fields" to mapOf(Language.RU to "Пожалуйста, заполните все поля", Language.EN to "Please fill in all fields"),
        "invalid_credentials" to mapOf(Language.RU to "Неверное имя пользователя или пароль", Language.EN to "Invalid username or password"),
        "user_exists" to mapOf(Language.RU to "Пользователь с таким именем уже существует", Language.EN to "User with this name already exists"),
        "register_success" to mapOf(Language.RU to "Успешная регистрация!", Language.EN to "Registration successful!"),
        "tab_quiz" to mapOf(Language.RU to "Играть", Language.EN to "Play"),
        "tab_profile" to mapOf(Language.RU to "Кабинет", Language.EN to "Profile"),
        "tab_leaderboard" to mapOf(Language.RU to "Лидеры", Language.EN to "Leaderboard"),
        "quiz_difficulty" to mapOf(Language.RU to "Сложность", Language.EN to "Difficulty"),
        "quiz_category" to mapOf(Language.RU to "Жанр", Language.EN to "Category"),
        "guess_the_place" to mapOf(Language.RU to "Что это за плейс?", Language.EN to "Which place is this?"),
        "correct_answer" to mapOf(Language.RU to "Правильно! Великолепно! 🎉", Language.EN to "Correct! Great job! 🎉"),
        "wrong_answer" to mapOf(Language.RU to "Неверно! Попробуй еще раз. 😢", Language.EN to "Wrong! Try again. 😢"),
        "points_earned" to mapOf(Language.RU to "Баллы за ответ", Language.EN to "Points earned"),
        "next_question" to mapOf(Language.RU to "Следующий вопрос", Language.EN to "Next Question"),
        "score_label" to mapOf(Language.RU to "Баллы", Language.EN to "Score"),
        "high_score_label" to mapOf(Language.RU to "Рекорд", Language.EN to "Record"),
        "congrats_new_record" to mapOf(Language.RU to "Новый рекорд! 🏆", Language.EN to "New High Score! 🏆"),
        "logout_button" to mapOf(Language.RU to "Выйти из аккаунта", Language.EN to "Log Out"),
        "registered_on" to mapOf(Language.RU to "Дата регистрации", Language.EN to "Registered on"),
        "leaderboard_rank" to mapOf(Language.RU to "Место", Language.EN to "Rank"),
        "leaderboard_empty" to mapOf(Language.RU to "Таблица лидеров пуста", Language.EN to "Leaderboard is empty"),
        "user_nickname" to mapOf(Language.RU to "Имя игрока", Language.EN to "Player name"),
        "level_title" to mapOf(Language.RU to "Уровень", Language.EN to "Level"),
        "restart_action" to mapOf(Language.RU to "Начать заново", Language.EN to "Start Over"),
        "difficulty_normal" to mapOf(Language.RU to "Нормально", Language.EN to "Normal"),
        "difficulty_hard" to mapOf(Language.RU to "Сложно", Language.EN to "Hard"),
        "difficulty_nightmare" to mapOf(Language.RU to "Кошмар", Language.EN to "Nightmare"),
        "record_normal" to mapOf(Language.RU to "Рекорд (Норм.)", Language.EN to "Record (Normal)"),
        "record_hard" to mapOf(Language.RU to "Рекорд (Хард)", Language.EN to "Record (Hard)"),
        "record_nightmare" to mapOf(Language.RU to "Рекорд (Кошмар)", Language.EN to "Record (Nightmare)"),
        "difficulty_easy" to mapOf(Language.RU to "Легко", Language.EN to "Easy"),
        "difficulty_medium" to mapOf(Language.RU to "Средне", Language.EN to "Medium"),
        "switch_lang" to mapOf(Language.RU to "Language: EN", Language.EN to "Язык: RU")
    )

    fun get(key: String, lang: Language): String {
        return keys[key]?.get(lang) ?: key
    }
}
