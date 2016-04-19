# Java BootCamp base folders layout

Please, use this repository as a base for you training phase. The idea is to
fork this project so everyone use the same folder structure for the
exercises.

It's extremelly important to keep the key points easy to be verified by
the reviewers, so **don't mix the key points with the rest of the
exercises**


# Material

#JAVA Boot Camp

###Are you ready for it?
  
####Index

1. [Objective](#objective)

2. [Who Should Attend](#who-should-attend)

3. [Duration](#duration)

4. [Technical Assistance](#technical-assistance)

5. [Performance Measurement](#performance-measurement)

6. [Handling advanced Developers](#handling-advanced-developers)

7. [Materials](#materials)

8. [General Guidelines](#general-guidelines)

9. [Learning Days](#learning-days)

    * [Topic 0: Introduction to Object Oriented Programming Concepts (OOP)](#topic-0-introduction-to-object-oriented-programming-concepts-2-days)

    * [Topic 1: Maven](#topic-1-maven-1-day)

    * [Topic 2: Test Driven Development](#topic-2-test-driven-development-3-days)

    * [Topic 3: Services](#topic-3-services-2-days)

    * [Topic 4: SQL - MySql](#topic-4-sql---mysql-2-days)

    * [Topic 5: NoSQL - MongoDB](#topic-5-nosql---mongodb-2-days)
    
    * [Topic 6: Spring Core & REST](#topic-5-spring-core--rest-3-days)

10. [Your First Project Starts Now!](#your-first-project-starts-now)

###Objective

This course teaches the basics of Java development applications.

→ [index](#index)

###Who Should Attend

The training will start at a low level and does not require in depth knowledge of the platform in question. Desirable participant profile: trainees and outside Globant candidates. A basic knowledge on OOP is desired, though.

→ [index](#index)

###Duration

Four weeks total.

Three weeks for guided learning and one week for app development. 

→ [index](#index)

###Technical Assistance

You can contact other bootcamp participants or any available tutor if you need technical assistance. We will create one chat for boot camp members only, and another one for boot camp members and tutors when boot camp starts.

###Performance Measurement

1. Code review after each practice.

2. Checkpoint completion after Learning stage with your assigned tutor

→ [index](#index)


###Handling Advanced Developers

Developers that move faster than average can go ahead and complete as much exercises as wanted. 

→ [index](#index)

###Materials

1. Install [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

2. The IDE to use is [Eclipse for Java Developers](http://www.eclipse.org/downloads/). [JEE version Recommended](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1).

3. Skype Account + headset (audio calls)

4. Create your own [GitHub](https://github.com/) account. Follow this [guideline](https://help.github.com/articles/set-up-git) to setup your account. Also you can read further about Git in [Try Git](https://try.github.io/levels/1/challenges/1) or [Learn Git Branching](http://pcottle.github.io/learnGitBranching/)

5. Fork this repo https://github.com/juanpablopizarro/java-bootcamp-2016 to use as a base to host the project code. Read [this](https://help.github.com/articles/fork-a-repo/) for instructions.

→ [index](#index)

 

###General Guidelines

The boot camp is organized in the following way:

1. The first three weeks will be used for intensive self learning. Each topic will have reading and practices parts. Tutors will be available to answer technical questions on a given chat room. 

2. The next week will be used to develop an application following a life process.

3. One boot camp chat will be created for feedback and technical assistance:

    Bootcamp JAVA 2016 - ALL
Every person participating in the bootcamp is present here (students and tutors). Here is the place to ask for technical assistance!

4. [Team play](http://www.dummies.com/how-to/content/ten-qualities-of-an-effective-team-player.html) is encouraged but the work will be evaluated per person.

5. The instructions will be vague as they generally are in real life projects. You must look for support and guidance from your tutor and teammates.

6. All code and documentation must be in English.

7. Code must adhere to this [eclipse code formatter](https://github.com/juanpablopizarro/java-bootcamp-2016/blob/master/formatter.xml). See importing instructions in this [link](http://www.avajava.com/tutorials/lessons/how-do-i-share-my-code-formatting-settings-with-another-user.html?page=2).

→ [index](#index)

###Proposed Test Applications

The test application will consist in a REST API for a functional shopping cart. The minimum features to be completed are:

  - User registration and login.
  - List products.
  - Find products by category and name.
  - Save cart before buy.
  - Buy products.


###Learning Days###

Each day you will grab the fundamentals of the key building blocks for usual Java applications.

On each learning day you will have to:

1. ####Read:####
We will provide you with documentation related with current sprint content so you can have a background reference, guide and examples to complete the following practice.

2. ####Practice:####
You will implement the previously gathered knowledge in simple coding activities.
Most important task numbers are listed in the "*Key Points*" section for each day and they should get most of your attention; if you feel you don’t have enough time to complete all tasks, start with these ones when possible.

3. ####Commit:####
You will commit all your code on a daily basis, when you finish your practice.

### Introduction

  - [JVM](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html#t1s1). See: "Java Technology and the JVM" and "Describing Garbage Collection"

####Topic 0: Introduction to Object Oriented Programming Concepts (2 days)####

#####Reading:#####

1. Beginners: Java Concepts [basic tutorial](http://docs.oracle.com/javase/tutorial/java/concepts/) (in case you need it!)

2. Beginners: Have fun with [Introduction to Java Programming](http://www.ibm.com/developerworks/java/tutorials/j-introtojava1/). Do as much you can.

3. Explore [Design Patterns](http://www.avajava.com/tutorials/categories/design-patterns). Minimum scope: singleton, factory, abstract factory, strategy, template method, proxy, decorator and builder.

#####Extra documentation:#####

* [Design Patterns Card](http://www.mcdonaldland.info/files/designpatterns/designpatternscard.pdf)


#####Practice:#####

1. Create a singleton example for a database connection.
2. Create a abstract factory example for diferent type of SQL connections. See [this](http://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm) example 
3. Create a proxy example for database accesor clases.
4. Create a builder example for database connection.

#####Key Points:#####

3

#####Commit:#####

Commit your practice code.

→ [index](#index)

####Topic 1: Maven (1 day)####

#####Reading:#####
1. [What is Maven?](http://maven.apache.org/what-is-maven.html)

2. Have fun with [Maven in 5 minutes](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html). 

3. Maven: [best practices](http://books.sonatype.com/mvnref-book/reference/pom-relationships-sect-pom-best-practice.html)

#####Practice:#####

(It is assumed that Maven is already installed and working).

1. Create and build a simple Maven project:
2. Customize the Maven project by adding new dependencies: log4j, junit.
3. Create a simple unit test under src/test/java and run it. Then skip the unit test by property or by adding the skipping test configuration to your pom.xml file.
4. Create a Simple Web Application

#####Key Points:#####

1,2,4

#####Commit:#####

Commit your practice code.

→ [index](#index)


####Topic 2: Test Driven Development (2 days)####

#####Reading:#####
1. [Test Driven Development](http://technologyconversations.com/2013/12/24/test-driven-development-tdd-best-practices-using-java-examples-2/)

#####Practice:#####

1. Use TDD to create the 'Recent file list' behaviour. Some examples of this behaviour is:
  * When the program is run for the first time, the list is empty.
  * When a file is opened, it is added to the recent file list.
  * If an opened file already exists in the recent file list, it is bumped to the top, not duplicated in the list.
  * If the recent file list gets full (typical number of items is 15), the oldest item is removed when a new item is added.
2. Using TDD techniques such as mocking, faking and stubs, try to develop your own blog software featuring:
  * Post new entry
  * Delete existing entry
  * Show 10 most recent entries
 
#####Key Points:#####

2

#####Commit:#####

Commit your practice code.

→ [index](#index)


####Topic 3: Services (2 days)####

#####Reading:#####
1. [How to create services in Java](http://www.makinggoodsoftware.com/2009/11/17/how-to-create-services-in-java/)

2. [How to design a good API and why it matters](https://www.youtube.com/watch?v=aAb7hSCtvGw)

#####Practice:#####

1. Create a shopping cart API spec
2. Implement the previous shopping cart using TDD.
3. Document services.
4. Design a UserService for CRUD operations.
5. Implement and document previous UserService.

Note: Do not implement JPA or ORM. Services should return in memory data only.

#####Key Points:#####

1,2,4

#####Commit:#####

Commit your practice code.

→ [index](#index)


####Topic 4: SQL - MySql (2 days)####

#####Reading:#####
1. [MySql basis](http://www.vogella.com/tutorials/MySQL/article.html)

2. [Jdbc basis](http://www.vogella.com/tutorials/MySQLJava/article.html#jdbc)

#####Extra documentation:#####

1. [Optimizaciones en MySql](http://www.arsys.info/programacion/bases-de-datos/como-optimizar-bases-de-datos-mysql/)


#####Practice:#####
Do not solve the practice using JDBC, please just send us the sql scripts.

1. Create a database named 'high-school' and modelate:
 
   - Student: first name, last name, registration number, date of birth)
   - Teacher: first name, last name, date of birth)
   - Course: name, assigned teacher, hours by week, schedule time (they can be dictated several times during the week)

   Notes:
   - An student can assist several courses during the same year.
   - A teacher can be assigned to several courses.
   - For each course, each student has 3 partial notes and a final note.
   - Create all relationship that you think they are required.

2. Insert information for 3 teachers, 3 courses and 10 students per course.
3. List students and teachers for a given course. The output format should be:

        Course: <course-name>
        Teacher: <last-name>, <first-name>
        Students:
          <last-name>, <first-name> (ordered by alphabetically by last name)

4. Percentage of students that passed/failed a given course.
5. For a given teacher, list the timeline for each course that he is assigned to (ordered by date), and the course name. The format should be:

        Teacher: <last-name>, <first-name>
        Schedule:
          Monday 09:00 - 11:00: <course-name>
          Monday 15:00 - 17:30: <course-name>
          Friday 08:45 - 10:40: <course-name>

6. Identify and Optimize all queries.
7. Connect to MySQL using Java JDBC and perform the query you have developed in excercise 5.

#####Key Points:#####

1,2,3,5,7

#####Commit:#####

Commit your practice code.

→ [index](#index)

####Topic 5: NoSQL - MongoDB (2 days)####

#####Reading:#####
1. [SQL vs. NoSQL DB](http://www.thegeekstuff.com/2014/01/sql-vs-nosql-db/)

2. [Installing MongoDB](http://docs.mongodb.org/manual/installation)

3. [SQL to MongoDB Mapping Chart](http://docs.mongodb.org/manual/reference/sql-comparison)

4. [Morphia to Map Java objects in MongoDB](https://dzone.com/articles/using-morphia-map-java-objects)


#####Practice:#####

1. Using the same SQL-MySql data model, map it to the corresponding database, collections and documents.
2. Fetch all students whose notes in a specific course were greater than 4.
3. Fetch all courses ordered by name for a given teacher.
4. Create a new project using Maven and Morphia to map the objects created in 1. Create the necessary DAOs to get same result than 2.

#####Key Points:#####

1,2,4

#####Commit:#####

Commit your practice code.

→ [index](#index)

####Topic 6: Spring Core & REST (3 days)####

#####Reading:#####
1. [Introduction to REST](https://www.youtube.com/watch?v=YCcAE2SCQ6k)

2. [Quick development guide](https://spring.io/guides/gs/rest-service/)

3. [Spring boot - rest services guide](http://spring.io/guides/tutorials/bookmarks/)

4. [REST API documentation](http://swagger.io/getting-started/)
  
#####Practice:#####

1. Expose the shopping cart created in the topic 3.
2. Write the swagger file for point 1.
3. Create and document with swagger a REST API to register users. The API must provide: add, delete, update and find by name and find by nickname operations. Note that the username must be unique.

#####Key Points:#####

3

#####Commit:#####

Commit your practice code.

→ [index](#index)

###Your First Project Starts Now!

####Final Project (3 days)
Create a functional shopping cart (just REST api). The minimum features to be completed are:

  - User registration and login.
  - Find products by category and name.
  - Save Cart.
  - Buy products.

The solution must use MongoDB or MySql as repository as well as Spring Boot and swagger for REST documentation.

Thanks for reading!
