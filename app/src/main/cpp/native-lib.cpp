#include <jni.h>
#include <string>
#include <boost/asio.hpp>
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
Java_cn_com_hangsheng_neleus_MainActivity_jsload(
        JNIEnv *env,
        jobject /* this */obj,
        jstring path) {
    std::string hello = "Hello from C++";
    boost::asio::io_service ios;
    ios.run();
    char buf[200];
    strcpy(buf,"刘文军");
    return env->NewStringUTF(buf);
}