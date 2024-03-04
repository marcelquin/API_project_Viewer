package App.RestApi.Api;

import App.RestApi.Domain.MicroService;
import App.RestApi.Infra.Persistence.Entity.MicroServicoEntity;
import App.RestApi.Infra.UseCase.MicroServico.UseCaseMicroServicoGet;
import App.RestApi.Infra.UseCase.MicroServico.UseCaseMicroServicoPost;
import App.RestApi.Infra.UseCase.MicroServico.UseCaseMicroServicoPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("micro_servico")
@RestController
@Tag(name = "micro_servico",
     description = "Manipula dados relacionados a entidade")
public class MicroServiceController {

    private final UseCaseMicroServicoGet microServicoGet;
    private final UseCaseMicroServicoPost microServicoPost;
    private final UseCaseMicroServicoPut microServicoPut;

    public MicroServiceController(UseCaseMicroServicoGet microServicoGet, UseCaseMicroServicoPost microServicoPost, UseCaseMicroServicoPut microServicoPut) {
        this.microServicoGet = microServicoGet;
        this.microServicoPost = microServicoPost;
        this.microServicoPut = microServicoPut;
    }
    @Operation(summary = "Lista todos os registros", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/ListarMicroServicos")
    public ResponseEntity<List<MicroServicoEntity>> ListarMicroServicos()
    { return microServicoGet.ListarMicroServicos();}
    @Operation(summary = "Busca Registro por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/BuscaMicroServicosPorId")
    public ResponseEntity<MicroService> BuscaMicroServicosPorId(@RequestParam Long id)
    { return microServicoGet.BuscaMicroServicosPorId(id);}
    @Operation(summary = "Busca e realiza o download da documentação zipada", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/DownloadDocumentoMicroServicosPorId")
    public ResponseEntity<Resource> DownloadDocumentoMicroServicosPorId(@RequestParam Long id)
    { return microServicoGet.DownloadDocumentoMicroServicosPorId(id);}
    @Operation(summary = "Salva Novo registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PostMapping("/NovoMicroServico")
    public ResponseEntity<MicroService> NovoMicroServico(@RequestParam Long idProjeto,@RequestParam String nome,@RequestParam String descrisao,@RequestParam String linkGit,
                                                         @RequestParam String resumoFuncionamento)
    { return microServicoPost.NovoMicroServicos(idProjeto, nome, descrisao, linkGit, resumoFuncionamento);}
    @Operation(summary = "Altera Informações do micro serviço", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/EditarInformacoesMicroServicos")
    public ResponseEntity<MicroService> EditarInformacoesMicroServicos(@RequestParam Long id,@RequestParam String nome,
                                                                       @RequestParam String descrisao)
    { return microServicoPut.EditarInformacoesMicroServicos(id, nome, descrisao);}
    @Operation(summary = "Altera Resumo de funcionamento do micro serviço", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/AlterarResumoFuncionamentoMicroServicos")
    public ResponseEntity<MicroService> AlterarResumoFuncionamentoMicroServicos(@RequestParam Long id, @RequestParam String resumoFuncionamento)
    { return microServicoPut.AlterarResumoFuncionamentoMicroServicos(id, resumoFuncionamento);}
    @Operation(summary = "Envia Arquivos de documentação do projeto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PostMapping(value = "/EnviarArquivosMicroServicos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MicroService> EnviarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return microServicoPost.EnviarArquivosMicroServicos(id, files);}
    @Operation(summary = "Adiciona Arquivos de documentação do projeto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/AdicionarArquivosMicroServicos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MicroService> AdicionarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return microServicoPut.AdicionarArquivosMicroServicos(id, files);}
    @Operation(summary = "Altera Arquivos de documentação do projeto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/AlterarArquivosMicroServicos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MicroService> AlterarArquivosMicroServicos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return microServicoPut.AlterarArquivosMicroServicos(id, files);}
    @Operation(summary = "Altera Link do GitHub do projeto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/AlterarLinkGitMicroServicos")
    public ResponseEntity<MicroService> AlterarLinkGitMicroServicos(@RequestParam Long id,@RequestParam String link)
    { return microServicoPut.AlterarLinkGitMicroServicos(id, link);}
    @Operation(summary = "Altera Status do micro serviço para Inicio de desenvolvimento", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/IniciarDesenvolvimentoMicroServicos")
    public ResponseEntity<MicroService> IniciarDesenvolvimentoMicroServicos(@RequestParam Long id,@RequestParam Boolean Iniciar)
    { return microServicoPut.IniciarDesenvolvimentoMicroServicos(id, Iniciar);}
    @Operation(summary = "Altera Status do micro serviço para fase de Testes", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/IniciarTestesMicroServicos")
    public ResponseEntity<MicroService> IniciarTestesMicroServicos(@RequestParam Long id, @RequestParam Boolean Iniciar)
    { return microServicoPut.IniciarTestesMicroServicos(id, Iniciar);}
    @Operation(summary = "Altera Status do micro serviço para Finalizado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/FinalizarFragmentoMicroServicos")
    public ResponseEntity<MicroService> FinalizarMicroServicos(@RequestParam Long id, @RequestParam Boolean finalizar)
    { return microServicoPut.FinalizarMicroServicos(id, finalizar);}

    @Operation(summary = "Altera Status do micro serviço para Cancelado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/CancelarFragmentoMicroServicos")
    public ResponseEntity<MicroService> CancelarFragmentoMicroServicos(@RequestParam Long id, @RequestParam Boolean Cancelar)
    { return microServicoPut.CancelarFragmentoMicroServicos(id, Cancelar);}

}
