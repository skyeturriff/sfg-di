package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate constructor-based dependency
 * injection. The {@link GreetingService} property is private and final,
 * and is instantiated through the Constructor.
 *
 * This is the preferred method of dependency injection.
 *
 * See ConstructorInjectedControllerTest for an example of what this
 * would look like if we had to do it manually, i.e. programmatically
 * without using the Spring context.
 */
@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    /**
     * The Autowired annotation is OPTIONAL when using constructor-based
     * dependency injection, if you have a SINGLE public Constructor.
     * Since the single Constructor is the only way to instantiate it,
     * we don't have to tell Spring explicitly to utilize it.
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
    public ConstructorInjectedController(
            @Qualifier("constructorInjectedGreetingService") GreetingService greetingService) {

        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
