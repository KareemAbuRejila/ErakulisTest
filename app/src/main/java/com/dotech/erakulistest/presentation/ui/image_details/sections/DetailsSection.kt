package com.dotech.erakulistest.presentation.ui.image_details.sections

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotech.erakulistest.presentation.theme.ErakulisTestTheme

@Composable
fun DetailsSection(usr: String, views: Int, comments: Int, fav: Int, down: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // User Details
        Text(text = "Uploaded by: ${usr}", style = MaterialTheme.typography.bodyMedium, fontStyle = FontStyle.Italic)

        Spacer(modifier = Modifier.height(8.dp))

        // Image Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatisticItem(label = "Views", value = views)
            StatisticItem(label = "Likes", value = fav)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatisticItem(label = "Comments", value = comments)
            StatisticItem(label = "Favorites", value = fav)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            StatisticItem(label = "Downloads", value = down)
        }
    }
}

@Composable
fun StatisticItem(label: String, value: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = value.toString(), style = MaterialTheme.typography.bodyLarge)
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun DetailsSectionPreview(){
    ErakulisTestTheme {
        DetailsSection(
            usr = "jplenio",
            views = 5944929,
            comments = 994,
            fav = 6323,
            down =3912388
        )
    }
}