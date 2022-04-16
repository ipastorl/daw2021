package EstudiandoLambdaStream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibroStream {

    public static void main(String[] args) {
        Cliente c1 = new Cliente(12,"Aurelio Moncada Pemán", "22.125.888D");
        Cliente c2 = new Cliente(48,"Aurelio Moncada Hernán", "21.444.265M");
        Cliente c3 = new Cliente(52,"Eva Lazo Perez", "24.784.861J");
        Cliente c4 = new Cliente(2,"Joaquín Pastor López", "23.367.977L");
        Cliente c5 = new Cliente(1,"Paco Herrera Herrero", "18.258.456A");
        Cliente c6 = new Cliente(13,"Francisco Buendía Lacalle", "46.151.157E");
        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(c1,c2,c3,c4,c5,c6));
        Cliente c7 = new Cliente(111,"Marta Armagro Amarillo", "20.176.171P");
        Cliente c8 = new Cliente(115,"Jorge Armagro Amarillo", "21.176.171P");
        Cliente c9 = new Cliente(112,"Carlos Armagro Amarillo", "18.176.171P");
        Cliente c10 = new Cliente(211,"Ana Armagro Amarillo", "19.176.171P");

        clientes.add(c7);
        clientes.add(c8);
        clientes.add(c9);
        clientes.add(c10);
        System.out.println("----- SIN ORDENAR -----------------------------------");
        clientes.stream().forEach(System.out::println);
        Comparator<Cliente> comp = new ComparaNombres();
        Collections.sort(clientes, comp);
        System.out.println("------ ORDENADO POR NOMBRE ----------------------------------");
        clientes.stream().forEach(System.out::println);
        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getId()-o2.getId();
            }
        });
        System.out.println("------- ORDENADO POR ID ---------------------------------");
        clientes.stream().forEach(System.out::println);

        Collections.sort(clientes, (a,b) -> a.getNif().compareTo(b.getNif()));
        System.out.println("------- ORDENADO POR NIF ---------------------------------");
        clientes.stream().forEach(System.out::println);

        // crear Stream a partir de una Collection
        Stream<Cliente> clienteStream = clientes.stream();
        // crear Stream a partir de una tabla .of()
        Stream<Cliente> clienteStream1 = Stream.of(new Cliente[4]);
        // crear Stream a partir de una tabla con la clase Arrays
        Stream<Cliente> clienteStream2 = Arrays.stream(new Cliente[3]);
        // crear Stream inicializando el stream con .of()
        Stream<Cliente> clienteStream3 = Stream.of(c1,c2,c3,c4);

        List<String> stringList = new ArrayList<>();
        stringList.add("huevo");
        stringList.add("pulpo");
        stringList.add("pimiento");
        stringList.add("café");
        stringList.add("leche");
        stringList.add("jamón");
        stringList.add("agua");
        stringList.add("salmón");
        stringList.add("pipas");
        stringList.add("asado");
        stringList.add("anacardo");

        Stream<String> stringStream = stringList.stream();

        // filter
        Predicate<String> empiezaPora = s -> s.startsWith("a");
        Stream<String> streama = stringStream.filter(empiezaPora);
        stringList.stream().filter(s -> s.startsWith("a"))
                                .forEach(System.out::println);



        Stream<Cliente> clienteStream4 = clientes.stream();
        clienteStream4.forEach(System.out::println);
        // sorted
        System.out.println("------- POR ID ----------");
        clientes.stream().sorted().forEach(System.out::println);
        System.out.println("--------- POR NIF --------");
        clientes.stream().sorted((x,y) -> x.getNif().compareTo(y.getNif()))
                                    .forEach(System.out::println);
        // map
        System.out.println("--------- SÓLO NIF --------");
        Cliente [] cl = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10};
        Arrays.stream(cl).map(Cliente::getNif).forEach(System.out::println);

        // long count
        System.out.println("--------- cuántos terminados en P --------");
        long dniPs =  Arrays.stream(cl).map(Cliente::getNif)
                                        .filter(dni -> dni.contains("P"))
                                        .count();
        System.out.println(dniPs);

        // distinct
        Stream<Integer> streamEnteros = Stream.of(4,3,7,1,0,8,9,3,5
                                                    ,4,2,1,4,6,8,1,0,2,3);

        System.out.println("--------- lista enteros --------");
        streamEnteros.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("--------- lista enteros con distinct() --------");
        Stream<Integer> streamEnteros1 = Stream.of(4,3,7,1,0,8,9,3,5
                ,4,2,1,4,6,8,1,0,2,3);
        streamEnteros1.distinct().forEach(x -> System.out.print(x + " "));

        System.out.println();
        System.out.println("--------- lista enteros con distinct() y concat --------");
        // concat
        Stream<Integer> streamEnteros3 = Stream.of(5,4,3,7,1,0,8);
        Stream<Integer> streamEnteros4 = Stream.of(4,2,1,4,6,8,1,0,2,3);
        Stream.concat(streamEnteros3, streamEnteros4)
                .distinct()
                .forEach(x -> System.out.print(x + " "));

        // tabla Object[] toArray()
         System.out.println();
         System.out.println("--------- Object y copyOf --------");
        Object[] tObject = Stream.of(-4,-2,-1,-4,6,8,1,0,2,-3)
                .distinct()
                .filter(x -> x % 2 == 0)
                .toArray();

        Integer [] tInt = Arrays.copyOf(tObject,tObject.length, Integer[].class);
        Arrays.stream(tInt).forEach(x -> System.out.print(x + " "));

        // collect , Collectors, toList
        System.out.println();
        System.out.println("--------- toList, toSet --------");
        List<Integer> listaImpares = Stream.of(4,2,4,6,8,10,11,12,13,14,15,16)
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());
        Set<Integer> conjuntoImpares = Stream.of(4,2,4,6,8,10,11,12,13,14,15,16)
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toSet());
        System.out.print(conjuntoImpares);
        System.out.println();
        System.out.println("--------- toCollection(TreeSet::new) --------");
        Set<Integer> conjuntoImpares2 = Stream.of(20,21,22,23,4,2,6,3,4,5,3,6,7,8,9,10,1,3)
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(conjuntoImpares2);
        conjuntoImpares2.add(-8);
        conjuntoImpares2.add(-37);
        conjuntoImpares2.add(11);
        System.out.println(conjuntoImpares2);

        // maps
        System.out.println();
        System.out.println("--------- toMap --------");
        Map<String, String> mapaClientes = Stream.of(c1,c2,c3,c4,c5,c6)
                .collect(Collectors.toMap(x -> x.getNombre(), x -> x.getNif()));
        System.out.println(mapaClientes);

        // average
        System.out.println();
        System.out.println("--------- collectors.averaging --------");
        double idMedio = Stream.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10)
                .collect(Collectors.averagingDouble(x -> x.getId()));
        System.out.println(idMedio);

        // IntSummaryStatistics
        System.out.println();
        System.out.println("--------- collectors.IntSummaryStatistics --------");
        Stream cli = Stream.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
        IntSummaryStatistics estadistica = (IntSummaryStatistics) cli.collect(Collectors.summarizingInt(Cliente::getId));
        System.out.println(estadistica);
    }
}
