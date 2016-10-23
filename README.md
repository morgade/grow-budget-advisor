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

The front end is a node/npm "webpackaged" ReactJS single page application coordinated by React-Redux as FLUX helper. It fetchs data from REST enpoits provided by the Java back end. It features a dashboard presenting user charts and directioned budget tips. Also features budget item and goals creation forms.

The Java back end is based on Spring Boot and even though it performs no persistence holding all the data in memory, it's fully prepared and designed to persist the data. We simulated a event sourcing comunication between a mocked external service for accounting data and the budget service. The back-end is exposed to the front-end through a REST API.

### Instructions

The frontend solution is a NPM NodeJS structure. To run the application just run:
npm install
npm build
The backend solution was developed as a self contained application that can be deployed to a container or executed locally.
The Maven build will create a Jar file. To run the application just use java -jar command on XXX-0.0.1-SNAPSHOT.jar. With current configurations, the embedded server will start serving on port 8080.


Sign-ing with the user: 'dennis' and password: 'grow' to load some pre-defined data and start having some financial fun.

### Final Considerations


Choosing this challenge caused in everyone of us the strange feeling of being super excited but terrified at the same time. We were constantly pulling lots of interesting ideas for a savings advisor all fitting in a big scale project, but constrained by the 48 hours time box of a hackathon! Yet we decide to face the challenge to create maximum amount of code and UI that could express a glimpse of our vision to Grow. In the end, our budget advisor is the offspring of hard work as we pushed ourselves to the limit trying to cover as much ground as we could.

### Mind The Hippo Team

We've been working together for almost ten years in several projects and endeavors, always delivering state of the art simplicity.

-- André Luiz Teixeira Novaes - Full-stack engineer | @altn80 | andre.novaes@gmail.com

-- Lucas da Silva Lopes Furtado - Back-end engineer | @lucasslf | lucasslf@gmail.com

-- Marcelo Burgos Morgade Cortizo - Full-stack engineer | @morgade | morgade@gmail.com

http://mindthehippo.com/
