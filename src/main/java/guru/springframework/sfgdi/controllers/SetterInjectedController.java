package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate setter-based dependency
 * injection. The {@link GreetingService} property is private, and
 * is exposed through a public Setter method.
 *
 * See the SetterInjectedControllerTest for an example of what this
 * would look like if we had to do it manually, i.e. programmatically
 * without using the Spring context.
 */
@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    /**
     * We place the Autowired annotation on the exposed Setter method
     * to explicitly tell Spring that we want the Setter method to be
     * used to inject the {@link GreetingService} dependency.
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
    @Qualifier("setterInjectedGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
