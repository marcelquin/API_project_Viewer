package App.RestApi.Infra.UseCase.MicroServico;

import App.RestApi.Domain.MicroService;
import App.RestApi.Infra.Gateway.MicroServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class UseCaseMicroServicoPost {

    private final MicroServicoGateway microServicoGateway;

    public UseCaseMicroServicoPost(MicroServicoGateway microServicoGateway) {
        this.microServicoGateway = microServicoGateway;
    }

    public ResponseEntity<MicroService> NovoMicroServicos(@RequestParam Long idProjeto, @RequestParam String nome, @RequestParam String descrisao, @RequestParam String linkGit,
                                                          @RequestParam String resumoFuncionamento)
    { return microServicoGateway.NovoMicroServico(idProjeto, nome, descrisao, linkGit, resumoFuncionamento);}
    public ResponseEntity<MicroService> EnviarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return microServicoGateway.EnviarArquivosMicroServicos(id, files);}



}
