package App.RestApi.Domain;

import App.RestApi.Infra.Persistence.Enum.Status;

import java.time.LocalDateTime;
import java.util.List;

public record MicroService(
        String nome,
        String descrisao,
        String codigoidentificador,
        Status status,
        String resumoFuncionamento,
        List<String> arquivos,
        LocalDateTime dataCriacao,
        LocalDateTime dataInicio,
        LocalDateTime dataTeste,
        LocalDateTime dataConclusao,
        LocalDateTime dataCancelamento,
        Boolean cancelado
) {
}
