package App.RestApi.Api;

import App.RestApi.Bussness.EventosServiceLocal;
import App.RestApi.Infra.Persistence.Enum.Eventos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Eventos")
@Tag(name = "Eventos",
     description = "Exibe Eventos salvos pelo micro serviço de backup"  )
public class EventosController {

    private final EventosServiceLocal service;


    public EventosController(EventosServiceLocal service) {
        this.service = service;
    }

    @Operation(summary = "Lista todos os registros", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops! Algo deu errado"),
    })
    @GetMapping("/listar")
    public ResponseEntity<List<?>> listarEventos(Eventos eventos)
    { return service.listarEventos(eventos);}
}
