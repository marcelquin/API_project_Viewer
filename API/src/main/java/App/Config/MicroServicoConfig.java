package App.Config;

import App.RestApi.Infra.Gateway.MicroServicoGateway;
import App.RestApi.Infra.UseCase.MicroServico.UseCaseMicroServicoGet;
import App.RestApi.Infra.UseCase.MicroServico.UseCaseMicroServicoPost;
import App.RestApi.Infra.UseCase.MicroServico.UseCaseMicroServicoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicroServicoConfig {
    @Bean
    UseCaseMicroServicoGet useCaseMicroServicoGet(MicroServicoGateway microServicoGateway)
    { return new UseCaseMicroServicoGet(microServicoGateway);}
    @Bean
    UseCaseMicroServicoPost useCaseMicroServicoPost(MicroServicoGateway microServicoGateway)
    { return new UseCaseMicroServicoPost(microServicoGateway);}
    @Bean
    UseCaseMicroServicoPut useCaseMicroServicoPut(MicroServicoGateway microServicoGateway)
    { return new UseCaseMicroServicoPut(microServicoGateway);}
}
