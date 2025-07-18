plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    // Assuming androidCompileSdk, androidMinSdk, androidTargetSdk are in libs.versions.toml
    compileSdk = libs
        .versions
        .compileSdkVersion
        .get()
        .toInt()

    namespace = "com.google.ar.sceneform.samples.chromakeyvideo"

    defaultConfig {
        applicationId = "com.google.ar.sceneform.samples.chromakeyvideo"

        minSdk = libs
            .versions
            .minimumSdkVersion
            .get()
            .toInt()
        targetSdk = libs
            .versions
            .targetSdkVersion
            .get()
            .toInt()
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    // For AGP 7.0+ (aaptOptions is deprecated)
    androidResources {
        noCompress.addAll(listOf("filamat", "ktx"))
    }
    // If on older AGP (e.g. < 7.0), you might need:
    // aaptOptions {
    //    noCompress("filamat", "ktx")
    // }
}

dependencies {
    // Assuming these aliases are defined in your libs.versions.toml
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment.ktx)

    releaseImplementation(libs.thomasgorisse.sceneform)
    // Or direct: releaseImplementation("com.gorisse.thomas.sceneform:sceneform:1.23.0")

    debugApi(project(":sceneform"))
}

