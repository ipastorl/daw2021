package LAMBDAS;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private static Integer id = 0;
    private Integer idPersona;
    private String name;
    private LocalDate birthDate;

    public Persona( String name, LocalDate birthDate) {
        setId();
        this.idPersona = getId();
        this.name = name;
        this.birthDate = birthDate;
    }

    public static Integer getId() {
        return id;
    }

    private static void setId() {
        Persona.id++;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return  "idPersona = " + idPersona +
                ", name = '" + name + '\'' +
                ", birthDate = " + birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return getIdPersona().equals(persona.getIdPersona());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPersona());
    }

    @Override
    public int compareTo(Persona o) {
        return this.getBirthDate().compareTo(o.getBirthDate());
    }
}