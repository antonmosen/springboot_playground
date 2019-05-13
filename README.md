My personal Spring boot playground.

## Branches
* master

## Actuator
Helpful urls for actuator, will be updated in time.
* http://localhost:8080/actuator/health

## H2 database
To use H2 console in chrome, or other browsers, you must send a header with your request.
for Chrome, download ModHeader extension and add X-Trace and X-Value as header.
Use http://localhost:8080/h2-console to access console. 

## Postman
In order to send request, you must add X-Trace and X-Value as header.
The values are stored in application.properties.
Everytime a someone consumes the api, the ApiHeaderFilter kicks in and validates the header.
If no valid header, they get unauthorized as response.
