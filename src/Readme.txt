# A simple Restful API coded in Java with Spring Boot.

I. General useful definitions

- Restful API = (also known as REST API) is an API or web API that conforms to the constraints of REST architectural style and
                allows for interaction with RESTful web services.

- API (Application Programming Interface) = Is a set of definitions and protocols for building and integrating application software.
                                            It's sometimes referred to as a contract between an information provider and an information user
                                            establishing the content required from the consumer (the call) and the content required by the producer (the response).
                                            In other words, if you want to interact with a computer or system to retrieve information or perform a function, an API helps
                                            you communicate what you want to that system so it can understand and fulfill the request.
                                            You can think of an API as a mediator between the users or clients and the resources or web services they want to get.
                                            It's also a way for an organization to share resources and information while maintaining security, control, and authentification
                                            determining who gets access to what.

- REST (REpresentational State Transfer) = Is a set of architectural constraints, not a protocol or a standard. API developers can implement REST in a variety of ways.
                                           In order for an API to be considered RESTful, it has to conform to these criteria :
                                           - A client-server architecture made up of clients, servers, and resources, with requests managed through HTTP.
                                           - Stateless client-server communication, meaning no client information is stored between get requests and each request is separate and unconnected.
                                           - Cacheable date that streamlines client-server interactions.
                                           - A uniform interface between components so that information is transferred in a standard form. This requires that :
                                               - Resources requested are identifiable and separate from the representations sent to the client.
                                               - Resources can be manipulated by the client via the representation they receive because the representation contains enough information to do so.
                                               - Self-descriptive messages returned to the client have enough information to describe how the client should process it.
                                               - Hypertext/hypermedia is available, meaning that after accessing a resource the client should be able to use hyperlinks to find all other currently available actions they can take.
                                           - A layered system that organizes each type of server (those responsible for security, load-balancing, ...) involved the retrieval of requested information into hierarchies, invisible to the client.
                                           - Code-on-demand (optional) : The ability to send executable code from the server to the client when requested, extending client functionality.
                                           Though the REST API has these criteria to conform so, it is still considered easier to use than a prescribed protocol like SOAP (Simple Object Access Protocol), which has specific requirements like
                                           XML messaging, and built-in security and transaction compliance that make it slower and heavier.
                                           In contrast, REST is a set of guidelines that can be implemented as needed, making REST APIs faster and more lightweight, with increased scalability, perfect for IoT and mobile app development.

- Spring Boot = An open-source Java-based framework used to create micro services.
                It provides a good platform for Java developers to code a stand-alone and production-grade spring app that you can just run. You can get started with minimum configurations without having to configure an entire Spring setup.
                Advantages :
                    - Easy to understand and develop spring apps.
                    - Increases productivity.
                    - Reduces development time.
                Goals :
                    - To avoid complex XML configuration.
                    - To reduce development time and run the app independently.
                    - To offer an easier way of getting started with the app.
                How it works :
                    Spring Boot auto configures your app based on the dependencies you added to the project by using the @EnableAutoConfiguration annotation.
                    The entry point of the spring boot app is the class containing the @SpringBootApplication annotation and the main method.
                    Spring Boot auto scans all the components included in the project by using the @ComponentScan annotation.

- Micro service = Architecture that allows developers to code and deploy services independently. Each service running has its own process and this achieves the lightweight model to support business applications.
                  Their advantages :
                    - Easy deployment
                    - Simple scalability
                    - Compatible with containers
                    - Minimum configuration

II. Spring Boot annotations used

@Repository :          This annotation is used on Java classes which directly access the database.
                       It works as marker for any class that fulfills the role of repository or Data Access Object.

@Service :             This annotation is used on a class. It marks a Java class that performs some service, such as execute business
                       logic, perform calculations and call external APIs.
                       This annotation is a specialized form of the @Component annotation intended to be used in the service layer.

@Autowired :            Applied on fields, setter methods, and constructors. It injects object dependency implicitly.
                        Here, it is used on PersonController constructor and PersonService_Local constructor. Like that, constructor injection
                        happens at the time of object creation. It indicates the constructor to autowire when used as a bean.
                        NOTE : Since Spring 4.3, @Autowired has become optional on classes with a single constructor. In that case, it would still
                        inject an instance of the param in the constructor.

@SpringBootApplication : This annotation is used on the application class while setting up a Spring Boot project. The class annotated
                         with this annotation must be kept in the base package.
                         The one thing the @SpringBootApplication does is a component scan. But it will scan only its sub-packages.
                         The @SpringBootApplication is a convenient annotation that adds the following :
                         - @Configuration
                         - @EnableAutoConfiguration
                         - @ComponentScan

@RestController :       This annotation is used at the class level.
                        It marks the class as a controller where every method returns a domain object instead of a view.
                        By annotating a class with this annotation you no longer need to add @ResponseBody to all the RequestMapping method.
                        It means that you no longer use view-resolvers or send html in response. You just send the domain object
                        as HTTP response in the format that is understood by the consumers like JSON.

@Resource :            This annotation marks a resource that is needed by the application.
                       It has the following execution paths : (by order)
                       - Match by Name
                       - Match by Type
                       - Match by Qualifier
                       On the first match, the bean matching the configuration is injected.

@RequestBody :        This annotation is used to annotate request handler method arguments.
                      It indicates that a method parameter should be bound to the value of the HTTP request body.
                      The HttpMessageConverter is responsible for converting from the HTTP request message to object.

@RequestMapping :     This annotation is used both at class and method level.
                      It's used to map web requests onto specific handler classes and handler methods.
                      When used on class level, it creates a base URI for which the controller will be used.
                      Here, it's used on methods. When used on methods, it'll give you the URI on which the handler methods will be executed.

@PostMapping :        This annotation is used for mapping HTTP POST requests onto specific handler methods.
                      It's a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST)

@NonNull :            It's the most important annotation among all the annotations of the null-safety feature.

@GetMapping :        This annotation is used for mapping HTTP GET requests onto specific handler methods.
                     It's a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)

@PutMapping :        This annotation is used for mapping HTTP PUT requests onto specific handler methods.
                     It's a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT)

@DeleteMapping :     This annotation is used for mapping HTTP DELETE requests onto specific handler methods.
                     It's a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE)

III. Bibliography

- https://springframework.guru/spring-framework-annotations/
- https://www.redhat.com/en/topics/api/what-is-a-rest-api
- https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm