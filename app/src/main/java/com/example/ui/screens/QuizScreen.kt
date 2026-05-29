package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Language
import com.example.model.RobloxPlace
import com.example.model.Translation
import com.example.ui.MainViewModel
import com.example.ui.theme.*

@Composable
fun QuizScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val lang by viewModel.language.collectAsState()
    val place by viewModel.currentPlace.collectAsState()
    val scene by viewModel.currentScene.collectAsState()
    val options by viewModel.options.collectAsState()
    val selectedOption by viewModel.selectedOption.collectAsState()
    val hasAnswered by viewModel.hasAnswered.collectAsState()
    val isCorrect by viewModel.isCorrect.collectAsState()
    val scoreDelta by viewModel.scoreDelta.collectAsState()
    
    val diffMode by viewModel.difficulty.collectAsState()
    val currentLvl by viewModel.currentLevel.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(CardBg, RoundedCornerShape(16.dp))
                .border(1.dp, BorderColor, RoundedCornerShape(16.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MainViewModel.QuizDifficulty.values().forEach { d ->
                val active = diffMode == d
                val labelKey = when (d) {
                    MainViewModel.QuizDifficulty.NORMAL -> "difficulty_normal"
                    MainViewModel.QuizDifficulty.HARD -> "difficulty_hard"
                    MainViewModel.QuizDifficulty.NIGHTMARE -> "difficulty_nightmare"
                }
                val label = Translation.get(labelKey, lang)
                
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (active) NeonTeal else Color.Transparent)
                        .clickable { viewModel.setDifficulty(d) }
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label,
                        color = if (active) SoftWhite else CoolGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(CardBg.copy(alpha = 0.8f), RoundedCornerShape(12.dp))
                    .border(1.dp, BorderColor, RoundedCornerShape(12.dp))
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "${Translation.get("level_title", lang)} $currentLvl",
                    color = SoftWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Black
                )
            }

            OutlinedButton(
                onClick = { viewModel.restartGame() },
                modifier = Modifier.testTag("restart_quiz_button"),
                border = BorderStroke(1.dp, NeonRed.copy(alpha = 0.6f)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = NeonRed
                ),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = Translation.get("restart_action", lang),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        val sceneEmoji = scene?.emoji ?: place.emoji
        val sceneEnHint = scene?.enHint ?: place.enHint
        val sceneRuHint = scene?.ruHint ?: place.ruHint
        val sceneColor = scene?.themeColor ?: place.themeColor

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, BorderColor, RoundedCornerShape(24.dp))
                .testTag("quiz_card"),
            colors = CardDefaults.cardColors(containerColor = CardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(sceneColor.copy(alpha = 0.5f), InputBg)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .background(
                                Brush.radialGradient(
                                    colors = listOf(sceneColor.copy(alpha = 0.35f), Color.Transparent)
                                )
                            )
                    )

                    Text(
                        text = sceneEmoji,
                        fontSize = 58.sp
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(12.dp)
                            .background(DarkBg.copy(alpha = 0.8f), RoundedCornerShape(8.dp))
                            .border(1.dp, BorderColor, RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = place.category,
                            color = SoftWhite,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (lang == Language.RU) sceneRuHint else sceneEnHint,
                        color = SoftWhite,
                        fontSize = 15.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = Translation.get("guess_the_place", lang),
                        color = NeonTeal,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            options.forEachIndexed { idx, option ->
                val isSelected = selectedOption?.id == option.id
                val isOptionCorrect = option.id == place.id

                val cardColor = when {
                    !hasAnswered -> CardBg
                    hasAnswered && isOptionCorrect -> SuccessGreen.copy(alpha = 0.12f)
                    hasAnswered && isSelected && !isOptionCorrect -> NeonRed.copy(alpha = 0.12f)
                    else -> CardBg.copy(alpha = 0.4f)
                }

                val borderColor = when {
                    !hasAnswered && isSelected -> NeonTeal
                    !hasAnswered -> BorderColor
                    hasAnswered && isOptionCorrect -> SuccessGreen
                    hasAnswered && isSelected && !isOptionCorrect -> NeonRed
                    else -> BorderColor.copy(alpha = 0.5f)
                }

                val textStyleColor = when {
                    !hasAnswered -> SoftWhite
                    hasAnswered && isOptionCorrect -> SuccessGreen
                    hasAnswered && isSelected && !isOptionCorrect -> NeonRed
                    else -> SoftWhite.copy(alpha = 0.4f)
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(enabled = !hasAnswered) {
                            viewModel.answerQuestion(option)
                        }
                        .testTag("option_item_${idx}"),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = option.emoji.firstOrNull()?.toString() ?: "🎮",
                                fontSize = 22.sp,
                                modifier = Modifier.padding(end = 12.dp)
                            )

                            Text(
                                text = if (lang == Language.RU) option.ruName else option.enName,
                                color = textStyleColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        if (hasAnswered) {
                            if (isOptionCorrect) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Correct",
                                    tint = SuccessGreen
                                )
                            } else if (isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Incorrect",
                                    tint = NeonRed
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedVisibility(
            visible = hasAnswered,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .testTag("feedback_banner"),
                colors = CardDefaults.cardColors(
                    containerColor = if (isCorrect) SuccessGreen.copy(alpha = 0.15f) else NeonRed.copy(alpha = 0.15f)
                ),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, if (isCorrect) SuccessGreen else NeonRed)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.Close,
                            contentDescription = null,
                            tint = if (isCorrect) SuccessGreen else NeonRed,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isCorrect) {
                                Translation.get("correct_answer", lang)
							} else {
                                Translation.get("wrong_answer", lang)
							},
                            color = if (isCorrect) SuccessGreen else NeonRed,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${Translation.get("points_earned", lang)}: ${if (scoreDelta > 0) "+$scoreDelta" else "$scoreDelta"} MVP",
                        color = SoftWhite,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.generateNewQuestion() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("next_question_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isCorrect) SuccessGreen else NeonRed,
                            contentColor = DarkBg
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = Translation.get("next_question", lang),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}