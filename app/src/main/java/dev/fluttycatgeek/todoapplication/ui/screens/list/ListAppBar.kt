package dev.fluttycatgeek.todoapplication.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.fluttycatgeek.todoapplication.R
import dev.fluttycatgeek.todoapplication.core.Priority
import dev.fluttycatgeek.todoapplication.ui.components.PriorityItem
import dev.fluttycatgeek.todoapplication.ui.theme.LARGE_PADDING
import dev.fluttycatgeek.todoapplication.ui.theme.Typography
import dev.fluttycatgeek.todoapplication.ui.theme.topAppBarBackgroundColor
import dev.fluttycatgeek.todoapplication.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {})
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.tasks),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchActions(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchActions(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_tasks),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(
                R.string.sort_tasks
            ),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false })
        {
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.LOW)
            }


            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            }) {
                PriorityItem(priority = Priority.HIGH)
            }


            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            }) {
                PriorityItem(priority = Priority.NONE)
            }
        }


    }

}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteClicked()
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = LARGE_PADDING),
                    text = stringResource(id = R.string.delete_all_action),
                    style = Typography.subtitle2
                )
            }
        }
    }
}


@Composable
@Preview
fun DefaultListAppBarPreview() {
    DefaultListAppBar(onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {})
}