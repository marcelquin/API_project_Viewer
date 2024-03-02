package App.ApiRest.Infra.Gateway;

import App.ApiRest.Domain.Arquivo;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileServerGateway {

    public ResponseEntity<Arquivo> Upload(@RequestParam String codigo,
                                          @RequestPart MultipartFile[] files);

    public ResponseEntity<Arquivo> Update(@RequestParam String codigo,@RequestParam List<String> arquivos,
                                          @RequestPart MultipartFile[] files);

    public ResponseEntity<Arquivo> AddFile(@RequestParam String codigo,
                                          @RequestPart MultipartFile[] files);

    public ResponseEntity<Resource> downloadFiles(@RequestParam String codigo) throws IOException;
}
