package App.RestApi.Infra.UseCase.Projeto;

import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Gateway.ProjetoGateway;
import App.RestApi.Infra.Persistence.Entity.ProjetoEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseProjetoGet {

    private final ProjetoGateway projetoGateway;

    public UseCaseProjetoGet(ProjetoGateway projetoGateway) {
        this.projetoGateway = projetoGateway;
    }

    public ResponseEntity<List<ProjetoEntity>> ListarProjetos()
    { return projetoGateway.ListarProjetos();}

    public ResponseEntity<Projeto> BuscaProjetoPorId(@RequestParam Long id)
    { return projetoGateway.BuscaProjetoPorId(id);}
    public ResponseEntity<Resource> DownloadDocumentoProjetoPorId(@RequestParam Long id)
    { return projetoGateway.DownloadDocumentoProjetoPorId(id);}
}
