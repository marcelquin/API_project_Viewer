package App.Service;

import App.Enum.Acao;
import App.Enum.Evento;
import App.Enum.Status;
import App.Model.MicroServicoBackup;
import App.Model.ProjetoBackup;
import App.Record.MicroService;
import App.Record.Projeto;
import App.repository.MicroServicoRepository;
import App.repository.ProjetoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class EventoService {


    private final ProjetoRepository projetoRepository;
    private final MicroServicoRepository microServicoRepository;

    public EventoService(ProjetoRepository projetoRepository, MicroServicoRepository microServicoRepository) {
        this.projetoRepository = projetoRepository;
        this.microServicoRepository = microServicoRepository;
    }


    public ResponseEntity<List<?>>Listar(Evento evento)
    {
        try{
            if(evento != null)
            {
                if(evento == Evento.PROJETO)
                {
                    return new ResponseEntity<>(projetoRepository.findAll(), HttpStatus.OK);
                }
                else
                {
                    return new ResponseEntity<>(microServicoRepository.findAll(), HttpStatus.OK);
                }
            }
            else
            {
                return new ResponseEntity<>(BAD_REQUEST);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    public ResponseEntity<MicroService>NovoEventoMicroServico( Acao acao,
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
    {
        try{
            if(nome != null && descrisao != null &&
            codigoidentificador != null && linkGit != null &&
            status != null && resumoFuncionamento != null &&
            arquivos != null && dataCriacao != null &&
            dataInicio != null && dataTeste != null &&
            dataConclusao != null && dataCancelamento != null)
            {
                MicroService response = new MicroService(acao,nome,descrisao,codigoidentificador,linkGit,
                                                        status,resumoFuncionamento,arquivos,dataCriacao,dataInicio,
                                                        dataTeste,dataConclusao,dataCancelamento,cancelado);
                MicroServicoBackup entity = new MicroServicoBackup(response);
                entity.setTimeStamp(LocalDateTime.now());
                microServicoRepository.save(entity);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            else
            {
                return new ResponseEntity<>(BAD_REQUEST);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }


    public ResponseEntity<Projeto>NovoEventoServico( Acao acao,
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
    {
        try{
            if(nome != null && descrisao != null &&
                    codigoidentificador != null && linkGit != null &&
                    status != null && resumoFuncionamento != null &&
                    arquivos != null && dataCriacao != null &&
                    dataInicio != null && dataTeste != null &&
                    dataConclusao != null && dataCancelamento != null)
            {
                Projeto response = new Projeto(acao,nome,descrisao,codigoidentificador,linkGit,
                        status,resumoFuncionamento,arquivos,dataCriacao,dataInicio,
                        dataTeste,dataConclusao,dataCancelamento,cancelado);
                ProjetoBackup entity = new ProjetoBackup(response);
                entity.setTimeStamp(LocalDateTime.now());
                projetoRepository.save(entity);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            else
            {
                return new ResponseEntity<>(BAD_REQUEST);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

}
