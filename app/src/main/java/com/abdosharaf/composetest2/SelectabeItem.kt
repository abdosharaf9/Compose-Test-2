package com.abdosharaf.composetest2

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    titleStyle: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        color = if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
    ),
    subTitle: String? = null,
    subtitleStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = if (selected) MaterialTheme.colorScheme.onSurface
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
    ),
    borderWidth: Dp = 1.dp,
    borderColor: Color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    borderShape: Shape = RoundedCornerShape(10.dp),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor: Color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    onClick: () -> Unit
) {
    val columnScale = remember { Animatable(initialValue = 1f) }
    val iconScale = remember { Animatable(initialValue = 1f) }

    LaunchedEffect(key1 = selected) {
        if (selected) {
            launch {
                columnScale.animateTo(
                    targetValue = 0.9f,
                    animationSpec = tween(durationMillis = 50)
                )
                columnScale.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }

            launch {
                iconScale.animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(durationMillis = 50)
                )
                iconScale.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
        }
    }

    Column(
        modifier = modifier
            .scale(columnScale.value)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            )
            .clip(borderShape)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = titleStyle,
                modifier = Modifier.weight(8f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(
                onClick = onClick,
                modifier = Modifier
                    .weight(2f)
                    .scale(iconScale.value)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = if (selected) "Uncheck" else "Check",
                    tint = iconColor
                )
            }
        }

        if (subTitle != null) {
            Text(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 12.dp
                ),
                text = subTitle,
                style = subtitleStyle,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}