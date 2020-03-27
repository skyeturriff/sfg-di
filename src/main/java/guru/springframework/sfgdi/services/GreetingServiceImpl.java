package guru.springframework.sfgdi.services;

/**
 * This Service will be injected into the various Controller classes
 * using different forms of "manual" dependency injection to show what
 * it looks like without Spring doing it for us.
 *
 * See PropertyInjectedController, SetterInjectedController, etc.
 */
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {

        return "Hello World in English!";
    }

}
