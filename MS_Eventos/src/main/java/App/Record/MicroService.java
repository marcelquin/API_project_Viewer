package App.Record;



import App.Enum.Acao;
import App.Enum.Status;

import java.time.LocalDateTime;
import java.util.List;

public record MicroService(
        Acao acao,
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
        Boolean cancelado
) {
}
