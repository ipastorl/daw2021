package Entregable_1920_Uso_de_StaX;

import java.util.Objects;

public class Coche {
    private String marca, modelo, anyo, color;
    static Integer contador = 1;
    private Integer id;

    public Coche(String marca, String modelo, String anyo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
        this.color = color;
        setId(getContador());
        contador++;
    }
    public Coche(){
        setId(getContador());
        contador++;
    }

    private static Integer getContador() {
        return contador;
    }

    private static void setContador(Integer contador) {
        Coche.contador = contador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  "marca='" + marca + '\'' +
                ", modelo='" + modelo + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coche)) return false;
        Coche coche = (Coche) o;
        return Objects.equals(getMarca(), coche.getMarca()) && Objects.equals(getModelo(), coche.getModelo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMarca(), getModelo());
    }
}
