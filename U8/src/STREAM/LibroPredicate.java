package STREAM;

import java.util.function.Predicate;

public class LibroPredicate {
    public static void main(String[] args) {
        // Predicate<T> método boolean test (T valor)
        Predicate<Integer> esPositivo = x -> x > 0;
        // test
        System.out.println(esPositivo.test(-5));
        // negate
        System.out.println(esPositivo.negate().test(-5));
        // Predicate<T> and(Predicate<? super T> otro)
        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<Integer> esPositivoYPar = esPar.and(esPositivo);
        System.out.println(esPositivoYPar.test(10));
        // Predicate<T> or(PPredicate<? super T> otro)
        Predicate<Integer> esPositivoOPar = esPar.or(esPositivo);
        System.out.println(esPositivoOPar.test(-6));
    }
}
