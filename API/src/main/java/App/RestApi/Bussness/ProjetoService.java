package App.RestApi.Bussness;

import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Exceptions.EntityNotFoundException;
import App.RestApi.Infra.Exceptions.IllegalStatusException;
import App.RestApi.Infra.Exceptions.NullargumentsException;
import App.RestApi.Infra.Gateway.ProjetoGateway;
import App.RestApi.Infra.Persistence.Entity.MicroServicoEntity;
import App.RestApi.Infra.Persistence.Entity.ProjetoEntity;
import App.RestApi.Infra.Persistence.Enum.Status;
import App.RestApi.Infra.Persistence.Repository.MicroServicoRepository;
import App.RestApi.Infra.Persistence.Repository.ProjetoRepository;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjetoService implements ProjetoGateway {

    private final ProjetoRepository projetoRepository;
    private final MicroServicoRepository microServicoRepository;

    public ProjetoService(ProjetoRepository projetoRepository, MicroServicoRepository microServicoRepository) {
        this.projetoRepository = projetoRepository;
        this.microServicoRepository = microServicoRepository;
    }


    @Override
    public ResponseEntity<List<ProjetoEntity>> ListarProjetos()
    {
        try{
            return new ResponseEntity<>(projetoRepository.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> BuscaProjetoPorId(Long id)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                            entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                            entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Resource> DownloadDocumentoProjetoPorId(Long id)
    {
        return null;
    }

    @Override
    public ResponseEntity<Projeto> NovoProjeto(String nome, String descrisao, String resumoFuncionamento)
    {
        try{
            if(nome != null && descrisao != null && resumoFuncionamento != null)
            {
               ProjetoEntity entity = new ProjetoEntity();
               int dig = (int) (111111 + Math.random() * 999999);
               String codigo = "project_"+dig;
               entity.setNome(nome);
               entity.setDescrisao(descrisao);
               entity.setFuncionamento(resumoFuncionamento);
               entity.setDataCriacao(LocalDateTime.now());
               entity.setTimeStamp(LocalDateTime.now());
               entity.setCodigoidentificador(codigo);
               entity.setCancelado(Boolean.FALSE);
               entity.setStatus(Status.CRIADO);
               projetoRepository.save(entity);
                Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                        entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                        entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
               return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> EditarInformacoes(Long id, String nome, String descrisao)
    {
        try{
            if(id != null && nome != null && descrisao != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    entity.setNome(nome);
                    entity.setDescrisao(descrisao);
                    projetoRepository.save(entity);
                    Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                            entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                            entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> AlterarResumoFuncionamento(Long id, String resumoFuncionamento)
    {
        try{
            if(id != null && resumoFuncionamento != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    entity.setFuncionamento(resumoFuncionamento);
                    projetoRepository.save(entity);
                    Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                            entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                            entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> EnviarArquivos(Long id, MultipartFile[] files)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();

                    projetoRepository.save(entity);
                    Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                            entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                            entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> AdicionarArquivos(Long id, MultipartFile[] files)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    projetoRepository.save(entity);
                    Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                            entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                            entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> AlterarArquivos(Long id, MultipartFile[] files)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    projetoRepository.save(entity);
                    Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                            entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                            entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> IniciarProjeto(Long id, Boolean iniciarProjeto)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    if(entity.getDataCriacao() != null &&
                            entity.getDataInicio() == null &&
                            entity.getDataConclusao() == null &&
                            entity.getDataTestes() == null &&
                            entity.getDataCancelamento() == null &&
                            entity.getCancelado() == false)
                    {
                            entity.setDataInicio(LocalDateTime.now());
                            entity.setTimeStamp(LocalDateTime.now());
                            entity.setStatus(Status.DESENVOLVIMENTO);
                            projetoRepository.save(entity);
                            Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                    entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                    entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                            return new ResponseEntity<>(response,HttpStatus.OK);
                    }
                    else
                    {throw new IllegalStatusException();}
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> IniciarTestes(Long id, Boolean iniciarTestes)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    if(entity.getMicroServicoEntities() != null)
                    {
                        Boolean erro = false;
                        for(MicroServicoEntity ms : entity.getMicroServicoEntities())
                        {
                            if(ms.getStatus() != Status.CONLUIDO)
                            {
                                erro = Boolean.TRUE;
                            }
                        }
                        if(entity.getDataCriacao() != null &&
                                entity.getDataInicio() != null &&
                                entity.getDataConclusao() == null &&
                                entity.getDataTestes() == null &&
                                entity.getDataCancelamento() == null &&
                                entity.getCancelado() == false &&
                                erro == Boolean.TRUE)
                        {
                            entity.setDataTestes(LocalDateTime.now());
                            entity.setTimeStamp(LocalDateTime.now());
                            entity.setStatus(Status.TESTES);
                            projetoRepository.save(entity);
                            Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                    entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                    entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                            return new ResponseEntity<>(response,HttpStatus.OK);
                        }
                    }
                    else
                    {throw new IllegalStatusException();}
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> FinalizarProjeto(Long id, Boolean finalizar)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    projetoRepository.save(entity);
                    if(entity.getDataCriacao() != null &&
                            entity.getDataInicio() == null &&
                            entity.getDataConclusao() == null &&
                            entity.getDataTestes() != null &&
                            entity.getDataCancelamento() == null &&
                            entity.getCancelado() == false)
                    {
                        entity.setDataConclusao(LocalDateTime.now());
                        entity.setTimeStamp(LocalDateTime.now());
                        entity.setStatus(Status.CONLUIDO);
                        projetoRepository.save(entity);
                        Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                        return new ResponseEntity<>(response,HttpStatus.OK);
                    }
                    else
                    {throw new IllegalStatusException();}
                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Projeto> Cencelarprojeto(Long id)
    {
        try{
            if(id != null)
            {
                if(projetoRepository.existsById(id))
                {
                    ProjetoEntity entity = projetoRepository.findById(id).get();
                    if(entity.getMicroServicoEntities() != null)
                    {
                        for(MicroServicoEntity ms : entity.getMicroServicoEntities())
                        {
                            ms.setStatus(Status.CANCELADO);
                            ms.setCancelado(Boolean.TRUE);
                            ms.setTimeStamp(LocalDateTime.now());
                            ms.setDataCancelamento(LocalDateTime.now());
                            microServicoRepository.save(ms);
                        }
                        if(entity.getDataCancelamento() == null &&
                           entity.getCancelado() == false)
                        {
                            entity.setDataCancelamento(LocalDateTime.now());
                            entity.setTimeStamp(LocalDateTime.now());
                            entity.setStatus(Status.CANCELADO);
                            entity.setCancelado(Boolean.TRUE);
                            projetoRepository.save(entity);
                            Projeto response = new Projeto(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                    entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                    entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                            return new ResponseEntity<>(response,HttpStatus.OK);
                        }
                        else
                        {throw new IllegalStatusException();}
                    }

                }
                else
                {throw new EntityNotFoundException();}
            }
            else
            {throw new NullargumentsException();}
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
}
