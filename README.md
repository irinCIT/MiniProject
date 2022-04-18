# MiniProject
Mini Project in java using Regular Expressions | Generic Collections | Lambdas and Streams

This project is a simple functioning kind of "management system", 7 classes project, where you can add/ delete or generate some statistics about the users.

User have a name, surname, position and a code.
The information is stored in text file called "storage.txt".
Before adding the program validates the inputs. Name, surname and position should contain only one capitalised word. Code should start with 000 and must have 4 more digits from 1-4. After passing tha validation, a new User objects creates, gets printed to the text file, and gets stored to the LinkedList of Users. 
In the statistics, you can convert a name into morse code, ascii encrypt it or encode it following the vigenere cipher. You can also print the words with the occurences or sort the users by name/surname/position or code.

Regular Expressions - ValidateUser.java
Generic Collections - AddUser.java/ Statistics.java
Lambdas and Streams - Statistics.java
