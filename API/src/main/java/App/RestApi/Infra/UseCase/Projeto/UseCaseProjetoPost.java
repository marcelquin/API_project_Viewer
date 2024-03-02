package App.RestApi.Infra.UseCase.Projeto;

import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Gateway.ProjetoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class UseCaseProjetoPost {

    private final ProjetoGateway projetoGateway;

    public UseCaseProjetoPost(ProjetoGateway projetoGateway) {
        this.projetoGateway = projetoGateway;
    }

    public ResponseEntity<Projeto> NovoProjeto(@RequestParam String nome, @RequestParam String descrisao,
                                               @RequestParam String resumoFuncionamento)
    { return projetoGateway.NovoProjeto(nome, descrisao, resumoFuncionamento);}

    public ResponseEntity<Projeto> EnviarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return projetoGateway.EnviarArquivos(id, files);}



}
