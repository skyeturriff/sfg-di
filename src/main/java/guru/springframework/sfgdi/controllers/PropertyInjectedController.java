package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate property-based dependency
 * injection. The access level of the {@link GreetingService} property
 * remains public to allow for property-based injection.
 *
 * Note that Spring can also Autowire private fields, but this is
 * recommended even less than property-based injection on public members,
 * as Spring performs reflection to inject the dependency into the private
 * field - makes tests messy.
 *
 * See PropertyInjectedControllerTest for an example of what this
 * would look like if we had to do it manually, i.e. programmatically
 * without using the Spring context.
 */
@Controller
public class PropertyInjectedController {

    /**
     * We place the Autowired annotation on the exposed property to
     * let Spring know we want a {@link GreetingService} injected
     * into this class.
     *
     * Spring does require that we use the Qualifier annotation, as the
     * Context is aware of more than one type of {@link GreetingService}
     * since we have created three different implementations and marked
     * then all as Spring-managed components. Each Spring component
     * qualifies for this dependency, since they are all of the required
     * type. So Spring needs us to tell it which one to use.
     *
     * Here, we tell Spring explicitly which implementation we want
     * injected by providing the class name.
     */
    @Autowired
    @Qualifier("propertyInjectedGreetingService")
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
