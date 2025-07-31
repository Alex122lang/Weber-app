import android.media.browse.MediaBrowser.MediaItem
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.alex.weber.ui.theme.GreenJC
import com.alex.weber.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun Home(innerPadding : PaddingValues){
    Box(contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
        .fillMaxSize()
            .padding(innerPadding)
        .background(Color.White),
         ){
        Column (
            modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Home", fontSize = 30.sp, color = GreenJC)
        }

//     Right side interraction buttons
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(end = 16.dp, bottom = 80.dp)

//        verticalArrangement = Arrangement.spacedBy(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
        ){
            IconButton(onClick = {  }){
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Like",
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
// Share logic
            IconButton(onClick = {  }){
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
// Profile logic
//            IconButton(onClick = { }){
//                Icon(
//                    imageVector = Icons.Outlined.Person,
//                    contentDescription = "Profile",
//                    tint = Color.White,
//                    modifier = Modifier.size(32.dp)
//                )
//            }
//            Spacer(modifier = Modifier.size(8.dp))
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










//@Composable
//fun VideoPlayerScreen() {
//    val context = LocalContext.current
//    var playWhenReady by remember { mutableStateOf(true) }
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
//            )
//            repeatMode = ExoPlayer.REPEAT_MODE_ALL
//            playWhenReady = playWhenReady
//            prepare()
//            play()
//        }
//    }
//    androidx.compose.runtime.DisposableEffect(
//        AndroidView(
//            modifier = Modifier.fillMaxSize(),
//            factory = {
//                PlayerView(context).apply {
//                    player = exoPlayer
//                    useController = true
//                    FrameLayout.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT
//                    )
//                }
//            }
//        )
//    ) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//}




