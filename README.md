# finra-coding-challenge
### Requirement
Develop a Spring Boot application that will accept an arbitrary file with additional metadata via REST request and store it. The application must meet the following requirements.

1. A REST endpoint that accepts an arbitrary file plus additional metadata fields
   a. Metadata fields should include &quot;Name&quot;, &quot;Phone Number&quot; and &quot;Email Address&quot;.
   b. File and metadata should be stored in some way for retrieval later.
2. A REST endpoint for retrieving metadata information.
3. A UI that includes a form for submitting the file and the metadata.
   a. Form should include some basic CSS styling, either from scratch or using a library such as bootstrap.
   b. Form should include a submit button that sends the information to the server.
   c. On success (or failure), the result of the request should be displayed in the UI.
4. Code should be committed to GitHub with a README for how to run the application.
   a.Code should be production worthy code that meets your definition of done.
   
#### Based on the above requirement, the project is developed using spring boot and mvc framework to meet the needs. There are different pages that displays the UI to browse the file and add meta data, display the stored metadata and file. There is a in memory data base that I used to retrieve the file and metadata later. I have used in memory database to make it simple and there is no need for you to configure anything to run the project. When we make this project production ready we can shift to any other database or cloud storage based on the needs. There are 21 Unit tests that are added to make sure the code is working as expected and make it deployment ready. These tests will run when we package the code. In case of any tests fail the 'mvn package' will fail and we have to fix those tests to make the build process work. This way we will know if a change is effecting any other code in the project or not. Tests are very important, and code coverage is very important as well.

#### You can run the project using below commands.

# Clone And Run
### Clone the project

git clone https://github.com/abhinavAkey/finra-coding-challenge.git

#### Kindly make sure JAVA_HOME(this project requires Java 8) environment variable is configured and maven bin directory is added to PATH environment variable. 

### Run the following commands

cd finra-coding-challenge/coding-challenge

mvn package

cd target

java -jar coding-challenge-0.0.1-SNAPSHOT.jar

#### After running the above commands successfully, you should see the following messages.

.... Tomcat started on port(s): 8080 (http)

#### Now you can hit http://localhost:8080/ to load the project on your browser.

#### Once you load the project the initial screen will look like this.

![postman](https://user-images.githubusercontent.com/20955979/32707983-85d02a4c-c7f5-11e7-8cd0-fe1055e29136.png)

#### Click on the tab that says ```Add File & Meta Data``` to open the view that displays the meta data fields and option to browse the file. All the fields are required. The view looks as below

![postman](https://user-images.githubusercontent.com/20955979/32707984-861895a2-c7f5-11e7-88a9-4139bf36ec47.png)

#### Once you add all the fields and click ```Add File Meta Data``` button then your data will be saved. 

![postman](https://user-images.githubusercontent.com/20955979/32707981-84e81338-c7f5-11e7-8a82-e42fddab1f6e.png)

#### After the data is saved, you will be taken to the page as shown below. You can also go to the below page by clicking on ```Get File and Meta Data```.

![postman](https://user-images.githubusercontent.com/20955979/32707982-8562814a-c7f5-11e7-8c5e-459af7339fd5.png)

