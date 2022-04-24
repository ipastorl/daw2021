package LAMBDAS;

public class LambdaEstudio {
    // 1. Consumidores
    //Aceptan un solo valor y no devuelven valor alguno.
    //String message -> System.out.println(message);

    //2. Proveedores
    //No tienen parámetros pero devuelven un resultado.
    //() -> return createRandomInteger();

    //3. Funciones
    //Aceptan un argumento y devuelven un valor como resultado y cuyos tipos no tienen porque ser iguales.
    //Order persistedOrder -> persistedOrder.getIdientifier();

    //3.1 Operadores Unarios
    //Caso especial de funciones en las que tanto el parámetro como el valor devuelto son del mismo tipo.
    //String message -> message.toLowerCase();

    //3.2 Operadores Binarios
    //Caso especial de funciones en las que los dos argumentos y el resultado son del mismo tipo.
    //(String message, String anotherMesssage) -> message.concat(anotherMessage);

    //4. Predicados
    //Aceptan un parámetro y devuelven un valor lógico.
    //String message -> message.length > 50

    //Las referencias a los métodos nos permiten reutilizar un método como expresión lambda. Para hacer uso de las referencias a métodos basta con utilizar la siguiente sintáxis: .
    //referenciaObjetivo::nombreDelMetodo;
    //File::canRead // en lugar de File f -> f.canRead();


    //Con las referencias a los métodos se ofrece una anotación más rápida para expresiones lambda simples y existen 3 tipos diferentes:
    //Métodos estáticos.
    //Métodos de instancia de un tipo.
    //Métodos de instancia de un objeto existente.

    //Ejemplo de uso con método estático:
    //(String info) -> System.out.println(info) // Expresión lambda sin referencias.
    //System.out::println // Expresión lambda con referencia a método estático.

    //Ejemplo de uso con método de un tipo:
    //(Student student, int registryIndex) -> student.getRegistry(registryIndex) // Expresión lambda sin referencias.
    //Student::getRegistry // Expresión lambda con referencia a método de un tipo.

    //Ejemplo de uso con método de un objeto existente:
    //Student student -> getMarks(student) // Expresión lambda sin referencias.
    //this::getMarks // Expresión lambda con referencia a método de un objeto existente.

    //Hay diversas formas de obtener un Stream inicial, es decir, que no proceda de otro Stream.
    // Nosotros vamos a ver cuatro:

    //A partir de una colección: llamando al método stream()
    //Stream<T> nombreStream = nombreColeccion.stream();

    //A partir de una tabla de tipo T[]: llamando al método of()
    //Stream<T> nombreStream = Stream.of(tabla);

    //A partir de un array de tipo T[]: usando el método stream(), de la clase Arrays, con el array como parámetro.
    //Stream<T> nombreStream = Arrays.stream(nombre_array);

    //Inicializándolo directamente: también con el método of(), de Stream,
    // pero pasándolo como lista de parámetros los valores de tipo T, que lo inicializan.
    //Stream<T> nombreStream = Stream.of(val1, val2, ...);
}
