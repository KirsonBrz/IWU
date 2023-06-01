package com.kirson.iwu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.IWUTheme
import com.kirson.iwu.entities.NavigationItem
import com.kirson.iwu.entities.VetProfile
import com.kirson.iwu.entities.veterinars

@Composable
fun VetScreen(
    navController: NavController,
    topPadding: Dp
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = topPadding)
    ) {


        LazyColumn {

            item {
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = "Доступные в вашем регионе:",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            items(veterinars) {

                VetItem(it) {
                    navController.navigate(NavigationItem.Empty.route) {
                        launchSingleTop = true
                        restoreState = false

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))


            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VetItem(
    profile: VetProfile,
    navToEmpty: () -> Unit
) {
    Card(
        onClick = { navToEmpty() },
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = profile.drawableResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onPrimaryContainer,
                        RoundedCornerShape(12.dp)
                    ),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(10.dp))

            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = profile.name
            )


        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 12.dp),
            style = MaterialTheme.typography.bodyMedium,
            text = profile.description,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Divider(Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            style = MaterialTheme.typography.titleMedium,
            text = profile.adress,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )


    }
}

@Preview(showBackground = true)
@Composable
fun VetScreenPreview() {
    IWUTheme {
        VetScreen(rememberNavController(), topPadding = 40.dp)
    }

}

@Preview(showBackground = true)
@Composable
fun VetItemPreview() {
    IWUTheme {
        VetItem(veterinars[0]) {

        }
    }
}