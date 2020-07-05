# SKY-Labs

An experimental Book Management System where sky is, literally, the limit :D

The basic concept of this project is to create a book sharing environment,atleast among the people studying/working at a common workplace.
It's important because apart from the Institutes library, the students hold a huge amount of books as their personal possession. And if they are willing to share people must know about them...

An initiative by a small dead poet's society.

## How to run this application on your system?
1. Clone this repo and change your working directory by running the following commands:
```
git clone https://github.com/R-Yassh/SKY-Labs.git
cd SKY-Labs
```
2. Create a directory named _class-files_ in the SKY-Labs folder by running the command `mkdir class-files`
3. Download the MySQL JDBC connector from [here](https://dev.mysql.com/downloads/connector/j/) and save it into _class-files_ folder.
4. Create a MySQL database from your terminal named _skyDB_ and execute the queries from **skyDB.sql** to create tables and entries in database. (You can add your own entries too)
5. Change the username and password in _LoginAuthentication.java_ as per your system to access the database.
6. The `./script.sh` command will execute the bash script and should open the GUI of the application.

## Troubleshoot
- If there are any error messages between above steps, chances are that someone else has faced the same challenge and then some other person has solved it already. So do not hesitate to google them and you may fing a quick solution on Stack Overflow or something similar.
- For tutorial on how to connect Java code to MySQL using JDBC, click [here](https://youtu.be/45383b8dNCI)
- For a quick intro to Bash Scripts, click [here](https://ryanstutorials.net/bash-scripting-tutorial/bash-script.php)
---
<p align="center"> Made with ❤️ at <b>Sky Labs</b></p?
