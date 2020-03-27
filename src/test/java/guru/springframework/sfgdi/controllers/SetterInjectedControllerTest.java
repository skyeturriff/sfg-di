package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    /**
     * Here we mimic what Spring would normally do. We preform
     * "manual" setter-based injection by accessing the public
     * Setter method of the Controller, and injecting the
     * GreetingServiceImpl implementation class.
     *
     * If the Controller and Service classes had been annotated as
     * Spring-managed component, they would have been loaded into
     * the Context at application start-up, and Spring would have
     * been able to handle this for us.
     */
    @BeforeEach
    void setUp() {
        GreetingService greetingService = new GreetingServiceImpl();
        setterInjectedController = new SetterInjectedController();
        setterInjectedController.setGreetingService(greetingService);
    }

    @Test
    void getGreeting() {
        System.out.println(setterInjectedController.getGreeting());
    }
}