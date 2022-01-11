# Google Retail Search

## Java code samples

The code here demonstartes how to consume Google Retail Search API in Java

## Get started with Google Cloud Retail

This step is required if this is the first Retail API Tutorial you run. Otherwise, you can skip it.

### Select your project and enable the Retail API

Google Cloud organizes resources into projects. This lets you collect all the related resources for
a single application in one place.

If you don't have a Google Cloud project yet or you're not the owner of an existing one, you can
[create a new project](https://console.cloud.google.com/projectcreate).

After the project is created, set your PROJECT_ID to a ```project``` variable.

1. Run the following command in Terminal:
    ```bash
    gcloud config set project <YOUR_PROJECT_ID>
    ```

1. Check that the Retail API is enabled for your Project in
   the [Admin Console](https://console.cloud.google.com/ai/retail/).

### Set up authentication

To run a code sample from the Cloud Shell, you need to authenticate. To do this, use the Application
Default Credentials.

1. Set your user credentials to authenticate your requests to the Retail API

    ```bash
    gcloud auth application-default login
    ```

1. Type `Y` and press **Enter**. Click the link in Terminal. A browser window should appear asking
   you to log in using your Gmail account.

1. Provide the Google Auth Library with access to your credentials and paste the code from the
   browser to the Terminal.

1. Run the code sample and check the Retail API in action.

**Note**: Click the copy button on the side of the code box to paste the command in the Cloud Shell
terminal and run it.

### Set the PROJECT_NUMBER environment variable

Because you are going to run the code samples in your own Google Cloud project, you should specify
the **project_number** as an environment variable. It will be used in every request to the Retail
API.

1. You can find the ```project_number``` in the Project Info card displayed on **Home/Dashboard**.

1. Set the environment variable with the following command:
    ```bash
    export PROJECT_NUMBER=<YOUR_PROJECT_NUMBER>
    ```

### Running code samples

Use maven command to run specific code sample:

```
mvn compile exec:java -Dexec.mainClass="package.CodeSampleClass"
```

### Running unit tests

Use maven command to run specific unit test class:

```
mvn test -Dtest=TestClassName
```

Use maven command to run all unit tests:

```
mvn test
```
