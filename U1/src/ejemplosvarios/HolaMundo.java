package ejemplosvarios;

public class HolaMundo {
    private String message;

    public HolaMundo() {
        this.message = getMessage();
    }

    public String getMessage() {
        return "Hola, Mundo";
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
