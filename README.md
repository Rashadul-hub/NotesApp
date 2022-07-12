# NotesApp
 This is a simple note taking app in Android with Integrated API. In this project  have covered everything that is required to create a fully functional app.

Features
* MVVM Setup
* HILT
* Coroutines
* API Integration using Retrofit
* Interceptors for Authenticated Flows.
* Handling validations and loading state.
* Complete Signup/Login Flow

# Screen Shots

<img width="1280" alt="Screen Shot 2022-07-12 at 9 24 21 PM" src="https://user-images.githubusercontent.com/84420804/178562778-e9b644ef-e24a-4fc7-a95e-fcd42c874a83.png">
<img width="1280" alt="Screen Shot 2022-07-12 at 9 24 10 PM" src="https://user-images.githubusercontent.com/84420804/178562794-7303e603-43ae-4725-ba8e-4781a9c73d2e.png">
<img width="1280" alt="Screen Shot 2022-07-12 at 9 24 03 PM" src="https://user-images.githubusercontent.com/84420804/178562800-7c8fad9e-a16b-4a17-85da-5047d68ccba2.png">
<img width="1280" alt="Screen Shot 2022-07-12 at 9 23 33 PM" src="https://user-images.githubusercontent.com/84420804/178562801-5f793109-3bda-4035-91dd-de6ca9e40e31.png">
<img width="1280" alt="Screen Shot 2022-07-12 at 9 23 20 PM" src="https://user-images.githubusercontent.com/84420804/178562806-790b6c12-5466-4407-ac6e-934030ebdf72.png">

# Before starting project add the following steps :

Step 1)
In build.gradle(Module):


plugins {

    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'

}

android {

	buildFeatures {
    		viewBinding true	
	}

	kapt {
    		correctErrorTypes true
	}
}


dependencies {

    implementation 'com.google.dagger:hilt-android:2.42'
    kapt 'com.google.dagger:hilt-compiler:2.42'


    def lifecycle_version = "2.6.0-alpha01"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

    def retrofit_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation 'com.squareup.okhttp3:okhttp:4.9.3'

    def room_version = "2.4.2"
    implementation "androidx.room:room-runtime:$room_version"
    implementation "androidx.room:room-ktx:$room_version"
    kapt "androidx.room:room-compiler:$room_version"

    def coroutines_version = "1.6.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

    def navigation_version = "2.5.0"
    implementation "androidx.navigation:navigation-fragment-ktx:$navigation_version"
    implementation "androidx.navigation:navigation-ui-ktx:$navigation_version"

    implementation "com.github.ybq:Android-SpinKit:$androidSpinkitVersion2"
}



Step 2)
Android Mainfest.xml { 

  uses-permission android:name="android.permission.INTERNET"

}


Step 3)
replace this on build.gradle(Project):

ext {

    androidSpinkitVersion = '1.4.0'
    androidSpinkitVersion1 = androidSpinkitVersion
    androidSpinkitVersion2 = androidSpinkitVersion1

}// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:7.2.1'
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10'
        classpath 'com.google.dagger:hilt-android-gradle-plugin:2.42'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}



task clean(type: Delete) {

    delete rootProject.buildDir

}



Step 4)
Replace this on setting.gradle(project settings) :


pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
    
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' 
        
        }
    }

}
