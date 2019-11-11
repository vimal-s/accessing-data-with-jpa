This application uses Spring Data JPA to store and retrieve data in a relational database.

== What It Does

The application stores `Customer` POJOs in a memory-based database.

Spring Data JPA focuses on using JPA to store data in a relational database. Its most
compelling feature is the ability to create repository implementations automatically, at
runtime, from a repository interface.

== Running the Application

When you run your application, you should see output similar to the following:

====
----
== Customers found with findAll():
Customer[id=1, firstName='']
Customer[id=2, firstName='']
Customer[id=3, firstName='']
Customer[id=4, firstName='']

== Customer found with findByFirstName(''):
Customer[id=1, firstName='']

== Customer found with findById(4):
Customer[id=1, firstName='']
----
====
