package App.RestApi.Bussness;

import App.RestApi.Domain.MicroService;
import App.RestApi.Domain.Projeto;
import App.RestApi.Infra.Exceptions.EntityNotFoundException;
import App.RestApi.Infra.Exceptions.IllegalStatusException;
import App.RestApi.Infra.Exceptions.NullargumentsException;
import App.RestApi.Infra.Gateway.MicroServicoGateway;
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
public class MicroServicoService implements MicroServicoGateway {

    private final ProjetoRepository projetoRepository;
    private final MicroServicoRepository microServicoRepository;

    public MicroServicoService(ProjetoRepository projetoRepository, MicroServicoRepository microServicoRepository) {
        this.projetoRepository = projetoRepository;
        this.microServicoRepository = microServicoRepository;
    }

    @Override
    public ResponseEntity<List<MicroServicoEntity>> ListarMicroServicos()
    {
        try{
            return new ResponseEntity<>(microServicoRepository.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<MicroService> BuscaMicroServicosPorId(Long id)
    {
        try{
            if(id != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador()
                            , entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<Resource> DownloadDocumentoMicroServicosPorId(Long id)
    {
        try{
            if(id != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();

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
    public ResponseEntity<MicroService> NovoMicroServico(Long idProjeto, String nome, String descrisao, String linkGit, String resumoFuncionamento)
    {
        try{
            if(idProjeto != null &&
               nome != null &&
               descrisao != null &&
               resumoFuncionamento != null)
            {
                if(projetoRepository.existsById(idProjeto))
                {
                    ProjetoEntity projeto = projetoRepository.findById(idProjeto).get();
                    if(projeto.getStatus() == Status.DESENVOLVIMENTO)
                    {
                        MicroServicoEntity entity = new MicroServicoEntity();
                        entity.setNome(nome);
                        entity.setDescrisao(descrisao);
                        entity.setFuncionamento(resumoFuncionamento);
                        entity.setLinkGit(linkGit);
                        entity.setCancelado(Boolean.FALSE);
                        entity.setStatus(Status.CRIADO);
                        entity.setDataCriacao(LocalDateTime.now());
                        entity.setTimeStamp(LocalDateTime.now());
                        microServicoRepository.save(entity);
                        projeto.getMicroServicoEntities().add(entity);
                        projetoRepository.save(projeto);
                        MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador()
                                , entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                        return new ResponseEntity<>(response,HttpStatus.CREATED);
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
    public ResponseEntity<MicroService> EditarInformacoesMicroServicos(Long id, String nome, String descrisao)
    {
        try{
            if(id != null &&
               nome != null &&
               descrisao != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    entity.setNome(nome);
                    entity.setDescrisao(descrisao);
                    entity.setTimeStamp(LocalDateTime.now());
                    microServicoRepository.save(entity);
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador()
                            , entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<MicroService> AlterarResumoFuncionamentoMicroServicos(Long id, String resumoFuncionamento)
    {
        try{
            if(id != null &&
               resumoFuncionamento != null )
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    entity.setFuncionamento(resumoFuncionamento);
                    entity.setTimeStamp(LocalDateTime.now());
                    microServicoRepository.save(entity);
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                             entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<MicroService> EnviarArquivosMicroServicos(Long id, MultipartFile[] files)
    {
        try{
            if(id != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                             entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<MicroService> AdicionarArquivosMicroServicos(Long id, MultipartFile[] files)
    {
        try{
            if(id != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                             entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<MicroService> AlterarArquivosMicroServicos(Long id, MultipartFile[] files)
    {
        try{
            if(id != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                             entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<MicroService> AlterarLinkGitMicroServicos(Long id, String link)
    {
        try{
            if(id != null &&
               link != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    entity.setLinkGit(link);
                    entity.setTimeStamp(LocalDateTime.now());
                    microServicoRepository.save(entity);
                    MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                             entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
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
    public ResponseEntity<MicroService> IniciarDesenvolvimentoMicroServicos(Long id, Boolean Iniciar)
    {
        try{
            if(id != null &&
               Iniciar != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    if(entity.getDataCriacao() != null &&
                       entity.getDataInicio() == null &&
                       entity.getDataTestes() == null &&
                       entity.getDataConclusao() == null &&
                       entity.getDataCancelamento() == null &&
                       entity.getCancelado() == Boolean.FALSE )
                    {
                        entity.setStatus(Status.DESENVOLVIMENTO);
                        entity.setDataInicio(LocalDateTime.now());
                        entity.setTimeStamp(LocalDateTime.now());
                        microServicoRepository.save(entity);
                        MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                        return new ResponseEntity<>(response,HttpStatus.OK);
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

    @Override
    public ResponseEntity<MicroService> IniciarTestesMicroServicos(Long id, Boolean Iniciar)
    {
        try{
            if(id != null &&
                    Iniciar != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    if(entity.getDataCriacao() != null &&
                            entity.getDataInicio() != null &&
                            entity.getDataTestes() == null &&
                            entity.getDataConclusao() == null &&
                            entity.getDataCancelamento() == null &&
                            entity.getCancelado() == Boolean.FALSE )
                    {
                        entity.setStatus(Status.TESTES);
                        entity.setDataTestes(LocalDateTime.now());
                        entity.setTimeStamp(LocalDateTime.now());
                        microServicoRepository.save(entity);
                        MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                        return new ResponseEntity<>(response,HttpStatus.OK);
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

    @Override
    public ResponseEntity<MicroService> FinalizarFragmentoMicroServicos(Long id, Boolean finalizar)
    {
        try{
            if(id != null && finalizar != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    if(entity.getDataCriacao() != null &&
                            entity.getDataInicio() != null &&
                            entity.getDataTestes() != null &&
                            entity.getDataConclusao() == null &&
                            entity.getDataCancelamento() == null &&
                            entity.getCancelado() == Boolean.FALSE )
                    {
                        entity.setStatus(Status.CONLUIDO);
                        entity.setDataConclusao(LocalDateTime.now());
                        entity.setTimeStamp(LocalDateTime.now());
                        microServicoRepository.save(entity);
                        MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                        return new ResponseEntity<>(response,HttpStatus.OK);
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
    @Override
    public ResponseEntity<MicroService> CancelarFragmentoMicroServicos(Long id, Boolean Cancelar)
    {
        try{
            if(id != null && Cancelar != null)
            {
                if(microServicoRepository.existsById(id))
                {
                    MicroServicoEntity entity = microServicoRepository.findById(id).get();
                    if(entity.getCancelado() == Boolean.FALSE )
                    {
                        entity.setStatus(Status.CANCELADO);
                        entity.setDataCancelamento(LocalDateTime.now());
                        entity.setCancelado(Boolean.TRUE);
                        entity.setTimeStamp(LocalDateTime.now());
                        microServicoRepository.save(entity);
                        MicroService response = new MicroService(entity.getNome(), entity.getDescrisao(), entity.getCodigoidentificador(),
                                entity.getLinkGit(),entity.getStatus(), entity.getFuncionamento(),entity.getArquivos(),entity.getDataCriacao(),entity.getDataInicio(),entity.getDataTestes(),
                                entity.getDataConclusao(),entity.getDataCancelamento(),entity.getCancelado());
                        return new ResponseEntity<>(response,HttpStatus.OK);
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
