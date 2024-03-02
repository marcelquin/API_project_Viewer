package App.RestApi.Infra.Gateway;

import App.RestApi.Domain.MicroService;
import App.RestApi.Infra.Persistence.Entity.MicroServicoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.List;

public interface MicroServicoGateway {

    public ResponseEntity<List<MicroServicoEntity>>ListarMicroServicos();
    public ResponseEntity<MicroService> BuscaMicroServicosPorId(@RequestParam Long id);

    public ResponseEntity<Resource> DownloadDocumentoMicroServicosPorId(@RequestParam Long id);
    public ResponseEntity<MicroService> NovoMicroServico(@RequestParam Long idProjeto,@RequestParam String nome,@RequestParam String descrisao,@RequestParam String linkGit,
                                                          @RequestParam String resumoFuncionamento);
    public ResponseEntity<MicroService> EditarInformacoesMicroServicos(@RequestParam Long id,@RequestParam String nome,
                                                       @RequestParam String descrisao);
    public ResponseEntity<MicroService> AlterarResumoFuncionamentoMicroServicos(@RequestParam Long id, @RequestParam String resumoFuncionamento);
    public ResponseEntity<MicroService> EnviarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files);
    public ResponseEntity<MicroService> AdicionarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files);
    public ResponseEntity<MicroService> AlterarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files);

    public ResponseEntity<MicroService> AlterarLinkGitMicroServicos(@RequestParam Long id,@RequestParam String link);
    public ResponseEntity<MicroService> IniciarDesenvolvimentoMicroServicos(@RequestParam Long id,@RequestParam Boolean Iniciar);
    public ResponseEntity<MicroService> IniciarTestesMicroServicos(@RequestParam Long id, @RequestParam Boolean Iniciar);
    public ResponseEntity<MicroService> FinalizarFragmentoMicroServicos(@RequestParam Long id, @RequestParam Boolean finalizar);
    public ResponseEntity<MicroService> CancelarFragmentoMicroServicos(@RequestParam Long id, @RequestParam Boolean Cancelar);
}
