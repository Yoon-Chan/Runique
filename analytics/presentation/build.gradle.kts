plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.chan.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}