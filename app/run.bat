adb push E:\git\laboratory\Neleus\app\build\outputs\apk\debug\app-debug.apk /data/local/tmp/cn.com.hangsheng.neleus
adb shell pm install -t -r "/data/local/tmp/cn.com.hangsheng.neleus"

adb shell am start -n "cn.com.hangsheng.neleus/cn.com.hangsheng.neleus.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER