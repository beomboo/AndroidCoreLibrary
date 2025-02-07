plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

group = "com.github.bkc"
version = "1.0.27"

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    namespace = "kr.co.bkc.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    publishing {
        singleVariant("release") { // ✅ release 컴포넌트 생성
            withSourcesJar()
            withJavadocJar()
        }
    }
}

// ✅ Maven Publish 설정 추가
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"]) // ✅ release 컴포넌트 사용
                groupId = "com.github.bkc"  // ✅ 원하는 그룹 ID (JitPack에 맞게 설정)
                artifactId = "core"    // ✅ 원하는 아티팩트 ID (라이브러리 이름)
                version = "1.0.27"
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}