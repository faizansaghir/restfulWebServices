<h1>Overview</h1>

Repository to track development of RESTful web services

<h1>Notes</h1>

1. <strong>@SpringBootApplication</strong> <br>
    Annotation to tell Spring that a class is a SpringBootApplication. <br>
    It is a combination of <em>@SpringBootConfiguration, @EnableAutoConfiguration</em> and <em>@ComponentScan</em>. <br>
    <pre>Example:
        @SpringBootApplication
        public class RestfulWebServicesApplication {
            public static void main(String[] args) {
                SpringApplication.run(RestfulWebServicesApplication.class, args);
            }
        }</pre> <br>
2. <strong>@RestController</strong> <br>
    Annotation to tell Spring that a class is a Rest Controller. <br>
    It is a combination of <em>@Controller</em> and <em>@ResponseBody</em>. <br>
    It does not follow MVC(Model View Controller) flow, 
         rather returns the response directly in a certain format eg: JSON. <br>
   <pre>Example:
        @RestController
        public class HelloWorldController {
            ...
        }</pre> <br>
3. <strong>@RequestMapping</strong> <br>
    Annotation to tell Spring that a method is a request mapping and will be executed when certain path is visited. <br>
    <pre>Example:
        @RestController
        public class HelloWorldController {
            @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
            public String getHelloWorld(){
                return "Hello World";
            }
        }</pre> <br>
4. <strong>@GetMapping</strong> <br>
    Annotation to tell Spring that a method is a GET handler for a given path. <br>
    It is same as <em>@RequestMapping(method = {RequestMethod.GET})</em>
    <pre>Example:
        @RestController
        public class HelloWorldController {
            @GetMapping(path = "/hello-world")
            public String getHelloWorld(){
                return "Hello World";
            }
        }</pre> <br>
5. <strong>DispatcherServlet</strong> <br>
    &emsp;a. Whenever in Spring MVC a request is received, it first goes to DispatcherServlet which is mapped to '/' URL. <br>
    &emsp;b. This is called Front Controller Pattern. <br>
    &emsp;c. After looking at request URL, DispatcherServlet maps the request to the right controller method. <br>
    &emsp;d. Dispatcher Servlet is getting configured due to DispatcherServletAutoConfiguration. <br>
    &emsp;e. DispatcherServletAutoConfiguration is part of AutoConfiguration which is one of the features of SpringBoot. <br><br>
6.  <strong>Bean To JSON Conversion</strong> <br>
    &emsp;a. The <em>@RestController</em> has <em>@ResponseBody</em> which causes response of method to be returned as-is. <br>
    &emsp;b. When the message is returned, message conversion takes place based on configuration. <br>
    &emsp;c. The default message converter set in SpringBoot is JacksonHttpMessageConverters. <br>
    This is configured as  JacksonHttpMessageConvertersConfiguration which is part of SpringBoot AutoConfiguration. <br><br>
7. <strong>Error Page</strong> <br>
    The error page shown such as 404 error page is part of AutoConfiguration as ErrorMvcAutoConfiguration. <br><br>
8. <strong>Starter Projects</strong> <br>
    Spring Boot Starter Web provides dependencies such as: <br>
    a. spring-webmvc <br>
    b. spring-web <br>
    c. spring-boot-starter-tomcat (Tomcat)<br>
    d. spring-boot-starter-json (Jackson) <br><br>
    <em>Note: Enable <strong>debug</strong> level logs to see all beans such as DispatcherServletAutoConfiguration created. </em> <br><br>
9. <strong>Path Parameter and @PathVariable</strong> <br>
    &emsp;a. While requesting a resource in Rest API, clients sometimes need to pass an ID of the resource or some other value, 
    this value is passed in URL and can be read in the Controller mapped method in Spring. <br>
    &emsp;b. <em>@PathVariable</em> is the annotation to tell Spring that a parameter of handler method is a path parameter. <br>
    <pre>Example:
        @RestController
        public class HelloWorldController {
            @GetMapping("/hello-world/path-variable/{name}")
            public HelloWorldBean getHelloWorldPathVariable(@PathVariable String name){
                return new HelloWorldBean(STR."Hello \{name}");
            }
        }</pre> <br>
10. <strong>@PostMapping</strong> <br>
    Annotation to tell Spring that a method is a POST handler for a given path. <br>
    It is same as <em>@RequestMapping(method = {RequestMethod.POST})</em> <br><br>
11. <strong>@RequestBody</strong> <br>
    Annotation to tell Spring that request body is to be mapped to an instance of specified type. <br>
    <pre>Example:
        @RestController
        public class UserController {
            @PostMapping("/users")
            public void postUser(@RequestBody User user){
                service.save(user);
            }
        }</pre> <br>
12. <strong>ResponseEntity</strong> <br>
    Class meant to represent the entire HTTP response. <br>
    We can control anything that goes into it: status code, headers, and body. <br><br>
13. <strong>DevTools in Production</strong> <br>
    We see the StackTrace in our HTML response when exception is thrown along with WhiteLabel error page due to DevTools. <br>
    In production, this DevTools is automatically disabled even if it is part of the JAR file thus StackTrace is disabled. <br><br>
