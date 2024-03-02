package App.Config;

import App.ApiRest.Infra.Gateway.FileServerGateway;
import App.ApiRest.Infra.UseCase.UseCaseFileServerGet;
import App.ApiRest.Infra.UseCase.UseCaseFileServerPost;
import App.ApiRest.Infra.UseCase.UseCaseFileServerPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileServerConfig {

    @Bean
    UseCaseFileServerGet useCaseFileServerGet(FileServerGateway fileServerGateway)
    { return new UseCaseFileServerGet(fileServerGateway);}
    @Bean
    UseCaseFileServerPost useCaseFileServerPost(FileServerGateway fileServerGateway)
    { return new UseCaseFileServerPost(fileServerGateway);}
    @Bean
    UseCaseFileServerPut useCaseFileServerPut(FileServerGateway fileServerGateway)
    { return new UseCaseFileServerPut(fileServerGateway);}
}
