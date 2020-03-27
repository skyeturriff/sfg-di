package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

/**
 * This Controller is used to demonstrate how "manual" constructor-based
 * dependency injection would work. The GreetingService property is
 * private and final, and is instantiated through the Constructor.
 *
 * This is the preferred method of dependency injection.
 *
 * If the Controller and Service classes had been annotated as
 * Spring-managed components, they would have been loaded into
 * the Context at application start-up, and Spring would have
 * been able to handle this for us.
 */
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
