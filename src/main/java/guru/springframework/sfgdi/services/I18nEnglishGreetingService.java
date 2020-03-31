package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.controllers.I18nController;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * This internationalization service returns back a greeting in English.
 *
 * Each internationalization service is supplied with the same component
 * name "i18nService". Any dependant classes need only refer to this
 * component name, and we can rely on Spring to use Profiles to take
 * care of and inject the correct implementation.
 *
 * If we had multiple components with this same name without using
 * Profiles, Spring would throw a conflict error on start up as it
 * would not be able to distinguish between the different implementations.
 * There cannot be more than one component with the same name loaded
 * into the Context.
 *
 * Using Profiles resolves this. Only beans added to the current active
 * profile are available, so no conflict occurs in the Context. Spring
 * ignores any bean not included in the current active profile (i.e.,
 * des not load them into the Context).
 *
 * We tell Spring that this bean is part of the "EN" Profile, so that
 * when this profile is active, Spring will know to load this implementation
 * into the Context.
 *
 * However, a bean can be added to more than one profile. This bean
 * is also added to the default Spring profile, making it the default
 * "i18nService" bean. This makes it available when no active profile
 * is set, allowing our app to run without needing to set an active
 * profile.
 *
 * Note that only one bean of a type can be added to a profile (including
 * the default profile), or else the same conflict errors mentioned above
 * will occur within that profile.
 *
 * @see I18nEnglishGreetingService
 * @see I18nController
 */
@Profile({"EN", "default"})
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello! From the English greeting service!";
    }
}
