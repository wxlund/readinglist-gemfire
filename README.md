This is a combination of two efforts:

Started with Spring Starter Project. 

This project works but not without some tweaking.  The application does not bring in the correct version of spring-data-gemfire after the additional dependencies are added in. (I didn't track down the root cause, only took the time to get it working. 

    compile('org.springframework.boot:spring-boot-starter-thymeleaf')
    compile('org.springframework.boot:spring-boot-starter-web')
    
The key changes were that I had to modify the build.gradle with the following:

* Upgraded to 1.3.0.RC1
* Added explicit support for gemfire-8.1.0 (e.g.
	compile('com.gemstone.gemfire:gemfire:8.1.0')

The final working example has only a few more lines of configuration to support a local Gemfire cache but is now working.  See Craig Walls book, "Spring Boot in Action" for an explanation of the code, which was originally written for JPA. 



