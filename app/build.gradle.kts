plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.maximus.dxhub.android_performance_analyzer"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.maximus.dxhub.android_performance_analyzer"
        minSdk = 30
        targetSdk = 36
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

    // Define flavor dimensions
    // Each dimension represents a category of flavors (e.g., product type, environment)
    flavorDimensions += listOf("flav", "type")

    // Define product flavors
    productFlavors {

        // DXHub Enrollment flavor
        // This represents one variant of the app under the "flav" dimension
        create("laeb") {
            dimension = "flav"
            // Additional flavor-specific configuration can be added here if needed
        }


        // UAT environment flavor
        // Represents the "type" dimension (environment)
        create("uat") {
            dimension = "type"
            // Host URL for the environment
            buildConfigField(
                "String",
                "HOST",
                "\"http://dxhub-dev-tenant-config-lb-1885688659.us-east-1.elb.amazonaws.com:8082/services/dxh-tenantconfig/config/maximus/\""
            )
            buildConfigField("boolean", "SHOW_TEST_DATA", "false")  // Disable test data
            buildConfigField("String", "SHARED_PREFERENCES_NAME", "\"shared_maximus_uat\"")
            buildConfigField("String", "DATABASE_NAME", "\"db_maximus_uat\"")
        }


        // Dev environment flavor
        create("dev") {
            dimension = "type"
        }


        // Staging environment
        create("staging") {
            dimension = "type"
        }

        // Production environment
        create("prod") {
            dimension = "type"
        }

        // Dev environment flavor
        create("eTest") {
            dimension = "type"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
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
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}