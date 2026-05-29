package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Translation
import com.example.ui.MainViewModel
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHubScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val lang by viewModel.language.collectAsState()
    val activeTab by viewModel.currentTab.collectAsState()
    val user by viewModel.currentUser.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(NeonRed, RoundedCornerShape(6.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(DarkBg, RoundedCornerShape(2.dp))
                                    .align(Alignment.Center)
                            )
                        }
                        Text(
                            text = Translation.get("app_title", lang),
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp,
                            color = SoftWhite
                        )
                    }
                },
                actions = {
                    user?.let { u ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .background(NeonTeal.copy(alpha = 0.12f), RoundedCornerShape(12.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Active Score",
                                tint = NeonTeal,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${u.currentScore} MVP",
                                color = NeonTeal,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    IconButton(
                        onClick = { viewModel.switchLanguage() },
                        modifier = Modifier.testTag("lang_toggle_hub")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Switch Language",
                            tint = SoftWhite
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkBg,
                    titleContentColor = SoftWhite,
                    actionIconContentColor = SoftWhite
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = CardBg,
                tonalElevation = 8.dp,
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .drawBehind {
                        drawLine(
                            color = BorderColor,
                            start = androidx.compose.ui.geometry.Offset(0f, 0f),
                            end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                            strokeWidth = 1.dp.toPx()
                        )
                    }
            ) {
                NavigationBarItem(
                    selected = activeTab == MainViewModel.Tab.QUIZ,
                    onClick = { viewModel.setTab(MainViewModel.Tab.QUIZ) },
                    icon = { Icon(Icons.Default.PlayArrow, contentDescription = null) },
                    label = { Text(Translation.get("tab_quiz", lang)) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkBg,
                        selectedTextColor = NeonTeal,
                        indicatorColor = NeonTeal,
                        unselectedIconColor = CoolGray,
                        unselectedTextColor = CoolGray
                    ),
                    modifier = Modifier.testTag("tab_button_quiz")
                )

                NavigationBarItem(
                    selected = activeTab == MainViewModel.Tab.LEADERBOARD,
                    onClick = { viewModel.setTab(MainViewModel.Tab.LEADERBOARD) },
                    icon = { Icon(Icons.Default.Star, contentDescription = null) },
                    label = { Text(Translation.get("tab_leaderboard", lang)) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkBg,
                        selectedTextColor = NeonTeal,
                        indicatorColor = NeonTeal,
                        unselectedIconColor = CoolGray,
                        unselectedTextColor = CoolGray
                    ),
                    modifier = Modifier.testTag("tab_button_leaderboard")
                )

                NavigationBarItem(
                    selected = activeTab == MainViewModel.Tab.PROFILE,
                    onClick = { viewModel.setTab(MainViewModel.Tab.PROFILE) },
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text(Translation.get("tab_profile", lang)) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkBg,
                        selectedTextColor = NeonTeal,
                        indicatorColor = NeonTeal,
                        unselectedIconColor = CoolGray,
                        unselectedTextColor = CoolGray
                    ),
                    modifier = Modifier.testTag("tab_button_profile")
                )
            }
        },
        containerColor = DarkBg
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Crossfade(targetState = activeTab, label = "TabCrossfade") { tab ->
                when (tab) {
                    MainViewModel.Tab.QUIZ -> QuizScreen(viewModel = viewModel)
                    MainViewModel.Tab.LEADERBOARD -> LeaderboardScreen(viewModel = viewModel)
                    MainViewModel.Tab.PROFILE -> ProfileScreen(viewModel = viewModel)
                }
            }
        }
    }
}
