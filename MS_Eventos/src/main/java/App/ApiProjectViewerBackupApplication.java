package App;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "API Project Viewer backup",
		version = "1",
		description = "Serviço de controle de projetos e documentos complementares"))
public class ApiProjectViewerBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjectViewerBackupApplication.class, args);
	}

}
