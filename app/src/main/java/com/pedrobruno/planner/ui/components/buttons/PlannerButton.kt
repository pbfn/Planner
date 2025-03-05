package com.pedrobruno.planner.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pedrobruno.planner.ui.theme.Lime300
import com.pedrobruno.planner.ui.theme.Lime950

@Composable
fun PlannerButton(
    modifier: Modifier = Modifier,
    text: String,
    disable: Boolean,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.heightIn(42.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Lime300,
            disabledContainerColor = Lime300.copy(alpha = 0.6f)
        ),
        onClick = onClick,
        enabled = !disable
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = TextStyle(
                    //fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Lime950
                )
            )
        }
    }
}

@Preview(name = "Button defaulted")
@Composable
fun PlannerButtonPreview0() {
    PlannerButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Label",
        disable = false
    ) { }
}

@Preview(name = "Button disabled")
@Composable
fun PlannerButtonPreview1() {
    PlannerButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Label",
        disable = true
    ) { }
}