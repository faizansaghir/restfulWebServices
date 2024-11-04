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