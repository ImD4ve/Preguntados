plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.example.preguntados"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.preguntados"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.core.ktx.v1120)
    implementation (libs.androidx.appcompat)
    implementation (libs.material)
    implementation (libs.androidx.constraintlayout)

    // Para usar viewBinding (opcional pero recomendado)
    implementation (libs.androidx.activity.ktx)

    // Para animaciones (opcional)
    implementation (libs.library)

    // Para manejar imágenes (si necesitas cargar imágenes desde URL)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
    implementation (libs.androidx.core.ktx)
    implementation (libs.androidx.appcompat.v161)
    implementation (libs.material.v1110) // Para íconos y componentes Material
    implementation (libs.androidx.constraintlayout.v214)

    implementation (libs.androidx.room.runtime)
    implementation(libs.androidx.room.runtime.v261)
    implementation (libs.androidx.room.ktx)
    annotationProcessor (libs.androidx.room.compiler.v271)

    // Lifecycle components
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // Kotlin Coroutines
    implementation (libs.kotlinx.coroutines.android)
    ksp(libs.androidx.room.compiler)



}