VanHackathon
=======
Grow - Budget Advisor
-----------

Budgeting Tool

### Introduction

In this challenge we were asked to develop a budgeting tool which would help someone to define goals and save money in order
to achieve those goals, considering the context of a online banking account.

We, as a team, believe that this challenge fits the best with our technical skills. Almost too perfectly, as we are Java guys. You know,  those type of Java guys that still loves Java.

### The Tool

The solution is a budget advisor tool intended to be bound to a bigger banking environment, receiving accounting data such 
as credit and debit transactions from external sources.

As the user informs goals and budgeting itens, the application shows valuable information and tips.

In order to keep our schedule safe we decide to mock most of the data and simplify the architecture, making it monolithical but with a hint of a microservices architecture.

The project focused on defining the concept and a architecture for a financial advisor that uses bank transactions information to posts charts and tips in a dashboard to support the user in the pursuit of her goals.

### Technical Overview

The Mind The Hippo Budgeting Advisor is a proof of concept web application developed with React Js front-end and Java back-end.

Front end ipsum

The Java back end is based on Spring Boot and even though it performs no persistence holding all the data in memory, it's fully prepared and designed to persist the data. We simulated a event sourcing comunication between a mocked external service for accounting data and the budget service. The back-end is exposed to the front-end through a REST API.

### Instructions

The solution was developed as a self contained application that can be deployed to a container or executed locally.
The Maven build will create a Jar file. To run the application just use java -jar command on XXX-0.0.1-SNAPSHOT.jar.

Sign-ing with the user: 'dennis' and password: 'grow' to load some pre-defined data and start having some financial fun.

### Final Considerations

This challenge.... ipsum loren

### Mind The Hippo Team

We've been working together for almost ten years in several projects and endeavors, always delivering state of the art simplicity.

-- André Luiz Teixeira Novaes | @altn80 | andre.novaes@gmail.com

-- Lucas da Silva Lopes Furtado | @lucasslf | lucasslf@gmail.com

-- Marcelo Burgos Morgade Cortizo | @morgade | morgade@gmail.com

http://mindthehippo.com/
