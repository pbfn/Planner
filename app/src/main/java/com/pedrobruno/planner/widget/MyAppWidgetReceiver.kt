package com.pedrobruno.planner.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class MyAppWidgetReceiver() : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget = MyAppWidget()
}