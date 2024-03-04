package App.RestApi.Api;

import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Persistence.Entity.ProjetoEntity;
import App.RestApi.Infra.UseCase.Projeto.UseCaseProjetoGet;
import App.RestApi.Infra.UseCase.Projeto.UseCaseProjetoPost;
import App.RestApi.Infra.UseCase.Projeto.UseCaseProjetoPut;
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

@RequestMapping("projeto")
@RestController
@Tag(name = "projeto",
     description = "Manipula dados relacionados a entidade")
public class ProjetoController {

    private final UseCaseProjetoGet projetoGet;
    private final UseCaseProjetoPost projetoPost;
    private final UseCaseProjetoPut projetoPut;

    public ProjetoController(UseCaseProjetoGet projetoGet, UseCaseProjetoPost projetoPost, UseCaseProjetoPut projetoPut) {
        this.projetoGet = projetoGet;
        this.projetoPost = projetoPost;
        this.projetoPut = projetoPut;
    }

    @Operation(summary = "Lista todos os registros", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/ListarProjetos")
    public ResponseEntity<List<ProjetoEntity>> ListarProjetos()
    { return projetoGet.ListarProjetos();}

    @Operation(summary = "Busca Registro por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/BuscaProjetoPorId")
    public ResponseEntity<Projeto> BuscaProjetoPorId(@RequestParam Long id)
    { return projetoGet.BuscaProjetoPorId(id);}

    @Operation(summary = "Busca e realiza o download da documentação zipada", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/DownloadDocumentoProjetoPorId")
    public ResponseEntity<Resource> DownloadDocumentoProjetoPorId(@RequestParam Long id)
    { return projetoGet.DownloadDocumentoProjetoPorId(id);}

    @Operation(summary = "Salva Novo registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PostMapping("/NovoProjeto")
    public ResponseEntity<Projeto> NovoProjeto(@RequestParam String nome, @RequestParam String descrisao,
                                               @RequestParam String resumoFuncionamento, @RequestParam String linkGit)
    { return projetoPost.NovoProjeto(nome, descrisao, resumoFuncionamento, linkGit);}

    @Operation(summary = "Altera Informações do micro serviço", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/EditarInformacoes")
    public ResponseEntity<Projeto> EditarInformacoes(@RequestParam Long id,@RequestParam String nome,
                                                     @RequestParam String descrisao)
    { return projetoPut.EditarInformacoes(id, nome, descrisao);}

    @Operation(summary = "Altera Resumo de funcionamento do micro serviço", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/AlterarResumoFuncionamento")
    public ResponseEntity<Projeto> AlterarResumoFuncionamento(@RequestParam Long id, @RequestParam String resumoFuncionamento)
    { return projetoPut.AlterarResumoFuncionamento(id, resumoFuncionamento);}

    @Operation(summary = "Altera Link do GitHub do projeto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping("/AlterarLinkGitProjeto")
    public ResponseEntity<Projeto> AlterarLinkGitProjeto(Long id, String link)
    { return projetoPut.AlterarLinkGitProjeto(id, link);}

    @Operation(summary = "Envia Arquivos de documentação do projeto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PostMapping(value = "/EnviarArquivosMicroServicos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Projeto> EnviarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return projetoPost.EnviarArquivos(id, files);}

    @Operation(summary = "Adiciona Arquivos de documentação do projeto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/AdicionarArquivosMicroServicos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Projeto> AdicionarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return projetoPut.AdicionarArquivos(id, files);}

    @Operation(summary = "Altera Arquivos de documentação do projeto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/AlterarArquivos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Projeto> AlterarArquivos(@RequestParam Long id,@RequestPart MultipartFile[] files)
    { return projetoPut.AlterarArquivos(id, files);}

    @Operation(summary = "Altera Status do projeto para Desenvolvimento", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/IniciarProjeto")
    public ResponseEntity<Projeto> IniciarProjeto(@RequestParam Long id,@RequestParam Boolean iniciarProjeto)
    { return projetoPut.IniciarProjeto(id, iniciarProjeto);}

    @Operation(summary = "Altera Status do projeto para Fase de testes", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/IniciarTestes")
    public ResponseEntity<Projeto> IniciarTestes(@RequestParam Long id,@RequestParam Boolean iniciarTestes)
    { return projetoPut.IniciarTestes(id, iniciarTestes);}

    @Operation(summary = "Altera Status do projeto para Finalizado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/FinalizarProjeto")
    public ResponseEntity<Projeto> FinalizarProjeto(@RequestParam Long id,@RequestParam Boolean finalizar)
    { return projetoPut.FinalizarProjeto(id, finalizar);}

    @Operation(summary = "Altera Status do projeto para Cancelado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @PutMapping(value = "/Cencelarprojeto")
    public ResponseEntity<Projeto> Cencelarprojeto(@RequestParam Long id)
    { return projetoPut.Cencelarprojeto(id);}
}
