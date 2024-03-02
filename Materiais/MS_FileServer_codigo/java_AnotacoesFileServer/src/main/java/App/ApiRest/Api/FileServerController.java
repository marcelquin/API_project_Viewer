package App.ApiRest.Api;

import App.ApiRest.Domain.Arquivo;
import App.ApiRest.Infra.UseCase.UseCaseFileServerGet;
import App.ApiRest.Infra.UseCase.UseCaseFileServerPost;
import App.ApiRest.Infra.UseCase.UseCaseFileServerPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("ms_FileServer")
@Tag(name = "FileServer", description = "Manipula arquivos")
public class FileServerController {

    private final UseCaseFileServerGet caseFileServerGet;
    private final UseCaseFileServerPost caseFileServerPost;
    private final UseCaseFileServerPut caseFileServerPut;

    public FileServerController(UseCaseFileServerGet caseFileServerGet, UseCaseFileServerPost caseFileServerPost, UseCaseFileServerPut caseFileServerPut) {
        this.caseFileServerGet = caseFileServerGet;
        this.caseFileServerPost = caseFileServerPost;
        this.caseFileServerPut = caseFileServerPut;
    }

    @Operation(summary = "Busca arquivo e disponibiliza o download", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca Realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/downloadFiles")
    public ResponseEntity<Resource> downloadFiles(@RequestParam String codigo) throws IOException
    { return caseFileServerGet.downloadFiles(codigo);}


    @Operation(summary = "Salva Novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping(value = "/Upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Arquivo> Upload(@RequestParam String codigo,
                                          @RequestPart MultipartFile[] files)
    {return caseFileServerPost.Upload(codigo, files);}

    @Operation(summary = "Altera dados do pacote", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping(value = "/Update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Arquivo> Update(@RequestParam String codigo,@RequestParam List<String> arquivos,
                                          @RequestPart MultipartFile[] files)
    { return caseFileServerPut.Update(codigo, arquivos, files);}

    @Operation(summary = "Adiciona arquivo ao pacote", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping(value = "/AddFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Arquivo> AddFile(@RequestParam String codigo,
                                           @RequestPart MultipartFile[] files)
    { return caseFileServerPut.AddFile(codigo, files);}



}
