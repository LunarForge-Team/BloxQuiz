package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Translation
import com.example.ui.MainViewModel
import com.example.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ProfileScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val lang by viewModel.language.collectAsState()
    val user by viewModel.currentUser.collectAsState()

    val dateFormat = remember { SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault()) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        user?.let { u ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, BorderColor, RoundedCornerShape(24.dp))
                    .testTag("profile_main_card"),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(NeonTeal, Color(0xFF00ACC1))
                                ),
                                shape = RoundedCornerShape(24.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "ッ",
                            color = DarkBg,
                            fontSize = 62.sp,
                            fontWeight = FontWeight.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = u.nickname,
                        color = SoftWhite,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "@${u.username}",
                        color = CoolGray,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, BorderColor, RoundedCornerShape(20.dp))
                    .testTag("profile_stats_card"),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ProfileStatRow(
                        icon = Icons.Default.Star,
                        iconColor = NeonTeal,
                        label = if (lang == com.example.model.Language.RU) "Текущие баллы" else "Current Score",
                        value = "${u.currentScore} MVP"
                    )

                    HorizontalDivider(color = BorderColor)

                    ProfileStatRow(
                        icon = Icons.Default.Star,
                        iconColor = SuccessGreen,
                        label = Translation.get("record_normal", lang),
                        value = "${Translation.get("level_title", lang)} ${u.highestLevelNormal}"
                    )

                    HorizontalDivider(color = BorderColor)

                    ProfileStatRow(
                        icon = Icons.Default.Star,
                        iconColor = InfoBlue,
                        label = Translation.get("record_hard", lang),
                        value = "${Translation.get("level_title", lang)} ${u.highestLevelHard}"
                    )

                    HorizontalDivider(color = BorderColor)

                    ProfileStatRow(
                        icon = Icons.Default.Star,
                        iconColor = NeonRed,
                        label = Translation.get("record_nightmare", lang),
                        value = "${Translation.get("level_title", lang)} ${u.highestLevelNightmare}"
                    )

                    HorizontalDivider(color = BorderColor)

                    val formattedDate = try {
                        dateFormat.format(Date(u.lastActiveTimestamp))
                    } catch (e: Exception) {
                        "---"
                    }
                    ProfileStatRow(
                        icon = Icons.Default.DateRange,
                        iconColor = CoolGray,
                        label = Translation.get("registered_on", lang),
                        value = formattedDate
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { viewModel.logout() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .border(1.dp, NeonRed.copy(alpha = 0.4f), RoundedCornerShape(14.dp))
                    .testTag("logout_button"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = NeonRed
                ),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = "Logout",
                        tint = NeonRed
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = Translation.get("logout_button", lang),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileStatRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = label,
                color = CoolGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Text(
            text = value,
            color = SoftWhite,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
