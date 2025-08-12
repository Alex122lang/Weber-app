import android.annotation.SuppressLint
import android.content.Context
import android.widget.FrameLayout
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.alex.weber.R
import com.alex.weber.ui.screens.home.HomeViewModel


@SuppressLint("UseKtx", "SuspiciousIndentation")
@Composable
fun Home(innerPadding : PaddingValues, homeViewModel: HomeViewModel= viewModel()){
    val context = LocalContext.current.applicationContext
       Box(
           contentAlignment = Alignment.BottomEnd,
           modifier = Modifier
               .fillMaxSize()
               .padding(innerPadding)
               .background(Color.White),
       ) {
           val posts =homeViewModel.posts.collectAsState()
           GetExoplayer(context ,posts.value)
//     Right side interraction buttons
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(end = 16.dp, bottom = 80.dp).fillMaxHeight()
        ) {

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                IconButton(onClick = {
                    Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "notification icon",
                    )
                }


                IconButton(onClick = {
                    Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.settings),
                        contentDescription = "settings icon",
                    )
                }
            }

            Column() {

                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Like",
                        tint = Color.Black,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
// Share logic
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color.Black,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape).clickable(onClick = { })
                )
            }
        }
    }
    }


@SuppressLint("ConfigurationScreenWidthHeight")
@androidx.annotation.OptIn(UnstableApi::class)
@OptIn(UnstableApi::class)

@Composable
fun GetExoplayer(context: Context, posts: List<com.alex.weber.data.models.Post>) {
    val configuration = LocalConfiguration.current


    val screenHeight = configuration.screenHeightDp.dp
   LazyColumn(modifier = Modifier.fillMaxHeight() ) {
        itemsIndexed(posts) { index, video ->
            val player = remember {
                ExoPlayer.Builder(context).build().apply {
                    setMediaItem(androidx.media3.common.MediaItem.fromUri(video.image_url!!))
                    prepare()
                    playWhenReady = true
                }
            }
            AndroidView(
                modifier = Modifier.height(height = screenHeight),
                factory = {
                    PlayerView(context).apply {
                        this.player = player//getExoplayer(item.toString() , context)
                        useController = false
                        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                        layoutParams = FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            FrameLayout.LayoutParams.MATCH_PARENT
                        )
                    }
                },

                )
        }
    }
}











