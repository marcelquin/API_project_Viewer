package App.RestApi.Infra.Exceptions;

public class illegalstatusException extends RuntimeException {

    public illegalstatusException() {
        super("Status incompativel com a função desejada");
    }

    public illegalstatusException(String message) {
        super(message);
    }

}
