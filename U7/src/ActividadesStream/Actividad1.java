/** - Actividad 1:
 A partir de una lista de 100 enteros aleatorios menores que 1000:
 Calcula cuántos son primos.
 Determina cuál es el mayor, el menor, la suma de todos ellos y el valor promedio.
 */
package ActividadesStream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Actividad1 {
    public static void main(String[] args) {
        Integer [] sorteos = new Integer[100];
        List<Integer> lista = new ArrayList<>();
        for (Integer n: sorteos
             ) {
            n = (int) (Math.random() * (999)) +1;
            lista.add(n);
        }
        lista.forEach(s -> System.out.print(s + " "));
        Predicate<Integer> esprimo = integer -> {
            boolean loEs = true;
            if (integer % 2 == 0) {
                return false;
            }
            for (int i = 2; i < integer; i++) {
                if (integer % i == 0) {
                    return false;
                }
            }
            return loEs;
        };

        long cuantosPrimos = lista.stream()
                                        .filter(esprimo)
                                        .count();

        System.out.println();
        System.out.println("El número de números primos es: " + cuantosPrimos);
        IntSummaryStatistics estadisticas = (IntSummaryStatistics) lista.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(estadisticas);



    }
}
