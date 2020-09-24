import de.fayard.refreshVersions.bootstrapRefreshVersions

include(":data")


buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.5")
}

plugins {
    id("com.gradle.enterprise").version("3.1.1")
}

bootstrapRefreshVersions()

rootProject.name="MachineACompose"
include(":app")
