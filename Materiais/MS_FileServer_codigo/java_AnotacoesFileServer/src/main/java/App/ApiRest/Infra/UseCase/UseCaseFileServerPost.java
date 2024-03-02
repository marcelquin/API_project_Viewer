package App.ApiRest.Infra.UseCase;

import App.ApiRest.Domain.Arquivo;
import App.ApiRest.Infra.Gateway.FileServerGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class UseCaseFileServerPost {

    private final FileServerGateway serverGateway;

    public UseCaseFileServerPost(FileServerGateway serverGateway) {
        this.serverGateway = serverGateway;
    }

    public ResponseEntity<Arquivo> Upload(@RequestParam String codigo,
                                          @RequestPart MultipartFile[] files)
    {return serverGateway.Upload(codigo, files);}
}
