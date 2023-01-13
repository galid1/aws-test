rootProject.name = "aws-test"

plugins {
    id("de.fayard.refreshVersions") version "0.23.0"
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
