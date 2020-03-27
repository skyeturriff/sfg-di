package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

/**
 * This Controller is used to demonstrate how "manual" setter-based
 * dependency injection would work. The GreetingService property is
 * private, and is exposed through a public Setter method.
 *
 * If the Controller and Service classes had been annotated as
 * Spring-managed components, they would have been loaded into
 * the Context at application start-up, and Spring would have
 * been able to handle this for us.
 *
 * See SetterInjectControllerTest for the example.
 */
public class SetterInjectedController {

    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
