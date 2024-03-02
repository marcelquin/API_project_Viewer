package App.ApiRest.Infra.UseCase;

import App.ApiRest.Infra.Gateway.FileServerGateway;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public class UseCaseFileServerGet {

    private final FileServerGateway serverGateway;

    public UseCaseFileServerGet(FileServerGateway serverGateway) {
        this.serverGateway = serverGateway;
    }

    public ResponseEntity<Resource> downloadFiles(@RequestParam String codigo) throws IOException
    { return serverGateway.downloadFiles(codigo);}
}
