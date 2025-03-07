package com.pedrobruno.planner.widget

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.pedrobruno.planner.R
import com.pedrobruno.planner.data.model.ActivityItem
import com.pedrobruno.planner.data.model.mock.mockedListActivities
import com.pedrobruno.planner.ui.theme.Zinc100
import com.pedrobruno.planner.ui.theme.Zinc400
import com.pedrobruno.planner.ui.theme.Zinc900

class MyAppWidget : GlanceAppWidget() {
    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        provideContent {
            MyContent()
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
private fun MyContent() {
    Column(
        modifier = GlanceModifier.fillMaxSize().background(Zinc900),
        verticalAlignment = Alignment.CenterVertically,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(mockedListActivities) { item ->
                PlannerActivityItem(item = item)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewContent() {

    MyContent()
}

@SuppressLint("RestrictedApi")
@Composable
fun PlannerActivityItem(item: ActivityItem) {
    val icon = if (item.isDone)
        R.drawable.circle_check_lime
    else R.drawable.circle_dashed

    Row(
        modifier = GlanceModifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            ImageProvider(icon),
            contentDescription = "image_icon",
            modifier = GlanceModifier.size(20.dp).clickable { }
        )
        Text(
            modifier = GlanceModifier.padding(start = 12.dp).defaultWeight(),
            text = item.description, style = TextStyle(
                fontSize = 16.sp,
                color = ColorProvider(Zinc100)
            )
        )
        Column(
            GlanceModifier.padding(end = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                item.data, style = TextStyle(
                    fontSize = 16.sp,
                    color = ColorProvider(Zinc400)
                )
            )
            Text(
                item.hour, style = TextStyle(
                    fontSize = 16.sp,
                    color = ColorProvider(Zinc400)
                )
            )
        }
    }
}