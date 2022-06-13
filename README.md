# CFCU

Hello & Welcome,

This is a small project where the objective is to write a Mobile App which utilizes REST from the back end to communicate with a third party API to get & post data. The backend uses GraphQL and an MVC design pattern in order to send data to the FE and store updates within memory. In addition to MVC the project has a service class which acts as a facade to the underlying CRUD repository. You may test this by simply making updates to a CreditCard and then closing the browser window and/or opening a second window. When you come back to the home page and/or close & re-open you will notice that the updates have remained. 

In order to execute this project please use gradle...
  - ./gradlew bootRun
  - Open Browser and goto http://localhost:8080
 
Build Details
  - openjdk version "18.0.1.1"
  - Gradle 7.3.1

Tech Stack
  - Java Spring Boot
  - GraphQL
  - Onsen UI 
  - Javascript 
  - HTML5 
  - JQuery 
  - CSS

The app is best viewed emulating a Mobile device...

<BR><BR>
Single Page Application - Screenshot shows opening view with users Credit Cards 
![Screenshot from 2022-06-13 01-28-05](https://user-images.githubusercontent.com/73296833/173341154-34097d39-bc90-485f-8471-9fa5032d3f4f.png)

<BR><BR>
Single Page Application - This view allows the user to update their Credit Card Status, Comment and Enable/Disable.
![Screenshot from 2022-06-13 01-26-00](https://user-images.githubusercontent.com/73296833/173341214-abeb20c7-5097-4859-b949-a803614723f4.png)
