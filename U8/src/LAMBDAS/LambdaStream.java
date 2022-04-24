package LAMBDAS;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaStream {
    public static void main(String[] args) {
        Persona p1 = new Persona("Corcuera", LocalDate.of(1975, 3, 6));
        Persona p2 = new Persona("Ana María", LocalDate.of(1976,5,21));
        Persona p3 = new Persona("Rosalía", LocalDate.of(1992,4,11));
        Persona p4 = new Persona("José Luis", LocalDate.of(1963,4,15));
        Persona p5 = new Persona("Juan", LocalDate.of(2001,6,29));
        Persona p6 = new Persona("Noa", LocalDate.of(2021,12,13));

        Producto pr1 = new Producto("Cacerola", 15.4);
        Producto pr2 = new Producto("Cuchara", 1.10);
        Producto pr3 = new Producto("Algodón", 0.54);
        Producto pr4 = new Producto("Fregona", 2.21);
        Producto pr5 = new Producto("Armario", 158.94);
        Producto pr6 = new Producto("Vela", 1.10);
        Producto pr7 = new Producto("Cazamoscas", 0.74);
        Producto pr8 = new Producto("Insecticida", 6.16);
        Producto pr9 = new Producto("Ambipur", 5.44);
        Producto pr10 = new Producto("Reja", 28.9);
        Producto pr11 = new Producto("Mesa", 154.90);

        List<Persona> personas = Arrays.asList(p1,p2,p3,p4,p5,p6);
        List<Producto> productos = Arrays.asList(pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9,pr10,pr11);

        // Imprimir con Referencia a métodos
        // personas.forEach(System.out::println);

        // Imprimir Con stream
        personas.stream().forEach(System.out::println);

        // filter
        List<Persona> filteredList = personas.stream().filter(p -> p.getIdPersona() == 4)
                .collect(Collectors.toList());
        // System.out.println(filteredList);
        Stream<Producto> streamA = productos.stream().filter(pr -> pr.getName().startsWith("C"));
        List<Producto> productos1 = streamA.collect(Collectors.toList());
        //System.out.println(productos1);

        // sorted
        Arrays.stream(personas.toArray()).sorted().forEach(System.out::println); // orden natural
        Comparator<Persona> comparatorPersona = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getIdPersona()-o2.getIdPersona();
            }
        };
        personas.stream().sorted((Persona o1, Persona o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);
//        Comparator<Persona> byNameDesc = (Persona o1, Persona o2) -> o2.getName().compareTo(o1.getName());
//        personas.stream().sorted(byNameDesc).forEach(System.out::println);
//        Arrays.stream(personas.toArray()).sorted(new Comparator<Object>() {
//                                                @Override
//                                                public int compare(Object o1, Object o2) {
//                                                    Persona una, dos;
//                                                    una = (Persona) o1;
//                                                    dos = (Persona) o2;
//                                                    return una.getName().compareTo(dos.getName());
//                                                }
//                                            })
//                                        .forEach(System.out::println);
        // map
        // productos.stream().map(name -> name.getName()).forEach(System.out::println);
        productos.stream().map(Producto::getName).forEach(System.out::println);

        // Limit y Skip
        int pageNumber = 1;
        int pageSize = 5;
        List<Producto> listaPaginada = productos.stream()
                .skip(pageNumber * pageSize) // no procesa los (1*5) elementos primeros
                .limit(pageSize) // sólo procesa desde el skip (1*5) hasta (1*5)+limit(5), osea del 6 al 10
                .collect(Collectors.toList());
        listaPaginada.stream().forEach(System.out::println);

        // concat
        Stream<?> stream1 = personas.stream();
        Stream<?> stream2 = productos.stream();
        Stream<?> streamPersonasProductos = Stream.concat(stream1,stream2);
        System.out.println("---------");
        streamPersonasProductos.forEach(System.out::println);

        // toArray
        Producto [] productos2 = productos1.toArray(Producto[]::new);

        // collect
        Map<Integer, Producto> productoMap = productos.stream()
                                                .collect(Collectors
                                                        .toMap(Producto::getIdProducto, producto -> producto));
        System.out.println(productoMap);
        // groupby
        System.out.println("-----------");
        Map<Double, List<Producto>> productosAgrupados = productos.stream().collect(Collectors
                                                                .groupingBy(Producto::getPrice));
        System.out.println(productosAgrupados);
    }



}
