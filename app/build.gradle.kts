plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.androidsdktutorial"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidsdktutorial"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("io.karte.android:core:2.+") //イベントトラッキング機能を提供します。
    implementation("io.karte.android:inappmessaging:2.+") //アプリ内メッセージ機能を提供します。
    implementation("io.karte.android:notifications:2.+") //プッシュ通知の受信および効果測定機能を提供します。
    implementation("io.karte.android:variables:2.+") //設定値配信機能を提供します。
    implementation("io.karte.android:visualtracking:2.+") //ビジュアルトラッキング機能を提供します。※ 別途Gradle Pluginが必要です。
    implementation("io.karte.android:inbox:0.+") // Push通知の送信履歴を取得する機能を提供します（β版）。
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}