package dev.fluttycatgeek.todoapplication.ui.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.fluttycatgeek.todoapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navigationToTaskScreen: (Int) -> Unit
) {
    Scaffold(content = {},
        floatingActionButton = {
            ListFab(onFabClicked = navigationToTaskScreen)
        })
}

@Composable
fun ListFab(onFabClicked: (Int) -> Unit) {
    FloatingActionButton(onClick = {
        onFabClicked(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )
    }
}

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigationToTaskScreen = {})
}