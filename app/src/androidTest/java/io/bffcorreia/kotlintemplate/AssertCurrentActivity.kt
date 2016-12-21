package io.bffcorreia.kotlintemplate

import android.app.Activity
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage
import org.junit.Assert.assertEquals

object AssertCurrentActivity {

  fun assertCurrentActivity(activityClass: Class<out Activity>) {
    assertEquals(activityClass.name, getCurrentActivity()?.componentName?.className)
  }

  private fun getCurrentActivity(): Activity? {
    getInstrumentation().waitForIdleSync()
    val activity = arrayOfNulls<Activity>(1)
    getInstrumentation().runOnMainSync({
      val activities = ActivityLifecycleMonitorRegistry.getInstance()
          .getActivitiesInStage(Stage.RESUMED)
      activity[0] = activities.iterator().next()
    })
    return activity[0]
  }
}
