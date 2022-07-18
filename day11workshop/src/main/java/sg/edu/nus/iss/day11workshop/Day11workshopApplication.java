package sg.edu.nus.iss.day11workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.Collections;


@SpringBootApplication
public class Day11workshopApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day11workshopApplication.class);
		String PORT = "3000";
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		if (cliOpts.containsOption("port")) {
			PORT = cliOpts.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", PORT));
		app.run(args);

	}

}
