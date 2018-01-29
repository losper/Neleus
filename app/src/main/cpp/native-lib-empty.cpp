#include <jni.h>
#include <string>
#include "duktape.h"

extern "C"
JNIEXPORT jstring

JNICALL
Java_cn_com_hangsheng_neleus_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    const char* buf=hello.c_str();
    return env->NewStringUTF(buf);
}

extern "C"
JNIEXPORT jstring

JNICALL
Java_cn_com_hangsheng_neleus_MainActivity_loadScript(
        JNIEnv *env,
        jobject /* this */obj,
        jstring path) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF("mlgb");
}