package App.RestApi.Infra.UseCase.Projeto;

import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Gateway.ProjetoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class UseCaseProjetoPut {

    private final ProjetoGateway projetoGateway;

    public UseCaseProjetoPut(ProjetoGateway projetoGateway) {
        this.projetoGateway = projetoGateway;
    }

    public ResponseEntity<Projeto> EditarInformacoes(@RequestParam Long id, @RequestParam String nome,
                                                     @RequestParam String descrisao)
    { return projetoGateway.EditarInformacoes(id, nome, descrisao);}

    public ResponseEntity<Projeto> AlterarResumoFuncionamento(@RequestParam Long id, @RequestParam String resumoFuncionamento)
    { return projetoGateway.AlterarResumoFuncionamento(id, resumoFuncionamento);}

    public ResponseEntity<Projeto> AdicionarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return projetoGateway.AdicionarArquivos(id, files);}
    public ResponseEntity<Projeto> AlterarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return projetoGateway.AlterarArquivos(id, files);}

    public ResponseEntity<Projeto> IniciarProjeto(@RequestParam Long id,@RequestParam Boolean iniciarProjeto)
    { return projetoGateway.IniciarProjeto(id, iniciarProjeto);}

    public ResponseEntity<Projeto> IniciarTestes(@RequestParam Long id,@RequestParam Boolean iniciarTestes)
    { return projetoGateway.IniciarTestes(id, iniciarTestes);}

    public ResponseEntity<Projeto> FinalizarProjeto(@RequestParam Long id,@RequestParam Boolean finalizar)
    { return projetoGateway.FinalizarProjeto(id, finalizar);}

    public ResponseEntity<Projeto> Cencelarprojeto(@RequestParam Long id)
    { return projetoGateway.Cencelarprojeto(id);}

}
