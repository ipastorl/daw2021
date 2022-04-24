package LAMBDAS;

import java.util.Objects;

public class Producto {

    private static Integer id = 0;
    private Integer idProducto;
    private String name;
    private Double price;

    public Producto(String name, Double price) {
        setId();
        this.idProducto = getId();
        this.name = name;
        this.price = price;
    }

    public static Integer getId() {
        return id;
    }

    private static void setId() {
        Producto.id++;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "idProducto = " + idProducto +
                ", name = '" + name + '\'' +
                ", price = " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return getIdProducto().equals(producto.getIdProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProducto());
    }
}