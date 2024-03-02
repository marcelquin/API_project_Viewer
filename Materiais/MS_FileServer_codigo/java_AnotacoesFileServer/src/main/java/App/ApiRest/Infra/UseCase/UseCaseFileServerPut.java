package App.ApiRest.Infra.UseCase;

import App.ApiRest.Domain.Arquivo;
import App.ApiRest.Infra.Gateway.FileServerGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class UseCaseFileServerPut {

    private final FileServerGateway serverGateway;

    public UseCaseFileServerPut(FileServerGateway serverGateway) {
        this.serverGateway = serverGateway;
    }


    public ResponseEntity<Arquivo> Update(@RequestParam String codigo, @RequestParam List<String> arquivos,
                                          @RequestPart MultipartFile[] files)
    { return  serverGateway.Update(codigo, arquivos, files);}

    public ResponseEntity<Arquivo> AddFile(@RequestParam String codigo,
                                           @RequestPart MultipartFile[] files)
    { return serverGateway.AddFile(codigo, files);}

}
