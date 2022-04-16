package EstudiandoLambdaStream;

import java.util.function.Function;

public class LibroFunction {
    public static void main(String[] args) {
        // Function<T,V>: metodo  V apply(T x)
        Function<Double, Double> cuadrado = x -> x*x;
        System.out.println(cuadrado.apply(3.0)); // 3*3
        // andThen
        Function<Double, Double> cuadrado2 = cuadrado.andThen(cuadrado);
        System.out.println(cuadrado2.apply(3.0)); // 9*9
        Function<Double, Double> cuadrado3 = cuadrado.compose(cuadrado2);
        System.out.println(cuadrado3.apply(3.0)); // 81*81
        // referencias a métodos
        Function<Double, Double> raiz = Math::sqrt;
        System.out.println(raiz.apply(9.0)); // raiz de 9

        Function<String, Saludo> construyeSaludo = Saludo::new;
        Saludo s = construyeSaludo.apply("Andrea");
        System.out.println(s);
    }
}
