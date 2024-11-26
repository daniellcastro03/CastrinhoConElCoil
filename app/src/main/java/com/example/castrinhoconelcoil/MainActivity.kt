package com.example.castrinhoconelcoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.castrinhoconelcoil.ui.theme.CastrinhoConElCoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CastroConCoilApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CastroConCoilApp() {
    Scaffold(
        topBar = { AppTopBar() },
        content = { paddingValues ->
            FeedScreen(modifier = Modifier.padding(paddingValues))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Castro Con Coil",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF2F3D83)
        )
    )
}

@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PostCard(
                username = "will_estevao",
                profileImageUrl = "https://assets-es.imgfoot.com/media/cache/1200x675/estevao-messinho.jpg",
                postImageUrl = "https://i.dailymail.co.uk/1s/2024/06/24/14/86495681-0-image-m-71_1719234095245.jpg",
                description = "CAMPEAO DO BRASILEIRAO"
            )
        }
        item {
            PostCard(
                username = "juanferquintero",
                profileImageUrl = "https://media.diariouno.com.ar/p/9886355016226907fa93c957f1e69414/adjuntos/298/imagenes/009/449/0009449241/1200x0/smart/juanfer-quinterojpg.jpg",
                postImageUrl = "https://i.pinimg.com/736x/20/a7/7a/20a77a8191c67d812f24f06845e686d7.jpg",
                description = "CAMPEONES DE SUDAMERICANA"
            )
        }
    }
}

@Composable
fun PostCard(
    username: String,
    profileImageUrl: String,
    postImageUrl: String,
    description: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF33EA8C)
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = profileImageUrl,
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = username,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            // Imagen del post
            AsyncImage(
                model = postImageUrl,
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            InteractionBar()
            Text(
                text = description,
                modifier = Modifier.padding(8.dp),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun InteractionBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.Red)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Email, contentDescription = "Comment")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Share, contentDescription = "Share")
            }
        }
        IconButton(onClick = {}) {
            Icon(Icons.Default.Add, contentDescription = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCastroConCoilApp() {
    CastroConCoilApp()
}
