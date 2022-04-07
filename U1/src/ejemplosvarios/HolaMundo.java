package ejemplosvarios;

public class HolaMundo {
    private String message;

    public void main(String[] args) {
        System.out.println(this.getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = "Hola, Mundo";
    }
}
