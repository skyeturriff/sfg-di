package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * When the application starts up, Spring will scan for anything
 * annotated as a managed component. It will create instances of
 * these classes and put in into the ApplicationContext.
 *
 * Wherever needed, the code can then ask Spring for instances of
 * these classes and Spring will provide it from the Context.
 *
 * This is one of the FUNDAMENTAL TENANTS of dependency injection;
 * to have the framework doing all the management of it.
 *
 * In the main program we ask the Context for different types of
 * Controllers, which all depend on a GreetingService. Spring takes
 * over managing how and what GreetingService is injected into each
 * Controller. The different GreetingService implementations will
 * be injected by Spring according to the use of Primary and Qualifier
 * annotations in the Controller and GreetingService classes.
 *
 * This provides an example of how we can use Primary and Qualifier
 * together to control how classes get injected into Spring-managed
 * components.
 *
 * Profiles are very powerful and one of the most commonly used
 * features of dependency injection, as they allow us to control our
 * Spring application in different runtime environments. Profiles allow
 * us to have beans in our configuration that will take on different
 * characteristics, allowing the application to behave differently
 * at runtime. Using Profiles, we can get Spring to actually wire up
 * the application differently depending on which Profile is active
 * and which beans we assign to that profile.
 *
 * For example, we could have both an H2 and MySQL capabilities
 * configured, and control the H2- and MySQL-specific beans with
 * Profiles, so that the appropriate ones are loaded depending on
 * which profile is active. This can be useful if we want to use
 * different data layer technologies across different environments.
 *
 * There is a Default Profile available within the Spring framework.
 * This Profile is considered active if no other active profile has
 * been set (i.e., nothing configured in application.properties or
 * otherwise). We can add beans to the default profile, so that if
 * there is no active profile set, these default profile beans will
 * still be wired into the Context. This way, we don't have to always
 * set an active profile for our application.
 */
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        /*
         * This is how Inversion of Control works. The framework is managing
         * the construction of the Controller object. No where do we need
         * to explicitly use the "new" keyword - Spring manages the instantiation
         * of and the providing of the object when it is needed.
         */
            System.out.println("EXAMPLE Constructor-based injection using Primary component:");
        PrimaryGreetingController primaryGreetingController = (PrimaryGreetingController) ctx.getBean("primaryGreetingController");
        String greeting = primaryGreetingController.sayHello();
        System.out.println(greeting);

        /*
         * Application will error on start, unless the correct annotations
         * are present on the Constructor and Service classes, so that Spring
         * is aware it needs to manage the injection of the GreetingService
         * into each of these Controllers.
         *
         * Note we are not programmatically asking for any type of
         * GreetingService, we only need to ask the Context to provide
         * us with the Controllers.
         */
        System.out.println("EXAMPLE Property-based injection Controller:");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("EXAMPLE Setter-based injection Controller:");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("EXAMPLE Constructor-based injection Controller:");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        /*
         * Below, depending on the active profile set in the application.properties
         * file, Spring will load in and inject the correct GreetingService. We can
         * control which GreetingService is loaded into the Context and injected by
         * Spring by simply changing the active profile in the application.properties
         * file.
         */
        System.out.println("EXAMPLE Profile-based dependency injection:");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());
	}
}
