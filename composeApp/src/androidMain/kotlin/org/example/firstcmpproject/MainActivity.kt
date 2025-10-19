package org.example.firstcmpproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import android.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.example.firstcmpproject.core.persistence.getDatabaseBuilderAndroid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
        )
        super.onCreate(savedInstanceState)
        val databaseBuilder = getDatabaseBuilderAndroid(this)
        setContent {
            App(databaseBuilder)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val databaseBuilder = getDatabaseBuilderAndroid(LocalContext.current)
    App(databaseBuilder)
}