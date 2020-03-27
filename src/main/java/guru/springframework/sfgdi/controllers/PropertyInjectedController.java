package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate how "manual"
 * property-based injection would work. The access level
 * of the GreetingService property remains public to allow
 * for property-based injection.
 *
 * The annotations that would make the Controller and Service
 * classes Spring-managed components have been commented out
 * for this example.
 *
 * If the Controller and Service classes had their annotations,
 * they would have been loaded into the Context at application
 * start-up, and Spring would have handled the injection for us.
 *
 * See PropertyInjectedControllerTest for the example.
 */
//@Controller
public class PropertyInjectedController {

    // We place the Autowired annotation on the public GreetingService
    // property to let Spring know we want a GreetingService injected
    // into this class. Note that Spring can also Autowire private fields,
    // but this is recommended even less than property-based injection
    // on public members, as Spring performs reflection to inject the
    // dependency into the private field - makes tests messy.
    // @Autowired
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
