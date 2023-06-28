package dev.fluttycatgeek.todoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.fluttycatgeek.todoapplication.ui.navigation.SetupNavigation
import dev.fluttycatgeek.todoapplication.ui.theme.ToDoApplicationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoApplicationTheme {
                navController = rememberNavController()
                SetupNavigation(
                    navHostController = navController,
                )
            }
        }
    }
}

