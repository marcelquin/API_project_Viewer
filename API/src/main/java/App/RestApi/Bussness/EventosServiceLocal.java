package App.RestApi.Bussness;

import App.RestApi.Bussness.Evento.EventosService;
import App.RestApi.Infra.Persistence.Enum.Eventos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosServiceLocal {

    private final EventosService eventosService;

    public EventosServiceLocal(EventosService eventosService) {
        this.eventosService = eventosService;
    }


    public ResponseEntity<List<?>> listarEventos(Eventos eventos)
    {
        try
        {
            eventosService.Listar(eventos);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
}
