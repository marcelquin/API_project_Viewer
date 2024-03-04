package App.Controller;

import App.Enum.Acao;
import App.Enum.Evento;
import App.Enum.Status;
import App.Record.MicroService;
import App.Record.Projeto;
import App.Service.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("evento_Backup")
@Tag(name = "evento_Backup",
    description ="Manipula dados relacionados a entidade" )
public class EventosController {

    private final EventoService service;

    public EventosController(EventoService service) {
        this.service = service;
    }


    @Operation(summary = "Lista registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! algo errado"),
    })
    @GetMapping()
    public ResponseEntity<List<?>> Listar(Evento evento)
    { return service.Listar(evento);}

    @Operation(summary = "Salva Novo registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! algo errado"),
    })
    @PostMapping("/NovoEventoMicroServico")
    public ResponseEntity<MicroService>NovoEventoMicroServico(Acao acao,
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
                                                              Boolean cancelado)
    { return service.NovoEventoMicroServico(acao, nome, descrisao, codigoidentificador, linkGit, status, resumoFuncionamento, arquivos, dataCriacao, dataInicio, dataTeste, dataConclusao, dataCancelamento, cancelado);}

    @Operation(summary = "Salva Novo registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! algo errado"),
    })
    @PostMapping("/NovoEventoServico")
    public ResponseEntity<Projeto>NovoEventoServico(Acao acao,
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
                                                    Boolean cancelado)
    { return service.NovoEventoServico(acao, nome, descrisao, codigoidentificador, linkGit, status, resumoFuncionamento, arquivos, dataCriacao, dataInicio, dataTeste, dataConclusao, dataCancelamento, cancelado);}
}
