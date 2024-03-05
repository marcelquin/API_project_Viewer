package App.RestApi.Bussness.Evento;

import App.RestApi.Infra.Persistence.Enum.Acao;
import App.RestApi.Infra.Persistence.Enum.Eventos;
import App.RestApi.Infra.Persistence.Enum.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "Evento-service", url = "http://localhost:8081/evento_Backup")
public interface EventosService {

    @GetMapping()
    public ResponseEntity<List<?>>Listar(Eventos eventos);

    @PostMapping("/NovoEventoMicroServico")
    public ResponseEntity<?> NovoEventoMicroServico(Acao acao,
                                                    String nome,
                                                    String descrisao,
                                                    String codigoidentificador,
                                                    String linkGit,
                                                    Status status,
                                                    String resumoFuncionamento,
                                                    List<String> arquivos,
                                                    LocalDateTime dataCriacao,
                                                    LocalDateTime dataInicio,
                                                    LocalDateTime dataTeste,
                                                    LocalDateTime dataConclusao,
                                                    LocalDateTime dataCancelamento,
                                                    Boolean cancelado);

    @PostMapping("/NovoEventoMicroServico")
    public ResponseEntity<?> NovoEventoProjetoServico(Acao acao,
                                                    String nome,
                                                    String descrisao,
                                                    String codigoidentificador,
                                                    String linkGit,
                                                    Status status,
                                                    String resumoFuncionamento,
                                                    List<String> arquivos,
                                                    LocalDateTime dataCriacao,
                                                    LocalDateTime dataInicio,
                                                    LocalDateTime dataTeste,
                                                    LocalDateTime dataConclusao,
                                                    LocalDateTime dataCancelamento,
                                                    Boolean cancelado);

}
