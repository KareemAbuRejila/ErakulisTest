package com.dotech.erakulistest.presentation.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dotech.erakulistest.R
import com.dotech.erakulistest.domain.models.Image
import com.dotech.erakulistest.presentation.theme.ErakulisTestTheme

@Composable
fun ImageListItem(
    image: Image,
    onItemClick: (Image) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(image) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .alpha(0.6f),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(image.imageURL)
                .placeholder(R.drawable.baseline_downloading_24).allowHardware(false)
                .error(R.drawable.baseline_broken_image_24).build(),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Text(
            text = " ${image.user}",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(CenterVertically)
        )

    }
}

@Preview
@Composable
fun CoinListItemPreview(){
    ErakulisTestTheme {
    }
}
