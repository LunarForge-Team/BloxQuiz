package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Language
import com.example.model.Translation
import com.example.ui.MainViewModel
import com.example.ui.theme.*

@Composable
fun AuthScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val currentScreen by viewModel.currentScreen.collectAsState()
    val lang by viewModel.language.collectAsState()
    val errKey by viewModel.message.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }

    LaunchedEffect(currentScreen) {
        username = ""
        password = ""
        nickname = ""
        viewModel.clearMessage()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(DarkBg, Color(0xFF131522))
                )
            )
            .padding(24.dp)
            .systemBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .background(CardBg, RoundedCornerShape(12.dp))
                .clickable { viewModel.switchLanguage() }
                .padding(horizontal = 14.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Language",
                tint = NeonTeal,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = Translation.get("switch_lang", lang),
                color = SoftWhite,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(NeonRed, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(DarkBg, RoundedCornerShape(6.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = Translation.get("app_title", lang),
                color = SoftWhite,
                fontSize = 28.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )

            Text(
                text = Translation.get("subtitle", lang),
                color = CoolGray,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, BorderColor, RoundedCornerShape(16.dp))
                    .testTag("auth_form_card"),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (currentScreen == MainViewModel.Screen.LOGIN) {
                            Translation.get("login_title", lang)
                        } else {
                            Translation.get("register_title", lang)
                        },
                        color = NeonTeal,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    AnimatedVisibility(visible = errKey != null) {
                        errKey?.let { k ->
                            val msg = Translation.get(k, lang)
                            Text(
                                text = msg,
                                color = NeonRed,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 12.dp)
                                    .background(NeonRed.copy(alpha = 0.15f), RoundedCornerShape(8.dp))
                                    .padding(10.dp)
                            )
                        }
                    }

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(Translation.get("username_label", lang)) },
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = CoolGray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("username_input"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = SoftWhite,
                            unfocusedTextColor = SoftWhite,
                            focusedBorderColor = NeonTeal,
                            unfocusedBorderColor = BorderColor,
                            focusedContainerColor = InputBg,
                            unfocusedContainerColor = InputBg
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    if (currentScreen == MainViewModel.Screen.REGISTER) {
                        OutlinedTextField(
                            value = nickname,
                            onValueChange = { nickname = it },
                            label = { Text(Translation.get("nickname_label", lang)) },
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = CoolGray) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("nickname_input"),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = SoftWhite,
                                unfocusedTextColor = SoftWhite,
                                focusedBorderColor = NeonTeal,
                                unfocusedBorderColor = BorderColor,
                                focusedContainerColor = InputBg,
                                unfocusedContainerColor = InputBg
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(Translation.get("password_label", lang)) },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = CoolGray) },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("password_input"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = SoftWhite,
                            unfocusedTextColor = SoftWhite,
                            focusedBorderColor = NeonTeal,
                            unfocusedBorderColor = BorderColor,
                            focusedContainerColor = InputBg,
                            unfocusedContainerColor = InputBg
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            if (currentScreen == MainViewModel.Screen.LOGIN) {
                                viewModel.login(username, password)
                            } else {
                                viewModel.register(username, password, nickname)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("submit_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = NeonTeal,
                            contentColor = DarkBg
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (currentScreen == MainViewModel.Screen.LOGIN) {
                                Translation.get("button_login", lang)
                            } else {
                                Translation.get("button_register", lang)
                            },
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = if (currentScreen == MainViewModel.Screen.LOGIN) {
                            Translation.get("no_account", lang)
                        } else {
                            Translation.get("have_account", lang)
                        },
                        color = NeonTeal,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clickable {
                                if (currentScreen == MainViewModel.Screen.LOGIN) {
                                    viewModel.setScreen(MainViewModel.Screen.REGISTER)
                                } else {
                                    viewModel.setScreen(MainViewModel.Screen.LOGIN)
                                }
                            }
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun <T> rememberState(initial: T): MutableState<T> = remember { mutableStateOf(initial) }
