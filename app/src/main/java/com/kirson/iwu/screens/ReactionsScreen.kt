package com.kirson.iwu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.IWUTheme
import com.kirson.iwu.MainActivity
import com.kirson.iwu.MainModel
import com.kirson.iwu.R
import com.kirson.iwu.entities.MatchProfile
import com.kirson.iwu.entities.profiles

@Composable
fun ReactionsScreen(
    viewModel: MainModel,
    topPadding: Dp
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = topPadding)
    ) {

        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "Вам понравились",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        LazyColumn {
            items(viewModel.likedPets) {

                LikedPetsItem(it)


            }

        }

    }
}

@Composable
fun LikedPetsItem(profile: MatchProfile) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
    ) {
        Image(
            painter = painterResource(id = profile.drawableResId),
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = profile.name
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                style = MaterialTheme.typography.bodyMedium,
                text = profile.name,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        if (profile.pro) {
            Icon(
                modifier = Modifier.size(40.dp)
                    .padding(5.dp),
                painter = painterResource(id = R.drawable.meet),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }


    }


}

@Preview(showBackground = true)
@Composable
fun ReactionsScreenPreview() {
    IWUTheme {
        ReactionsScreen(viewModel = MainModel(), 40.dp)
    }

}

@Preview(showBackground = true)
@Composable
fun LikedPetsItemPreview() {
    IWUTheme {
        LikedPetsItem(profiles[0])
    }

}