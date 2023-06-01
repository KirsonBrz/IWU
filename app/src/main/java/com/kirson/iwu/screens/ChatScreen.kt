package com.kirson.iwu.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.CrueltyFree
import androidx.compose.material.icons.outlined.MarkUnreadChatAlt
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.IWUTheme
import com.kirson.iwu.MainModel

@OptIn(ExperimentalTextApi::class)
@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: MainModel = viewModel(),
    topPadding: Dp,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = topPadding)
            .verticalScroll(rememberScrollState())
    ) {

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Д")
            }
            withStyle(style = SpanStyle()) {
                append("иалоги")
            }
        }, fontSize = 30.sp)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center,
        ) {
            val brushGradient = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary,
                )
            )
            Icon(
                modifier = Modifier
                    .size(100.dp)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                brushGradient, blendMode = BlendMode.SrcAtop
                            )
                        }
                    },
                imageVector = Icons.Outlined.MarkUnreadChatAlt,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 300.dp),
                text = "У вас пока нет диалогов",
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    ),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp,
                ),
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    IWUTheme {
        ChatScreen(navController = rememberNavController(), viewModel = MainModel(), 40.dp)
    }

}