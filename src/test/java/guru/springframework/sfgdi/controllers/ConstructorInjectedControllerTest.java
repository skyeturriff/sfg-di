package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    /**
     * Here we mimic what Spring would normally do. We preform
     * "manual" constructor-based injection by injecting the
     * GreetingServiceImpl implementation class into the
     * Controller's constructor method.
     *
     * If the Controller and Service classes had been annotated as
     * Spring-managed components, they would have been loaded into
     * the Context at application start-up, and Spring would have
     * been able to handle this for us.
     */
    @BeforeEach
    void setUp() {
        GreetingService greetingService = new GreetingServiceImpl();
        controller = new ConstructorInjectedController(greetingService);
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}