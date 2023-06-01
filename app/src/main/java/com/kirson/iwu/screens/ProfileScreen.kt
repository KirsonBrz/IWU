package com.kirson.iwu.screens

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.CrueltyFree
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.IWUTheme
import com.kirson.iwu.MainModel
import com.kirson.iwu.R
import com.kirson.iwu.entities.NavigationItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: MainModel, topPadding: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = topPadding)
    ) {

        val bottomState = rememberBottomSheetScaffoldState(
            bottomSheetState = SheetState(
                skipPartiallyExpanded = false,
                initialValue = SheetValue.PartiallyExpanded,
                skipHiddenState = true
            )
        )





        BottomSheetScaffold(
            sheetContent = {
                BottomScreen {
                    navController.navigate(NavigationItem.Empty.route) {
                        launchSingleTop = true
                        restoreState = false
                    }
                }
            },
            scaffoldState = bottomState,
            sheetPeekHeight = 300.dp
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val imageData = remember { mutableStateOf<Uri?>(null) }
                val context = LocalContext.current
                val launcher =
                    rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
                        imageData.value = it
                    }

                imageData.let {
                    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
                    val uri = it.value
                    if (uri != null) {
                        if (Build.VERSION.SDK_INT < 28) {
                            bitmap.value =
                                MediaStore.Images.Media.getBitmap(context.contentResolver, uri)

                        } else {
                            val source = ImageDecoder.createSource(context.contentResolver, uri)
                            bitmap.value = ImageDecoder.decodeBitmap(source)
                        }

                        bitmap.value?.let { btm ->
                            viewModel.setProfilePhoto(btm.asImageBitmap())
                        }
                    }

                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .size(250.dp)
                        .border(9.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
                {
                    this@Column.AnimatedVisibility(
                        visible = viewModel.profilePhoto.value == null,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .padding(20.dp),
                    ) {
                        OutlinedIconButton(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(190.dp),
                            border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                            onClick = {
                                launcher.launch(
                                    "image/*"
                                )
                            },
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
                                imageVector = Icons.Outlined.CrueltyFree,
                                contentDescription = null,
                            )
                        }
                    }
                    this@Column.AnimatedVisibility(
                        visible = viewModel.profilePhoto.value != null,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .padding(20.dp),
                    ) {

                        OutlinedIconButton(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(195.dp),
                            onClick = {
                                launcher.launch(
                                    "image/*"
                                )
                            },
                        ) {
                            Image(
                                modifier = Modifier.fillMaxSize(),
                                bitmap = viewModel.profilePhoto.value!!,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }

                    }


                }
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(220.dp))
                    Text(
                        text = "Завершено на 50%",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.secondary
                                    )
                                ),
                                shape = MaterialTheme.shapes.large
                            )
                            .padding(horizontal = 50.dp, vertical = 10.dp),

                        )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            style = MaterialTheme.typography.headlineLarge,
                            text = "Клиффорд, 3",
                            fontWeight = FontWeight.Bold,

                            )
                        Spacer(modifier = Modifier.width(9.dp))
                        Image(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = R.drawable.confirmation),
                            contentDescription = null
                        )
                    }
                }



                ElevatedButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(start = 170.dp, top = 15.dp)
                        .align(Alignment.TopCenter),
                    shape = CircleShape,
                    contentPadding = PaddingValues(16.dp)

                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null
                    )

                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomScreen(navToEmpty: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Card(
            onClick = { navToEmpty() },
            modifier = Modifier.size(122.dp, 141.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
            ),
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
                Icon(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp)
                        .background(MaterialTheme.colorScheme.surface, CircleShape)
                        .border(1.dp, Color.Gray, CircleShape),
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )


            }

        }

        Card(
            onClick = { navToEmpty() },
            modifier = Modifier.size(122.dp, 141.dp), colors = CardDefaults.cardColors(
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
                Icon(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp)
                        .background(MaterialTheme.colorScheme.surface, CircleShape)
                        .border(1.dp, Color.Gray, CircleShape),
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }

        }

        Card(
            onClick = { navToEmpty() },
            modifier = Modifier.size(122.dp, 141.dp), colors = CardDefaults.cardColors(
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
                Icon(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp)
                        .background(MaterialTheme.colorScheme.surface, CircleShape)
                        .border(1.dp, Color.Gray, CircleShape),
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }

        }

    }
    Spacer(modifier = Modifier.height(60.dp))
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.meet),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(9.dp))
            Text(
                text = buildAnnotatedString {

                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant)) {
                        append("IWU")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append(" Плюс")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 10.sp,
                            baselineShift = BaselineShift.Superscript
                        )
                    ) {
                        append("®")
                    }
                },
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Получите безлимитные лайки, паспорт питомца и другие плюсы!",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))
        ElevatedButton(
            onClick = { navToEmpty() }) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle()) {
                        append("Получить IWU Плюс")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 10.sp,
                            baselineShift = BaselineShift.Superscript
                        )
                    ) {
                        append("®")
                    }
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(horizontal = 28.dp)
            )

        }

    }
    Spacer(modifier = Modifier.height(40.dp))

}


@Preview(
    showBackground = true,
)
@Composable
fun ProfileScreenPreview() {
    IWUTheme {
        ProfileScreen(navController = rememberNavController(), viewModel = MainModel(), 40.dp)
    }

}

@Preview(
    showBackground = true,
)
@Composable
fun BottomScreenPreview() {
    IWUTheme {
        Column {
            BottomScreen {

            }
        }

    }

}