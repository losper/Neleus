# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.


# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
message("[info] check!!!!!" ${CMAKE_ANDROID_ARCH_ABI})
set(BUILDALL OFF)
if(${CMAKE_ANDROID_ARCH_ABI} STREQUAL "arm64-v8a")
include_directories(D:/dev/androidsdk/boost/arm64/include/boost-1_65_1/)
LINK_DIRECTORIES (D:/dev/androidsdk/boost/arm64/lib)
set(BUILDALL ON)
endif()
if(${CMAKE_ANDROID_ARCH_ABI} STREQUAL "armeabi-v7a")
include_directories(D:/dev/androidsdk/boost/arm/include/boost-1_65_1/)
LINK_DIRECTORIES (D:/dev/androidsdk/boost/arm/lib)
set(BUILDALL OFF)
endif()
if(${BUILDALL})
add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp
             src/main/cpp/duktape.c
             src/main/cpp/duk_module_duktape.c)

target_link_libraries( # Specifies the target library.
             native-lib

             # Links the target library to the log library
             # included in the NDK.
             ${log-lib}
             boost_system-gcc-mt-1_65_1
             )

else()
add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib-empty.cpp
             )
target_link_libraries( # Specifies the target library.
            native-lib

            # Links the target library to the log library
            # included in the NDK.
            ${log-lib} )
endif()
