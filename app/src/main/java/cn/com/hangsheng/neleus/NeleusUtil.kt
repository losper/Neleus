package cn.com.hangsheng.neleus
import android.content.Context
import android.provider.Settings
import android.util.Log

class NeleusUtil{
    companion object {
        fun isAccessibilityOn(context: Context): Boolean {
            if (context == null) {
                return false
            }
            var accessibilityEnabled = 0
            try {
                accessibilityEnabled = Settings.Secure.getInt(context.applicationContext.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED)
            } catch (e: Settings.SettingNotFoundException) {
                e.printStackTrace()
            }

            if (accessibilityEnabled == 1) {
                var settingVal=Settings.Secure.getString(context.applicationContext.contentResolver,Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES)
                Log.e("settingVal",settingVal)
                return true
            }
            return false
        }
    }
}