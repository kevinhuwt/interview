# Junit Test
We can use this endpoint to test in Postman, the result will be either true or false

For Example:
http://localhost:8080/test?str=abc
return true

http://localhost:8080/test?str=ab@
return false

In test folder, I used junit test. And we can also use Mockito if uncomment #31 in MainControllerTest.java.
