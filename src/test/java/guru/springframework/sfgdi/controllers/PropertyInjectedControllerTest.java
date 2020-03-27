package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    private PropertyInjectedController controller;

    /**
     * Here we mimic what Spring would normally do. We preform
     * "manual" property-based injection by accessing the public
     * GreetingService property of the Controller, and instantiate
     * it with our GreetingServiceImpl implementation class.
     *
     * If the Controller and Service classes had been annotated as
     * Spring-managed component, they would have been loaded into
     * the Context at application start-up, and Spring would have
     * been able to handle this for us.
     */
    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    void getGreeting() {

        System.out.println(controller.getGreeting());
    }
}