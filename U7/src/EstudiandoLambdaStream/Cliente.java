package EstudiandoLambdaStream;

import java.util.Objects;

public class Cliente implements Comparable <Cliente> {
    private Integer id;
    private String nombre, nif;

    public Cliente(Integer id, String nombre, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getNif().equals(cliente.getNif());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNif());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.getId()-o.getId();
    }
}
