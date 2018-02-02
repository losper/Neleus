package cn.com.hangsheng.neleus

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo

/**
 * Created by hsae on 2018/1/30.
 */

class NeleusAccessibilityProcess : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var inst=NeleusAccessibilityOperator.getInstance()

        inst.actionFrom()
        Thread.sleep(3000)
        var list=inst.findNodesByText("音乐")
        Log.e("NeleusAccessibilityLog",list.toString())
        list?.forEach {
            var n = it
            while (true) {
                if (n.parent == null || n.isClickable) {
                    break
                } else {
                    Log.e("NeleusAccessibilityLog", n.toString())
                    Log.e("NeleusAccessibilityLog", "info:" + n.className + n.isClickable)
                    n.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    n = n.parent
                }
            }
            Log.e("NeleusAccessibilityLog", n.toString())
            n.performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }
}
