package com.abdosharaf.composetest2

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Small Font",
    group = "Small Font Group",
    fontScale = 0.5f,
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Small Font",
    group = "Small Font Group",
    fontScale = 0.5f,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    name = "Normal Font",
    group = "Normal Font Group",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Normal Font",
    group = "Normal Font Group",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    name = "Large Font",
    group = "Large Font Group",
    fontScale = 1.5f,
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Small Font",
    group = "Small Font Group",
    fontScale = 1.5f,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
annotation class FontPreviews