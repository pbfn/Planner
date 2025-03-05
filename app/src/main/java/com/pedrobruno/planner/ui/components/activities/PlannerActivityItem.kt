package com.pedrobruno.planner.ui.components.activities

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.R
import com.pedrobruno.planner.ui.theme.Lime300
import com.pedrobruno.planner.ui.theme.Zinc100
import com.pedrobruno.planner.ui.theme.Zinc400
import com.pedrobruno.planner.ui.theme.Zinc900

@Composable
fun PlannerActivityItem(modifier: Modifier = Modifier, item: ActivityItem) {

    val icon = if (item.isDone)
        R.drawable.circle_check
    else R.drawable.circle_dashed

    val tintIcon = if (item.isDone)
        Lime300
    else Zinc400

    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 0.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .shadow(
                elevation = 8.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Zinc900
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(icon),
                tint = tintIcon,
                contentDescription = "icon_isDone"
            )
            Spacer(Modifier.width(16.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = item.description,
                style = MaterialTheme.typography.bodyMedium.copy(color = Zinc100)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = item.data,
                style = MaterialTheme.typography.bodySmall.copy(color = Zinc400)
            )
        }
    }
}

@Preview(name = "default")
@Composable
private fun PlannerActivityItem0() {
    PlannerActivityItem(
        item = ActivityItem(
            description = "Text",
            isDone = false,
            data = "sábado, dia 18 às 08:00h"
        )
    )
}

@Preview(name = "done")
@Composable
private fun PlannerActivityItem1() {
    PlannerActivityItem(
        item = ActivityItem(
            description = "Text",
            isDone = true,
            data = "sábado, dia 18 às 08:00h"
        )
    )
}

data class ActivityItem(
    val description: String,
    val isDone: Boolean,
    val data: String
)