Zendesk Ticket Viewer

Information:
1. Server port: 8080
2. User Interface: http://localhost:8080
3. Back end: Spring Boot, Java, JUnit
4. Front end: React, Webpack, Babel


Steps to start the application on your local machine
1. Install Java SDK version 17 | Open Link https://www.oracle.com/java/technologies/downloads/
2. Install Node v17.0.1 | Open Link https://nodejs.org/en/download/current/
3. Ensure your path variables include jdk and nodejs path
4. Refer example below
5. ![img.png](img.png)
6. Install Maven Plugins in your IDE
7. Run mvn clean
8. Run mvn install
9. Run main class **_ZendeskTicketViewerRestApplication_**
10. This would start up the back end server.
11. Open Terminal. Go to directory: zendesk_ticket_viewer_ui
12. Run command: npm install .This would install all required npm modules and create a package-lock.json file.
13. Run command: npm start
14. Open http://localhost:8080





Steps performed to understand & implement the requirements
1. Through Postman using Basic Authentication Setup => Executed API https://zcczendeskcodingchallenge3911.zendesk.com/api/v2/imports/tickets/create_many to create sample tickets
2. Verified through JOB Import API to verify status of the job.
3. Understood the response of the API : https://zcczendeskcodingchallenge3911.zendesk.com/api/v2/tickets.json?page[size]=8 Experimented with different page sizes.
4. 