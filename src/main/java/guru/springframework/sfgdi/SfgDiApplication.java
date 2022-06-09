package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SFGConfiguration;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHelloWorld();
		System.out.println(greeting);


		System.out.println("=-------- Property");
		System.out.println("Property Injected Controller");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());


		System.out.println("=-------- Property");
		System.out.println("Setter Injected Controller");
		SetterInjectionController setterInjectedController = (SetterInjectionController) ctx.getBean("setterInjectionController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("=-------- Property");
		System.out.println("Constructor Injected Controller");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUserName());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("SFGConfiguration Property ");
		SFGConfiguration sfgConfiguration = ctx
				.getBean(SFGConfiguration.class);
		System.out.println(sfgConfiguration.getUserName());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcurl());

	}


}
