# Horoscope API App
## MVP
This RESTful application will allow end users to do the following:
    - register for an user account that must include their zodiac sign based on the birthdate
    - log in with existing user credentials of a username and password
    - show current user information
    - get today's horoscope for current user
        - Constraint: User must have Authentication-Cookie as part of HTTP request header
    - update current user information
    - delete user
        - Constraint: This feature should only be allowed for admin-authorization-level users (hint: you will first need to login to get your auth-cookie and then pass that cookie in the header of your HTTP request)
    
This application also has the following quality requirements:
1. Your application must show at least 70% test coverage overall. You may need to incorporate a Maven dependency like JaCoCo into your project to verify this requirement in a generated report.
2. Your application must have logging.
3. Your application must have a shareable Postman collection of your API endpoints available.

## Stretch Goals
    - get mood of current user based on birthdate
    - all passwords must be encrypted (hint: use BCrypt maven dependency)
    - be able to send an email notification to the user with today's horoscope attached in email body

## Techs
Java
Javalin
PostgreSQL
JDBC
Maven
JUnit
Mockito
Git

## Init Instructions
- Create a new private repository within this organization for your mini-class-project (naming convention: `horoscope_app_[your name]`; with `your_name` being replaced by your first name)
    - Make sure to add your trainer as contributor to the repo since this repo will be private