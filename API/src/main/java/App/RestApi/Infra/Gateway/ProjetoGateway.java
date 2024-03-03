package App.RestApi.Infra.Gateway;

import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Persistence.Entity.ProjetoEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjetoGateway {

    public ResponseEntity<List<ProjetoEntity>> ListarProjetos();
    public ResponseEntity<Projeto> BuscaProjetoPorId(@RequestParam Long id);
    public ResponseEntity<Resource> DownloadDocumentoProjetoPorId(@RequestParam Long id);
    public ResponseEntity<Projeto> NovoProjeto(@RequestParam String nome, @RequestParam String descrisao,
                                               @RequestParam String resumoFuncionamento, @RequestParam String linkGit);

    public ResponseEntity<Projeto> EditarInformacoes(@RequestParam Long id,@RequestParam String nome,
                                                     @RequestParam String descrisao);

    public ResponseEntity<Projeto> AlterarResumoFuncionamento(@RequestParam Long id, @RequestParam String resumoFuncionamento);
    public ResponseEntity<Projeto> AlterarLinkGitProjeto(Long id, String link);
    public ResponseEntity<Projeto> EnviarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files);
    public ResponseEntity<Projeto> AdicionarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files);
    public ResponseEntity<Projeto> AlterarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files);

    public ResponseEntity<Projeto> IniciarProjeto(@RequestParam Long id,@RequestParam Boolean iniciarProjeto);

    public ResponseEntity<Projeto> IniciarTestes(@RequestParam Long id,@RequestParam Boolean iniciarTestes);

    public ResponseEntity<Projeto> FinalizarProjeto(@RequestParam Long id,@RequestParam Boolean finalizar);

    public ResponseEntity<Projeto> Cencelarprojeto(@RequestParam Long id);
}
