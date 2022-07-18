# Spring Boot Application

To get a list of dependencies, you can go to: https://mvnrepository.com/ 

### Build & Run Terminal Commands
- ``` mvn compile ```(Compile application)
- ``` mvn package ```(Package application incl. compile)
- ``` mvn spring-boot:run ``` (Run application)
- ``` java -jar day12-0.0.1-SNAPSHOT.jar ```(Run JAR file)
- ``` mvn clean ``` (Clean build artifacts)
- ``` mvn spring-boot:run -Dspring-boot.run.arguments="--port-8085" ```

### To change the PORT number 
1. Go to application.properties
2. Type in ``` server.port=8085 ```

### To change PORT number by terminal command

``` java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.Collections;

@SpringBootApplication
public class Day11lectureApplication {

	public static void main(String[] args) {
        
		SpringApplication app = new SpringApplication(Day11lectureApplication.class); //? Creates a new variable called app that starts the Springboot application

		String PORT = "8080"; //? Sets the default port
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		if (cliOpts.containsOption("port")) { //? If the terminal command contains port, get the value after the string "port" and change the default port to that value
			PORT = cliOpts.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", PORT));
		app.run(args);

	}

}

```

- In your terminal, type ``` mvn spring-boot:run -Dspring-boot.run.arguments="--port=8085" ```