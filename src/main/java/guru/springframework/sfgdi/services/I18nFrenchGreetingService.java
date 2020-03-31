package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @see I18nEnglishGreetingService
 */
@Profile("FR")
@Service("i18nService")
public class I18nFrenchGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Bonjour! Du \"greeting service\" Francais!";
    }
}
