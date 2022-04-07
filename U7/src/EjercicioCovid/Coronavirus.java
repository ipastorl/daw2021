package EjercicioCovid;


import java.io.*;
import java.util.*;

public class  Coronavirus  {
    private Map<Cepa, Set<Paciente>> mapaContagiados;
    private static final String VIRUS = "SARS-COV2";
    private static final String ORIGEN = "WUHAN";
    private static final String FICHERO = "pacientes.dat";

    public Coronavirus() {
        this.mapaContagiados = new TreeMap<>();
    }

    //    Un método addPaciente() que recibe como parámetros la cepa y un posible infectado (paciente)
//    y que añadirá a la estructura de datos el paciente con la cepa determinada
//    o mostrará un mensaje de error en caso de que estemos intentando introducir
//    en el conjunto de pacientes infectados por una cepa concreta un paciente que no se haya infectado de esa cepa.
//
    public void addPaciente (Cepa cepa, Paciente paciente) {
        if (paciente.getCepa().equals(cepa)) { // si el paciente está infectado por esta cepa
            if (mapaContagiados.get(cepa) == null) { // si la cepa no está aún en el mapa creada
                mapaContagiados.put(cepa, new HashSet<Paciente>());
                mapaContagiados.get(cepa).add(paciente);
            }
            mapaContagiados.get(cepa).add(paciente);
        } else {
            System.out.println("El paciente " + paciente.toString() + " está contagiado por la cepa " + cepa.toString());
        }
    }

    public boolean encontrarPaciente (Paciente paciente) {
        boolean pacienteContagiado = false;
        Iterator<Map.Entry<Cepa,Set<Paciente>>> it = mapaContagiados.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Cepa, Set<Paciente>> nextCepa =  it.next();
            if (nextCepa.getValue().contains(paciente)) {
                // ha encontrado el paciente en otra cepa
                pacienteContagiado = true;
            }
        }
        return pacienteContagiado;
    }

//    El método darDeAltaPaciente() que recibe como parámetro un paciente y lo da de alta,
//    borrándolo de la estructura de datos que contienen los datos de los infectados.
//    En caso de que el paciente no se encuentre, deberá mostrar el siguiente mensaje "No se ha encontrado el paciente".
//
    public void darDeAltaPaciente(Paciente paciente) {
        if (encontrarPaciente(paciente)) {
            Iterator<Map.Entry<Cepa,Set<Paciente>>> it = mapaContagiados.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Cepa, Set<Paciente>> nextCepa =  it.next();
                nextCepa.getValue().remove(paciente);
            }
        } else {
            System.out.println("No se ha encontrado el paciente");
        }
    }
//    El método pacientesDeUnDoctor() que mostrará por pantalla todos los pacientes
//    (sean de la cepa que sean) de un médico/a determinado. Este método recibe como parámetro
//    el número de colegiado y mostrará el mensaje "Este médico/a no lleva ningún paciente"
//    en caso de que el médico/a no tenga ningún paciente de esta epidemia.
    public void pacidentesDeUnDoctor(Medico medico){
        boolean medicoSinPacientesContagiados = true;
        Iterator<Map.Entry<Cepa,Set<Paciente>>> itMapa = mapaContagiados.entrySet().iterator();
        while (itMapa.hasNext()) {
            Map.Entry<Cepa, Set<Paciente>> nextCepa =  itMapa.next();
            Set<Paciente> pacientes = nextCepa.getValue();
            Iterator<Paciente> itPacientes = pacientes.iterator();
            while (itPacientes.hasNext()) {
                Paciente nextPaciente =  itPacientes.next();
                if (nextPaciente.getDoctor().equals(medico)){
                    medicoSinPacientesContagiados = false;
                    System.out.println(nextPaciente.toString());
                }
            }
        }
        if (medicoSinPacientesContagiados) {
            System.out.println("Este médico/a no lleva ningún paciente");
        }
    }

//    El método pacientesporPeso() que mostrará la lista de pacientes de una cepa, que se recibe como parámetro,
//    ordenados por peso de manera decreciente.

    public void pacientesporPeso(Cepa cepa) {
        if (cepa == null ) {
            mapaContagiados.put(cepa, new HashSet<Paciente>());

        }
        try {
            TreeSet<Paciente> pacientes = new TreeSet<>();
            pacientes.addAll(mapaContagiados.get(cepa));
            System.out.println(pacientes.toString());
        } catch (NullPointerException nullPointerException) {
            System.out.println("la cepa " + cepa.toString() + " no ha sido insertada aún.");
        }

    }
//
//    El método pacientesporEdad() que mostrará la lista de pacientes de una cepa, que se recibe como parámetro,
//    ordenados por edad de manera decreciente
    public void pacientesporEdad (Cepa cepa) {
        if (cepa == null ) {
            mapaContagiados.put(cepa, new HashSet<Paciente>());
        }
        try {
            TreeSet<Paciente> pacientes = new TreeSet<>(new Comparator<Paciente>() {
                @Override
                public int compare(Paciente o1, Paciente o2) {
                    return o1.getEdad()-o2.getEdad();
                }
            });
            pacientes.addAll(mapaContagiados.get(cepa));
            System.out.println(pacientes.toString());
        } catch (NullPointerException nullPointerException) {
            System.out.println("la cepa " + cepa.toString() + " no ha sido insertada aún.");
        }
    }

//    cargarPacientes() que leerá todos los pacientes desde el fichero binario "pacientes.dat"
//    y los colocará en la estructura de datos.
//
    public void cargarPacientes() {
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream(FICHERO))){
            mapaContagiados = (Map<Cepa, Set<Paciente>>) in.readObject();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

//    guardarPacientes() que escribirá todos los pacientes en el fichero "pacientes.dat".

    public void guardarPacientes() {
        try (ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(FICHERO))){
            out.writeObject(mapaContagiados);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public Map<Cepa, Set<Paciente>> getMapaContagiados() {
        return mapaContagiados;
    }

    public void setMapaContagiados(Map<Cepa, Set<Paciente>> mapaContagiados) {
        this.mapaContagiados = mapaContagiados;
    }
}
