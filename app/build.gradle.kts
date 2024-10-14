plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")  // Habilita el uso de Parcelize
}

android {
    namespace = "com.example.practico3tindermo"
    compileSdkVersion(34)

    defaultConfig {
        applicationId = "com.example.practico3tindermo"
        minSdkVersion(26)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Dependencias básicas
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")

    // Dagger para inyección de dependencias
    kapt("com.google.dagger:dagger-compiler:2.44")
    implementation("com.google.dagger:dagger:2.44")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Glide para carga de imágenes
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    // Dependencias para pruebas unitarias
    testImplementation("junit:junit:4.13.2")

    // Dependencias para pruebas instrumentadas en Android
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
