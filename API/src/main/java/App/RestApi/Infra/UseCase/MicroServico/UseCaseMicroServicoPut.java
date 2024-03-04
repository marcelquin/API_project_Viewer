package App.RestApi.Infra.UseCase.MicroServico;

import App.RestApi.Domain.MicroService;
import App.RestApi.Infra.Gateway.MicroServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class UseCaseMicroServicoPut {

    private final MicroServicoGateway microServicoGateway;

    public UseCaseMicroServicoPut(MicroServicoGateway microServicoGateway) {
        this.microServicoGateway = microServicoGateway;
    }

    public ResponseEntity<MicroService> EditarInformacoesMicroServicos(@RequestParam Long id, @RequestParam String nome,
                                                                       @RequestParam String descrisao)
    { return microServicoGateway.EditarInformacoesMicroServicos(id, nome, descrisao);}
    public ResponseEntity<MicroService> AlterarResumoFuncionamentoMicroServicos(@RequestParam Long id, @RequestParam String resumoFuncionamento)
    { return microServicoGateway.AlterarResumoFuncionamentoMicroServicos(id, resumoFuncionamento);}

    public ResponseEntity<MicroService> AdicionarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return microServicoGateway.AdicionarArquivosMicroServicos(id, files);}
    public ResponseEntity<MicroService> AlterarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return microServicoGateway.AlterarArquivosMicroServicos(id, files);}

    public ResponseEntity<MicroService> AlterarLinkGitMicroServicos(@RequestParam Long id,@RequestParam String link)
    { return microServicoGateway.AlterarLinkGitMicroServicos(id, link);}
    public ResponseEntity<MicroService> IniciarDesenvolvimentoMicroServicos(@RequestParam Long id,@RequestParam Boolean Iniciar)
    { return microServicoGateway.IniciarDesenvolvimentoMicroServicos(id, Iniciar);}
    public ResponseEntity<MicroService> IniciarTestesMicroServicos(@RequestParam Long id, @RequestParam Boolean Iniciar)
    { return microServicoGateway.IniciarTestesMicroServicos(id, Iniciar);}
    public ResponseEntity<MicroService> FinalizarMicroServicos(@RequestParam Long id, @RequestParam Boolean finalizar)
    { return microServicoGateway.FinalizarMicroServicos(id, finalizar);}
    public ResponseEntity<MicroService> CancelarFragmentoMicroServicos(@RequestParam Long id, @RequestParam Boolean Cancelar)
    { return microServicoGateway.CancelarFragmentoMicroServicos(id, Cancelar);}
}
