package cn.com.hangsheng.neleus

import android.accessibilityservice.AccessibilityService
import android.annotation.TargetApi
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.util.Log

/**
 * Created by hsae on 2018/1/29.
 */
@TargetApi(16)
class NeleusAccessibilityOperator {
    private var mAccessibilityService:AccessibilityService?=null
    private var mAccessibilityEvent:AccessibilityEvent?=null
    companion object {
        private var mInstance =NeleusAccessibilityOperator()
        fun getInstance():NeleusAccessibilityOperator{
            return mInstance
        }
    }
    fun init(){
        Log.e("AccessibilityLog","hello world!!!")
    }

    fun updateEvent(service: AccessibilityService?, event: AccessibilityEvent?) {
        if (service != null && mAccessibilityService == null) {
            mAccessibilityService = service
        }
        if (event != null) {
            mAccessibilityEvent = event
        }
        //Log.e("AccessibilityLog","hello world!!!"+service.toString()+event.toString())
    }
}