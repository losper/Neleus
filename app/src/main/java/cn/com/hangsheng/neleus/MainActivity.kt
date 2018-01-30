package cn.com.hangsheng.neleus

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity : AppCompatActivity() {
    fun onClick(view:android.view.View ){
        when (view?.id) {
            R.id.button -> {
               startActivity(Intent(this,NeleusAccessibilityProcess::class.java))
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NeleusAccessibilityOperator.getInstance().init()
        // Example of a call to a native method
        sample_text.text = stringFromJNI()+"\r\n"+loadScript("xxx")
        //if (isAccessibilitySettingOn(R.layout.))
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        if (NeleusUtil.isAccessibilityOn(this)){
            Log.e("Error","opened")
        }else {
            Log.e("Error","closed")
            startActivity(intent)
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String
    private external fun loadScript(path: String): String


    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
