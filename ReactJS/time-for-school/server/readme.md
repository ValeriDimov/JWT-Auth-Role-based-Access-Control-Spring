# SoftUni Practice Server

## Usage

This is **REST service**, created for educational purposes. To execute it, open a command prompt and run `node server.js`.

```
> cd server
> node server.js
```

Note that changes to the data **will not be persisted**! All operations happen in memory and will be wiped when the service is restarted.

## Base URLs

The Base URLs for the APIs are: 
    - `http://localhost:3030/jsonstore`
    - `http://localhost:3030/data/`
    - `http://localhost:3030/users`

The documentation is the one of SoftUni Practice Server.

# Endpoints: Schools

- `/schools` - get all school list;
- `/schools/{schoolId}` - get school by provided id;


- `/comments` - get all comments list;
- `/comments/{commentId}` - delete comment by provided id;
- `/comments/?where=${searchQuery}&load=${relationQuery}` - get comments for specific query;
- `/offers` - get all offers list;
- `/offers/{offerId}` - get, update or delete offer by provided id;
- `/offers/?where=${searchQuery}&load=${relationQuery}` - get offers for specific query;

- `/users` - get user by provided id;