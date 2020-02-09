# PTT Reader Android

## Introduction

This is my demo project of making a Android app.

I would like to demonstrate:
- Android app with HTTP request
- Android unit testing
- Android UI testing (with [Espresso idling resources](https://developer.android.com/training/testing/espresso/idling-resource))

Here are some of the documents that helps me to complete the app:

- Android
  - [Automate user interface tests](https://developer.android.com/training/testing/ui-testing)
  - [Test UI for a single app](https://developer.android.com/training/testing/ui-testing/espresso-testing)
  - [Test UI for multiple apps](https://developer.android.com/training/testing/ui-testing/uiautomator-testing.html)
  - [Create UI tests with Espresso Test Recorder](https://developer.android.com/studio/test/espresso-test-recorder)
  - [Android Espresso](https://developer.android.com/training/testing/espresso)
  - [Android UI Automator](https://developer.android.com/training/testing/ui-automator)
  - [Android testing example](https://github.com/android/testing-samples)

## Code coverage

Make code coverage up to **96%**

**Generate code coverage report by running command line:**
```
./gradlew clean createDebugCoverageReport
```

<img src="https://github.com/hayasilin/ptt-reader-android/blob/master/resource/code_coverage_report.png">
