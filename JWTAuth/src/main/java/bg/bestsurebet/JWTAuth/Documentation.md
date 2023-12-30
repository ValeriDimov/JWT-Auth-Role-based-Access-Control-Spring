# Implement JWT authentication

The API must expose routes where some are accessible without authentication while others require one. The table below enumerates them:

API ROUTE	ACCESS STATUS	DESCRIPTION
[POST] /auth/signup	Unprotected	Register a new user
[POST] /auth/login	Unprotected	Authenticate a user
[GET] /users/me	Protected	Retrieve the current authenticated user
[GET] /users	Protected	Retrieve all the users

# Implement Role-based Access Control

Here are the following roles we have in our system:

User: can access his information
Administrator: can do everything the User role does and access the users' list.
Super Administrator: can do everything the Admin role does and create an admin user; shortly, he can do everything.
The table below lists the protected routes with the role required to access them.

API ROUTE	ROLE REQUIRED	DESCRIPTION
[GET] /users/me	User, Admin, Super Admin	Retrieve the authenticated user
[GET] /users	Admin, Super Admin	Retrieve the list of all users
[POST] /admins	Super Admin	Create an administrator