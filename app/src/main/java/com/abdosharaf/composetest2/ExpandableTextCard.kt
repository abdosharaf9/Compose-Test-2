package com.abdosharaf.composetest2

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Test() {
    ExpandableTextCard(
        title = "The Title",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sodales laoreet commodo. Phasellus a purus eu risus elementum consequat. Aenean eu elit ut nunc convallis laoreet non ut libero. Suspendisse interdum placerat risus vel ornare. Donec vehicula, turpis sed consectetur ullamcorper, ante nunc egestas quam, ultricies adipiscing velit enim at nunc."
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableTextCard(
    title: String,
    description: String,
    titleTextStyle: TextStyle = TextStyle(
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    descriptionTextStyle: TextStyle = TextStyle(
        color = Color.DarkGray,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    cardShape: Shape = RoundedCornerShape(8.dp),
    animationSpec: FiniteAnimationSpec<IntSize> = tween(
        durationMillis = 300,
        easing = LinearOutSlowInEasing
    )
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val rotation by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f, label = "")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(animationSpec = animationSpec),
        shape = cardShape,
        onClick = { isExpanded = !isExpanded }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = titleTextStyle
                )

                IconButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier
                        .alpha(alpha = 0.6f)
                        .rotate(rotation)
                        .size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = if (isExpanded) "Collapse" else "Expand",
                        tint = Color.Black
                    )
                }
            }

            if (isExpanded) {
                Text(
                    text = description,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = descriptionTextStyle
                )
            }
        }
    }
}