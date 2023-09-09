apply {
    from("$rootDir/base-module.gradle")
}
dependencies {
    "implementation"(project(Modules.core))
}
tasks.withType(type = org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask::class) {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}
