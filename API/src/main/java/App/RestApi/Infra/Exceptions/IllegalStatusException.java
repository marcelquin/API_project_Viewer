package App.RestApi.Infra.Exceptions;

public class IllegalStatusException extends RuntimeException {

    public IllegalStatusException() {
        super("Status incompativel com a função desejada");
    }

    public IllegalStatusException(String message) {
        super(message);
    }

}
