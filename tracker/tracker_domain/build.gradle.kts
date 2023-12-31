apply {
    from("$rootDir/base-module.gradle")
}
tasks.withType(type = org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask::class) {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}
dependencies {
    "implementation"(project(Modules.core))
    "implementation"(Coroutines.coroutines)
}