This is the program that implement simple Todo-list which use Spring Security to authenticate the user if the request
has specialized headers X-Login and X-Password. Also project include Spring Boot framework, ORM Hibernate, JQuery(AJAX), and Twitter Bootstrap.
For authentication was created custom filter and authentication provider.
To run the project you need to go to the ApplicationStart.java file and run it like most java programs. For Intellij Idea
click right mouse button and choose 'Run' or 'Debug' option.

When project start at a first time will be created default user with custom role.
Then you need to open the browser and type in address bar URL 'localhost:8080'.
After that you see login page where you need to write your username and password. You can find user credentials in file Bootstrap.java
If you write correct data program open next page where you can see area for adding new todo and area with 
todo's which you added earlier. Todo's marks with 3 colors depending on priority. Red - max priority, green - medium
priority, blue - low priority. You can choose priority when create new todo item. For marking todo as done you can
click on the todo which you done. After that todo will remove from db.

Also you can logout from the program. Just click 'Logout' button.