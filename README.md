# REST API to truncate a string into a given size

## Usage:
Request:
`HTTP GET localhost:8080/subscribe?order=12345678901234567890123456&size=23`

Response:
`1 ... (truncated) ... 6`

Parameters passed are,
`order` - any string to be truncated,
`size` - size of the truncated string

## Development Details

REST API is exposed using Spring Boot
A utility classm(SimpleTruncateUtil) encapsulates the truncate logic. 
REST controller calls TruncateUtil interface to truncate the string so that implementaion of truncate logic can evolve without affecting the controller.
SimpleTruncateUtilTest contains unit tests for truncate method. JUnit is used as the unit testing framework.
Maven is used to build/run the project.
