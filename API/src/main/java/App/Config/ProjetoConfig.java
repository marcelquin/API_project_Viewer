package App.Config;

import App.RestApi.Infra.Gateway.ProjetoGateway;
import App.RestApi.Infra.UseCase.Projeto.UseCaseProjetoGet;
import App.RestApi.Infra.UseCase.Projeto.UseCaseProjetoPost;
import App.RestApi.Infra.UseCase.Projeto.UseCaseProjetoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjetoConfig {
    @Bean
    UseCaseProjetoGet useCaseProjetoGet(ProjetoGateway projetoGateway)
    { return new UseCaseProjetoGet(projetoGateway);}
    @Bean
    UseCaseProjetoPost useCaseProjetoPost(ProjetoGateway projetoGateway)
    { return new UseCaseProjetoPost(projetoGateway);}
    @Bean
    UseCaseProjetoPut useCaseProjetoPut(ProjetoGateway projetoGateway)
    { return new UseCaseProjetoPut(projetoGateway);}
}
