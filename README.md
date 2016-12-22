# Android app starter template (with Kotlin)

Based on [blocoio/android-template](https://github.com/blocoio/android-template).

## Features

- Simplified clean architecture with 3 layers
    - Data (for models, database, API and preferences)
    - Domain (for business logic)
    - Presentation (for views and presenters)
- Tests
    - Unit tests
    - Instrumentation tests (with [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/))
- Dependency injection (with [Dagger v2](https://google.github.io/dagger/))
- View injection (with [Butterknife](https://jakewharton.github.io/butterknife/))
- Preconditions
- Google Design library
- Logging (with [Timber](https://github.com/JakeWharton/timber))
- Resource defaults
    - colors.xml
    - dimens.xml
    - stings.xml
    - styles.xml

## Getting started

1. Download this repository and open it on Android Studio
1. Rename the app package `io.bffcorreia.kotlintemplate`
1. On `app/build.gradle`, change the applicationId to the new app package
1. On `app/build.gradle`, update the dependencies Android Studio suggests
1. On `string.xml`, set your application name
1. On `colors.xml`, set your application primary and secondary colors

And you're ready to start working on your new app.

## To Do

- RecyclerView example
- CustomView example
- Survive configuration changes
- SharedPreferences helper
- More...