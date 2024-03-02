package App.RestApi.Infra.UseCase.MicroServico;

import App.RestApi.Domain.MicroService;
import App.RestApi.Infra.Gateway.MicroServicoGateway;
import App.RestApi.Infra.Persistence.Entity.MicroServicoEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseMicroServicoGet {

    private final MicroServicoGateway microServicoGateway;

    public UseCaseMicroServicoGet(MicroServicoGateway microServicoGateway) {
        this.microServicoGateway = microServicoGateway;
    }

    public ResponseEntity<List<MicroServicoEntity>> ListarMicroServicos()
    { return microServicoGateway.ListarMicroServicos();}
    public ResponseEntity<MicroService> BuscaMicroServicosPorId(@RequestParam Long id)
    { return microServicoGateway.BuscaMicroServicosPorId(id);}

    public ResponseEntity<Resource> DownloadDocumentoMicroServicosPorId(@RequestParam Long id)
    {return microServicoGateway.DownloadDocumentoMicroServicosPorId(id);}
}
