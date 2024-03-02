package App;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Micro Serviço FileServer", version = "1", description = "Micro serviço responsavel pelo envio e manutenção de arquivos"))
public class JavaAnotacoesFileServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaAnotacoesFileServerApplication.class, args);
	}

}
