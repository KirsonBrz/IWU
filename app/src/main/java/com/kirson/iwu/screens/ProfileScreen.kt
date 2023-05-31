package com.kirson.iwu.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.IWUTheme
import com.kirson.iwu.MainModel
import com.kirson.iwu.components.IWULogo

@Composable
fun ProfileScreen(
    viewModel: MainModel,
    topPadding: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = topPadding)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier.size(122.dp, 141.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(6.dp)
                                .background(
                                    MaterialTheme.colorScheme.surface,
                                    shape = MaterialTheme.shapes.medium
                                ),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(bottom = 48.dp)
                                    .size(36.dp),
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(start = 6.dp, end = 6.dp, bottom = 6.dp)
                            ) {

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.labelSmall,
                                    text = "0 Супер Лайков",
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.labelLarge,
                                    text = "Получить",
                                    color = MaterialTheme.colorScheme.secondary,
                                    textAlign = TextAlign.Center
                                )
                            }


                        }
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(24.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.dp, Color.Gray),
                            colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.surface)

                        ) {
                            Icon(Icons.Default.Add, contentDescription = null)

                        }
                    }

                }

                Card(
                    modifier = Modifier.size(122.dp, 141.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(6.dp)
                                .background(
                                    MaterialTheme.colorScheme.surface,
                                    shape = MaterialTheme.shapes.medium
                                ),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(bottom = 48.dp)
                                    .size(36.dp),
                                imageVector = Icons.Filled.Bolt,
                                contentDescription = null,
                                tint = Color.Magenta
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(start = 6.dp, end = 6.dp, bottom = 6.dp)
                            ) {

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.labelSmall,
                                    text = "Мои бустеры",
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.labelLarge,
                                    text = "Получить",
                                    color = Color.Magenta,
                                    textAlign = TextAlign.Center
                                )
                            }


                        }
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(24.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.dp, Color.Gray),
                            colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.surface)

                        ) {
                            Icon(Icons.Default.Add, contentDescription = null)

                        }
                    }

                }

                Card(
                    modifier = Modifier.size(122.dp, 141.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(6.dp)
                                .background(
                                    MaterialTheme.colorScheme.surface,
                                    shape = MaterialTheme.shapes.medium
                                ),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(bottom = 48.dp)
                                    .size(36.dp),
                                imageVector = Icons.Filled.LocalFireDepartment,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(start = 6.dp, end = 6.dp, bottom = 6.dp)
                            ) {

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.labelSmall,
                                    text = "Подписки",
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.labelSmall,
                                    text = "",
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1
                                )
                            }


                        }
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(24.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.dp, Color.Gray),
                            colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.surface)

                        ) {
                            Icon(Icons.Default.Add, contentDescription = null)

                        }
                    }

                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    IWUTheme {
        ProfileScreen(viewModel = MainModel(), 40.dp)
    }

}