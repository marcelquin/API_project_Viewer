package App.RestApi.Infra.Persistence.Entity;

import App.RestApi.Infra.Persistence.Enum.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {

    private String nome;

    private String descrisao;

    private String codigoidentificador;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String funcionamento;

    private List<String> Arquivos;

    private Boolean cancelado;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataTestes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConclusao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCancelamento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

}
