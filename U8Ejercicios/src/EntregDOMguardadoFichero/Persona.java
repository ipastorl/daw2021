package EntregDOMguardadoFichero;

public class Persona {
    private String id,nombre,edad;

    public Persona(String id, String nombre, String edad) {
        setId(id);
        setNombre(nombre);
        setEdad(edad);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
