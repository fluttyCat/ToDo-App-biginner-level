package dev.fluttycatgeek.todoapplication.core

import androidx.compose.ui.graphics.Color
import dev.fluttycatgeek.todoapplication.ui.theme.HighPriorityColor
import dev.fluttycatgeek.todoapplication.ui.theme.LowPriorityColor
import dev.fluttycatgeek.todoapplication.ui.theme.MediumPriorityColor
import dev.fluttycatgeek.todoapplication.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {

    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}