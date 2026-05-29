package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

@Composable
fun LeaderboardScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val lang by viewModel.language.collectAsState()
    val users by viewModel.leaderboard.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, BorderColor, RoundedCornerShape(20.dp))
                .testTag("leaderboard_header"),
            colors = CardDefaults.cardColors(containerColor = CardBg),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = Translation.get("tab_leaderboard", lang),
                        color = GoldStar,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        text = if (users.isNotEmpty()) {
                            if (lang == com.example.model.Language.RU) "Лучшие игроки на устройстве" else "Top players on this device"
                        } else {
                            ""
                        },
                        color = CoolGray,
                        fontSize = 13.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(GoldStar.copy(alpha = 0.15f), RoundedCornerShape(25.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Leaderboard",
                        tint = GoldStar,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }

        if (users.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = Translation.get("leaderboard_empty", lang),
                    color = CoolGray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = Translation.get("leaderboard_rank", lang),
                    color = CoolGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(50.dp)
                )
                Text(
                    text = Translation.get("user_nickname", lang),
                    color = CoolGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = Translation.get("score_label", lang),
                    color = CoolGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(80.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("leaderboard_list"),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(users) { index, user ->
                    val rank = index + 1

                    val (rankBg, rankText, rankIcon) = when (rank) {
                        1 -> Triple(GoldStar.copy(alpha = 0.2f), GoldStar, "🥇")
                        2 -> Triple(Color(0xFFE0E0E0).copy(alpha = 0.2f), Color(0xFFE0E0E0), "🥈")
                        3 -> Triple(Color(0xFFCD7F32).copy(alpha = 0.15f), Color(0xFFCD7F32), "🥉")
                        else -> Triple(CardBg, CoolGray, "$rank")
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .border(
                                width = 1.dp,
                                color = if (rank <= 3) rankText.copy(alpha = 0.5f) else BorderColor,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        colors = CardDefaults.cardColors(containerColor = CardBg),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier.width(50.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (rank <= 3) {
                                    Text(
                                        text = rankIcon,
                                        fontSize = 20.sp
                                    )
                                } else {
                                    Text(
                                        text = rankIcon,
                                        color = CoolGray,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = user.nickname,
                                    color = SoftWhite,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "@${user.username}",
                                    color = CoolGray,
                                    fontSize = 12.sp
                                )
                            }

                            Row(
                                modifier = Modifier.width(80.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = if (rank == 1) GoldStar else CoolGray,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${user.highestScore}",
                                    color = if (rank == 1) GoldStar else SoftWhite,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
