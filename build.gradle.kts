plugins {
    kotlin("multiplatform") version "1.9.20"
}

group = "dev.denwav"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    withSourcesJar()

    // This is a common-only Kotlin multiplatform library
    // There is no way to publish just a common-only library yet (hopefully with the new unified IR we will be able to soon)
    // So instead, just define targets so that we produce artifacts for the 3 major categories: JVM, JS, Native
    //
    // For actually building executables more specific categories are necessary, but these will simply prodice IR klib
    // binaries for each meta-platform

    // JVM
    jvm()
    // JS
    js().nodejs()

    // Native - got a bunch listed so any platform should be able to build & publish this
    macosArm64()
    macosX64()
    linuxX64()
    linuxArm64()
    mingwX64()

    sourceSets.all {
        languageSettings.optIn("kotlin.ExperimentalStdlibApi")
        languageSettings.optIn("kotlin.contracts.ExperimentalContracts")
    }
    sourceSets.jvmTest.dependencies {
        implementation(kotlin("test-junit5"))
        implementation("io.mockk:mockk:1.13.8")

    }
    sourceSets.jsTest.dependencies {
        implementation(kotlin("test-js"))
    }
    sourceSets.commonTest {
        dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}
