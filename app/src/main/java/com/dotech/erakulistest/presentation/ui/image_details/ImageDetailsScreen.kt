package com.dotech.erakulistest.presentation.ui.image_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dotech.erakulistest.data.models.ImageDetails
import com.dotech.erakulistest.presentation.theme.ErakulisTestTheme
import com.dotech.erakulistest.presentation.ui.image_details.sections.DetailsSection
import com.dotech.erakulistest.presentation.ui.image_details.sections.ImageSection

@Composable
fun ImageDetailsScreen(
    image: ImageDetails
) {

//    val state = viewModel.state.value

    Column (modifier = Modifier.fillMaxSize()) {
//        state.image?.let { image ->
        ImageSection(
            imgUrl = image.largeImageURL,
            imgSize = image.imageSize,
            imgType = image.type,
            imgTags = image.tags
        )
        Spacer(modifier = Modifier.height(16.dp))

        DetailsSection(
            usr = image.user,
            views = image.views,
            comments = image.comments,
            fav = image.likes,
            down = image.downloads
        )
//        }
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ImageDetailsScreen() {
    ErakulisTestTheme {
        ImageDetailsScreen(
            image = ImageDetails(
                id = 3605547,
                pageURL = "https://pixabay.com/photos/ocean-milky-way-boat-sailing-3605547/",
                type = "photo",
                tags = "ocean, milky way, boat",
                previewURL = "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_150.jpg",
                previewWidth = 150,
                previewHeight = 97,
                webformatURL = "https://pixabay.com/get/gf4e9a17ee3efc693ca41e6d54d69c8cc6dc5d57b13bf08ea1e0da7db937130c5fce230fa796edf70b81f831474b233bba7d72824b8f095d69b2fe771324e26e2_640.jpg",
                webformatWidth = 640,
                webformatHeight = 415,
                largeImageURL = "https://pixabay.com/get/g970ac883634ec6ac8e0497127c49c9fbe3db01ad71a3d7b4451f94f0b71149e251bd8bc1388a07263ef8fc89103d014bcd6ce4c369d7da163dddf4241a09a1b4_1280.jpg",
                imageWidth = 6000,
                imageHeight = 3894,
                imageSize = 3590092,
                views = 5944929,
                downloads = 3912388,
                collections = 159587,
                likes = 6323,
                comments = 994,
                user_id = 7645255,
                user = "jplenio",
                userImageURL = "https://cdn.pixabay.com/user/2024/06/10/13-43-32-848_250x250.jpg"
            )
        )
    }
}

/* Section 1
■ The Image itself
■ The image size
■ The image type
■ The image tags
○ Section 2
■ The name of the user who uploaded the image
■ The amount of views
■ The amount of likes
■ The amount of comments
■ The amount of favorites
■ The amount of downloads*/

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