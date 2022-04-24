package STREAM;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LibroConsumer {
    public static void main(String[] args) {
        // Consumer<T> metodo void accept (T t)
        Consumer<Cliente> saludoCliente = c -> System.out.println("Hola, " + c.getNombre());

        Cliente c1 = new Cliente(12,"Aurelio Moncada Pemán", "22.125.888D");
        Cliente c2 = new Cliente(48,"Aurelio Moncada Hernán", "21.444.265M");
        Cliente c3 = new Cliente(52,"Eva Lazo Perez", "24.784.861J");
        Cliente c4 = new Cliente(2,"Joaquín Pastor López", "23.367.977L");
        Cliente c5 = new Cliente(1,"Paco Herrera Herrero", "18.258.456A");
        Cliente c6 = new Cliente(13,"Francisco Buendía Lacalle", "46.151.157E");
        List<Cliente> clientes = Arrays.asList(c1,c2,c3,c4,c5,c6);
        // accept
        saludoCliente.accept(c3);
        System.out.println("----");
        // forEach(Consumer)
        clientes.forEach(saludoCliente);
    }
}
