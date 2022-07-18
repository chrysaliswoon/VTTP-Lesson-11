package sg.edu.nus.iss.day11lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collections;

@SpringBootApplication
public class Day11lectureApplication {

	public static void main(String[] args) {
		// SpringApplication.run(Day11lectureApplication.class, args); //? Starts the
		// application

		SpringApplication app = new SpringApplication(Day11lectureApplication.class); // ? Creates a new variable called
																						// app that starts the
																						// Springboot application

		String PORT = "8080"; // ? Sets the default port
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		if (cliOpts.containsOption("port")) { // ? If the terminal command contains port, get the value after the string
												// "port" and change the default port to that value
			PORT = cliOpts.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", PORT));
		System.out.printf("PORT started on " + PORT);
		app.run(args);

	}

	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}
}
