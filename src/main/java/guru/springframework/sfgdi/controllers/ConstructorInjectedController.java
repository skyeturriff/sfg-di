package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate how "manual" constructor-based
 * dependency injection would work. The GreetingService property is
 * private and final, and is instantiated through the Constructor.
 *
 * This is the preferred method of dependency injection.
 *
 * The annotations that would make the Controller and Service
 * classes Spring-managed components have been commented out
 * for this example.
 *
 * If the Controller and Service classes had their annotations,
 * they would have been loaded into the Context at application
 * start-up, and Spring would have handled the injection for us.
 *
 * See ConstructorInjectedControllerTest for the example.
 */
//@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    // The Autowired annotation is OPTIONAL when using constructor-based
    // dependency injection, if you have a SINGLE public Constructor.
    // Since the single Constructor is the only way to instantiate it, we
    // don't have to tell Spring explicitly to utilize it.
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
