package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    /**
     * This is used to demonstrate how "manual" constructor-based
     * dependency injection would work. The GreetingService property is
     * private and final, and is instantiated through the Constructor.
     *
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
        GreetingService greetingService = new ConstructorInjectedGreetingService();
        controller = new ConstructorInjectedController(greetingService);
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}