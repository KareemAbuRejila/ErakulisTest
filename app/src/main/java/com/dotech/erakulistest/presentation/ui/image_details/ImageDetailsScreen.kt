package com.dotech.erakulistest.presentation.ui.image_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dotech.erakulistest.presentation.theme.ErakulisTestTheme

@Composable
fun ImageDetailsScreen(
    viewModel: ImageDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        state.image?.let { image ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item{
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "${image.id}. ${image.imageSize} (${image.tags})")
                        Text(text = image.user)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
//                    Text(text = imageId.description)
//                    Spacer(modifier = Modifier.height(15.dp))
//                    Text(text = "Tags")
//                    Spacer(modifier = Modifier.height(15.dp))
//                    FlowRow {
//                        imageId.tags.forEach { tag->
//                            CoinTag(tag = tag)
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(15.dp))
//                    Text(text = "Team members",
//                        style = MaterialTheme.typography.headlineSmall)
//                    Spacer(modifier = Modifier.height(15.dp))
//                }
//                items(imageId.team?: emptyList()){ teamMember->
//                    TeamListItem(teamMember)
//                    Divider()
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CoinDetailScreenPreview(){
    ErakulisTestTheme {
    }
}
