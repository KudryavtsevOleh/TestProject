<h1>Todo-list</h1>

This is the program that implement simple Todo-list which use Spring Security to authenticate the user if the request
has specialized headers X-Login and X-Password. Also project include Spring Boot framework, ORM Hibernate, JQuery(AJAX) and Twitter Bootstrap.
Also project use MySQL database.
For authentication was created custom filter and authentication provider.

Before start you need to configure connection to db. Just open file application.properties and set username and password for MySQL.

To run the project you need to go to the ApplicationStart.java file and run it like most java programs. For Intellij Idea
click right mouse button and choose 'Run' or 'Debug' option.

When project start at a first time will be create default user with custom role.
When the project start you need to open the browser and type in address bar URL 'localhost:8080'.
After that you see login page where you need to write your username and password. You can find custom user credentials in file Bootstrap.java
If you write correct data program open next page where you can see area for adding new todo and area with
todo's which you added earlier. Todo's marks with 3 colors depending on priority. Red - max priority, green - medium
priority, blue - low priority. You can choose priority when create new todo item. For marking todo as done you can
click on the todo which you want to set done. After that todo will set to done and hide from the screen.

Also you can logout from the program. Just click 'Logout' button.