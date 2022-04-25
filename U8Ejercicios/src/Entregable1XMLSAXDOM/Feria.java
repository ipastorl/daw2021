package Entregable1XMLSAXDOM;

public class Feria {
    private String nombreCaseta;
    private Integer aforo, m2;

    public Feria(String nombreCaseta, Integer aforo, Integer m2) {
        this.nombreCaseta = nombreCaseta;
        this.aforo = aforo;
        this.m2 = m2;
    }

    public Feria(){}

    public String getNombreCaseta() {
        return nombreCaseta;
    }

    public void setNombreCaseta(String nombreCaseta) {
        this.nombreCaseta = nombreCaseta;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    @Override
    public String toString() {
        return "Feria{" +
                "nombreCaseta='" + nombreCaseta + '\'' +
                ", aforo=" + aforo +
                ", m2=" + m2 +
                '}';
    }
}
