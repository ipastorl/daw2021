package Tarea1;

public class Lavadora extends Electrodomestico{
    private int carga;

    /* ---- CONSTRUCTOR ----- */
    public Lavadora () {
        super();
        this.carga = 5;
    }
    public Lavadora (int precio, int peso) {
        super(precio,peso);
        this.carga = 5;
    }
    public Lavadora (int carga){
        super();
        this.carga = carga;
    }
    /* ----- MÉTODOS ----- */
    @Override
    public int getPrecioFinal() {
        super.getPrecioFinal();
        if(getCarga()>50){
            super.setPrecioBase(super.getPrecioBase()+50);
        }
        return super.getPrecioFinal();
    }



    /* ------ GETTER AND SETTER ---- */

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}
