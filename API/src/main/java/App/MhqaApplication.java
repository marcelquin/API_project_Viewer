package App;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "API Project Viewer",
		version = "1",
		description = "Serviço de controle de projetos e documentos complementares"))
public class MhqaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhqaApplication.class, args);
	}

}
