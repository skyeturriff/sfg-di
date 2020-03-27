package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * When the application starts up, Spring will scan for anything
 * annotated as a managed component. It will create instances of these
 * classes and put in into the Spring Context (ApplicationContext).
 * Wherever needed, the code can then ask Spring for instances of
 * these classes and Spring will provide it from the Context.
 *
 * This is one of the fundamental tenants of dependency injection;
 * to have the framework doing all the management of it.
 */
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        // This is how Inversion of Control works. The framework is managing
        // the construction of the MyController object. No where do we need
        // to explicitly use the "new" keyword - Spring manages the instantiation
        // of and the providing of the object when it is needed
        MyController myController = (MyController) ctx.getBean("myController");

        String greeting = myController.sayHello();
        System.out.println(greeting);
	}

}
