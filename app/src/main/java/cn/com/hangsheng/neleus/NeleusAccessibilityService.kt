package cn.com.hangsheng.neleus
import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.view.accessibility.AccessibilityEvent
import android.util.Log
/**
 * Created by hsae on 2018/1/29.
 */
class NeleusAccessibilityService : AccessibilityService(){
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        //val pkgName= event?.packageName.toString()
        //val type= event?.eventType
        Log.e("Log:","eventType:"+event);
        NeleusAccessibilityOperator.getInstance().updateEvent(this,event)
        return
        /*when (type) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
                ,AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
                NeleusAccessibilityOperator.getInstance().updateEvent(this,event)
            }
        }*/
    }

    override fun onInterrupt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    public override fun onServiceConnected() {
        super.onServiceConnected()
        Log.e("et","test service!!!!")
        //NeleusAccessibilityOperator.getInstance().find();
    }

}