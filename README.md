Zendesk Ticket Viewer
# Primary Information:
1. Server port: 8080
2. User Interface: http://localhost:8080
3. Back end: **_Spring Boot, Java, JUnit_**
4. Front end: **_React, Webpack, Babel_**


# Steps to start the application on your local machine
1. Install Java SDK version 17 | Open Link https://www.oracle.com/java/technologies/downloads/
2. Install Node v17.0.1 | Open Link https://nodejs.org/en/download/current/
3. Ensure your path variables include jdk and nodejs path
4. Refer example below
5. ![img.png](pathvariables.png)
6. Install Maven Plugins in your IDE
7. Run mvn clean
8. Run mvn install
9. **_Update your username and password in directory:_** **_zendesk_ticket_viewer_rest\zendesk_ticket_viewer_rest\src\main\resources\application.properties_**
10. Run main class **_ZendeskTicketViewerRestApplication_**
11. This would start up the back end server.
12. Open Terminal. Go to directory: zendesk_ticket_viewer_ui
13. Run command: npm install. This would install all required npm modules and create a package-lock.json file.
14. Run command: npm start
15. Open http://localhost:8080


#User Interface Screens
1. View All Ticket Information:
2. ![img.png](AllTickets.JPG)
3. Detailed Ticked View with limited words in description:
4. ![img.png](DetailedViewTickets.JPG)
5. Detailed Ticket View with full description:
6. ![img.png](DetailedViewFullDescription.JPG)
7. Paginate by click left and right arrows and change page size by selecting number of rows in the user interface
8. ![img.png](Paginated.JPG)
9. When there are no tickets to show
10. ![img.png](NoTickets.JPG)



Steps performed to understand & implement the requirements
1. Through Postman using Basic Authentication Setup => Executed API https://zcczendeskcodingchallenge3911.zendesk.com/api/v2/imports/tickets/create_many to create sample tickets
2. Verified through JOB Import API to verify status of the job.
3. Understood the response of the API : https://zcczendeskcodingchallenge3911.zendesk.com/api/v2/tickets.json?page[size]=8 Experimented with different page sizes.
4. 