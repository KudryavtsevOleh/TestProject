This is the simple Todo-list which use Spring Security to authenticate user if the request has specialized headers
X-Login and X-Password. Also project include Spring Boot framework.
For authentication was created custom filter and authentication provider.
To run the project you need to go to ApplicationStart.java file and run it like most java programs. For Intellij Idea 
click right mouse button and choose 'Run' or 'Debug' option.

When project start you need open the browser and type in address bar URL 'localhost:8080'. 
After that you will see login page where you need to write your username and password.
If you write correct data program open next page where you can see area for adding new todo and area with 
todo's which you add ealier. Todo's marks with 3 colors depending on priority. Red - max priority, green - medium
priority, blue - low priority. You can choose priority when create new todo item. For markin todo as done you can
click on the todo which you done. After that todo will be removed.

Also you can logout from the program. Just click on the button 'Logout'.
