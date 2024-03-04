package App.Model;

import App.Enum.Status;
import App.Record.MicroService;
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
@Builder
@Entity
public class MicroServicoBackup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descrisao;

    private String codigoidentificador;

    private String linkGit;

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

    public MicroServicoBackup(MicroService rec) {
        this.nome = rec.nome();
        this.descrisao = rec.descrisao();
        this.codigoidentificador = rec.codigoidentificador();
        this.linkGit = rec.linkGit();
        this.status = rec.status();
        this.funcionamento = rec.resumoFuncionamento();
        this.cancelado = rec.cancelado();
        this.dataCriacao = rec.dataCriacao();
        this.dataInicio = rec.dataInicio();
        this.dataTestes = rec.dataTeste();
        this.dataConclusao = rec.dataConclusao();
        this.dataCancelamento = rec.dataCancelamento();
    }
}
