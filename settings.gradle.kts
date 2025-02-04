pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            setUrl("https://androidx.dev/snapshots/builds/10707469/artifacts/repository")
        }
        google()
        mavenCentral()
    }
}
rootProject.name = "Jetpack Camera"
include(":app")
include(":feature:preview")
include(":domain:camera")
include(":camera-viewfinder-compose")
include(":feature:settings")
include(":data:settings")
include(":core:common")
include(":feature:quicksettings")
