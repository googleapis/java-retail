# Google Retail Search
## Java code samples
The code here demonstartes how to consume Google Retail Search API in Java

### Authorization
In order to authenticate and authorize the client place a JSON file with authorization token to your cloudshell project and refer environment variable `GOOGLE_APPLICATION_CREDENTIALS` to it (use full path to file):

```
export GOOGLE_APPLICATION_CREDENTIALS="/home/use_name/cloudshell_open/grs-retail/token.json"
```

### Define environment variable
Set PROJECT_NUMBER value as an environment variable.
### Running code samples

Use maven command to run specific code sample:
```
mvn compile exec:java -Dexec.mainClass="CodeSampleClass"
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
