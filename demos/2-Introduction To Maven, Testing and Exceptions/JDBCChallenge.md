# JDBC Activity
Provide functionality for the following user stories:
1. Get all users ("/users") - returns a list of all users in system
2. Change password (/users/{id}/password) - updates the user's password
3. Get all users whose birthdate are in a given month (/users/bday)
    - Constraints: the birthdate must be passed as a query param

For each endpoint, you must also handle exceptions accordingly (i.e. set response with 404 and throw a NoUserBdayException).

Feel free to add unit testing for your dao and service classes as an extra challenge.