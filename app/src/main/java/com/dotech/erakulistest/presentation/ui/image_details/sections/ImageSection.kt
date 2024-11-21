package com.dotech.erakulistest.presentation.ui.image_details.sections

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dotech.erakulistest.presentation.theme.ErakulisTestTheme

@Composable
fun ImageSection(imgUrl: String, imgSize: Int, imgType: String, imgTags: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Image
        AsyncImage(
            model = imgUrl,
            contentDescription = "Image Detail",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image Size
        Text(text = "Size: $imgSize KB", style = MaterialTheme.typography.bodyMedium)

        // Image Type
        Text(text = "Type: $imgType", style = MaterialTheme.typography.bodyMedium)

        // Image Tags
        Text(text = "Tags: $imgTags", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun ImageSectionPreview(){
    ErakulisTestTheme {
        ImageSection(
            imgUrl = "https://pixabay.com/photos/ocean-milky-way-boat-sailing-3605547/",
            imgSize = 3590092,
            imgTags = "ocean, milky way, boat",
            imgType = "photo"
        )
    }
}
/*{
            "id": 3605547,
            "pageURL": "https://pixabay.com/photos/ocean-milky-way-boat-sailing-3605547/",
            "type": "photo",
            "tags": "ocean, milky way, boat",
            "previewURL": "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_150.jpg",
            "previewWidth": 150,
            "previewHeight": 97,
            "webformatURL": "https://pixabay.com/get/gf4e9a17ee3efc693ca41e6d54d69c8cc6dc5d57b13bf08ea1e0da7db937130c5fce230fa796edf70b81f831474b233bba7d72824b8f095d69b2fe771324e26e2_640.jpg",
            "webformatWidth": 640,
            "webformatHeight": 415,
            "largeImageURL": "https://pixabay.com/get/g970ac883634ec6ac8e0497127c49c9fbe3db01ad71a3d7b4451f94f0b71149e251bd8bc1388a07263ef8fc89103d014bcd6ce4c369d7da163dddf4241a09a1b4_1280.jpg",
            "imageWidth": 6000,
            "imageHeight": 3894,
            "imageSize": 3590092,
            "views": 5944929,
            "downloads": 3912388,
            "collections": 159587,
            "likes": 6323,
            "comments": 994,
            "user_id": 7645255,
            "user": "jplenio",
            "userImageURL": "https://cdn.pixabay.com/user/2024/06/10/13-43-32-848_250x250.jpg"
        }*/