package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

/**
 * This Controller is used to demonstrate how "manual"
 * property-based injection would work. The access level
 * of the GreetingService property remains public to allow
 * for property-based injection.
 *
 * If the Controller and Service classes had been annotated as
 * Spring-managed components, they would have been loaded into
 * the Context at application start-up, and Spring would have
 * been able to handle this for us.
 *
 * See PropertyInjectedControllerTest for the example.
 */
public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
