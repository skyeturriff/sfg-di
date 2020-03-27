package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate how "manual" setter-based
 * dependency injection would work. The GreetingService property is
 * private, and is exposed through a public Setter method.
 *
 * The annotations that would make the Controller and Service
 * classes Spring-managed components have been commented out
 * for this example.
 *
 * If the Controller and Service classes had their annotations,
 * they would have been loaded into the Context at application
 * start-up, and Spring would have handled the injection for us.
 *
 * See SetterInjectControllerTest for the example.
 */
//@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    // We place the Autowired annotation on the exposed Setter
    // method to explicitly tell Spring that we want the Setter
    // method to be used to inject the GreetingService dependency.
    // @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
