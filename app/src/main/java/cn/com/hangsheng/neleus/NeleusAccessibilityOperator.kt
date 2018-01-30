package cn.com.hangsheng.neleus

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityService.GLOBAL_ACTION_HOME
import android.annotation.TargetApi
import android.os.Build
import android.view.accessibility.AccessibilityEvent
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo

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
        Log.e("NeleusAccessibilityLog","Msg!!!"+service.toString()+event.toString())
    }

    fun findNodesByText(s: String): MutableList<AccessibilityNodeInfo>? {
        var list=getRootNodeInfo()?.findAccessibilityNodeInfosByText(s)
        return list
    }

    private fun getRootNodeInfo():AccessibilityNodeInfo? {
        var node:AccessibilityNodeInfo?=null
        node = if (Build.VERSION.SDK_INT>=16){
            mAccessibilityService?.rootInActiveWindow
        }else {
            mAccessibilityEvent?.source
        }
        return node
    }
    fun actionFrom(){
        mAccessibilityService?.performGlobalAction(GLOBAL_ACTION_HOME);
    }
}

