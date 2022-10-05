# Barclays UI tests

### Rewards card eligibility test
:white_check_mark: Open Check your eligibility page

:white_check_mark: Select Barclays rewards card

:white_check_mark: Click Check your eligibility

:white_check_mark: Switch to new tab

:white_check_mark: Fill the form

:white_check_mark: Input fields should be successfully filled

### Existing client error
:white_check_mark: Open Eligibility form 

:white_check_mark: Mark User is existing customer checkbox

:white_check_mark: Error text "If you already have a Barclaycard, you can use the Barclays or Barclaycard app..." should be displayed under the checkbox area

### Title and gender mismatch error
:white_check_mark: Open Eligibility form

:white_check_mark: Mark User is not existing customer checkbox

:white_check_mark: Select Mrs title

:white_check_mark: Select Male gender

:white_check_mark: Error text "Your gender does not match the title you provided..." should be displayed under the checkbox area

### Page title test
:white_check_mark: Open Check your eligibility page

:white_check_mark: Page title should have text 'Credit card eligibility checker | Barclays'

### Console log test
:white_check_mark: Open Check your eligibility page

:white_check_mark: Console logs should not contain text 'SEVERE'
      
## Technology Stack

Java, Gradle, Intelij Idea, Selenide, JUnit5, Jenkins, Allure Report

![This is an image](/design/icons/Java.png)![This is an image](/design/icons/Gradle.png)![This is an image](/design/icons/Intelij_IDEA.png)![This is an image](/design/icons/Selenide.png)![This is an image](/design/icons/JUnit5.png)![This is an image](/design/icons/Jenkins.png)![This is an image](/design/icons/Allure_Report.png)

# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/C12-ntlymar-barclays/">jenkins.autotests.cloud/job/%s</a>


# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```




