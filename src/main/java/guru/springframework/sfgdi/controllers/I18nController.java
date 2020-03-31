package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.I18nFrenchGreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate how Spring profiles
 * can be used for dependency injection.
 *
 * @see I18nEnglishGreetingService
 * @see I18nFrenchGreetingService
 */
@Controller
public class I18nController {

    private final GreetingService greetingService;

    /**
     * We ask for a component with the name {@code i18nService}. There
     * are two implementations of {@link GreetingService} with this
     * component name, each associated to a specific Profile. We rely on
     * Spring to inject the correct implementation, depending on which
     * profile is  declared active in {@code application.properties} file.
     */
    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
