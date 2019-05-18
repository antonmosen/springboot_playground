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

## Jasypt

Jasypt is an encryption/decryption tool for java. This branch will show you an simple example on how to encrypt username and password for Couchbase database in application-dev.properties. Same methodology will work on all encryption/decryption throughout the project. Jasypt will automatically decrypt your encrypted values when your application is using them.

Encrypt
Cd to jasypt-192/bin folder
run either encrypt.bat or encrypt.sh
example: encrypt.bat input=<your_value_to_be encrypted> password=<your_key_for_the_password>

Jasypt will now generate an encrypted password for you.
To use it in propertiesfile, see application-dev.properties.
It´s important to enclose your encrypted password like ENC(<your_encrypted_password>) in propertiesfiles.
It´s also important to add jasypt.encryptor.password=<same_as_your_key> see application.properties.
Decrypt
Same as encrypt, just run decrypt.bat or decrypt.sh
Algorithms
Listed below are supported algorithms that works with jaspyt

PBEWITHMD5ANDDES -> Default PBEWITHSHA1ANDDESEDE PBEWITHSHA1ANDRC2_128 PBEWITHSHA1ANDRC2_40 PBEWITHSHA1ANDRC4_128 PBEWITHSHA1ANDRC4_40

Notes
The only property required is the encryption password, the rest could be left to use default values. While all this properties could be declared in a properties file, the encryptor password should not be stored in a property file, it should rather be passed as system property, command line argument, or environment variable and as far as its name is jasypt.encryptor.password it'll work. Github : https://github.com/ulisesbocchio/jasypt-spring-boot
