package Entregable_1920_Uso_de_StaX;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class crearStaxCero {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        // Crear un ArrayList con al menos 10 objetos
        ArrayList<Coche> cars = new ArrayList<>();
        // Dicho objetos deben tener al menos 4 atributos
        // La clase del Objeto deberá crearse en un fichero aparte.
       Coche car0 = new Coche("Audi","TT", "2014","Rojo");
       Coche car1 = new Coche("Cadillac", "Escalade", "2008","Gris");
       Coche car2 = new Coche( "Volswagen", "T Roc", "2021", "Negro");
       Coche car3 = new Coche("Volswagen", "California", "1967", "Blanco, Naranja");
       Coche car4 = new Coche("Volvo", "XC40", "2017", "Negro");
       Coche car5 = new Coche("Aston Martin", "DB9", "2016", "Azul");
       Coche car6 = new Coche("Bentley", "Continental", "2017","Beige");
       Coche car7 = new Coche("Rolls Royce", "wraith", "2019", "Negro");
       Coche car8 = new Coche("Tesla", "Y", "2021","Blanco");
       Coche car9 = new Coche("Hummer", "H2", "2018", "Naranja");
       cars.add(car0);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);

        //Usando Stax volcar el contenido de ese ArrayList al fichero XML stax.xml

        // xmlwriter
        XMLOutputFactory out = XMLOutputFactory.newInstance();
        XMLEventWriter writer = out.createXMLEventWriter(new FileOutputStream(
        "C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8Ejercicios\\src\\Entregable_1920_Uso_de_StaX\\migaraje.xml"));
        // event
        XMLEventFactory event = XMLEventFactory.newInstance();

        // startdoc
        StartDocument start = event.createStartDocument();
        EndDocument end = event.createEndDocument();
        writer.add(start);

        // salto de línea y salto de línea + tabulador
        Characters intro = event.createCharacters("\n");
        Characters introTab = event.createCharacters("\n\t");
        Characters tab = event.createCharacters("\t");
        writer.add(intro);

        // startelement raiz
        StartElement iniMigaraje = event.createStartElement("","","migaraje");
        EndElement endMigaraje = event.createEndElement("", "", "migaraje");
        writer.add(iniMigaraje);
        writer.add(introTab);

        // bucle introducir datos
        Integer contador = 0;
        for (Coche c: cars
             ) {
            // Etiquetas de apertura
            StartElement iniCar = event.createStartElement("", "", "coche");
            StartElement iniMarca = event.createStartElement("", "", "marca");
            StartElement iniModelo = event.createStartElement("", "", "modelo");
            StartElement iniAnyo = event.createStartElement("", "", "año");
            StartElement iniColor = event.createStartElement("", "", "color");

            // Atributo
            Attribute id = event.createAttribute("id",Integer.toString(c.getId()));

            // Etiquetas de cierre
            EndElement endCar = event.createEndElement("", "", "coche");
            EndElement endMarca = event.createEndElement("", "", "marca");
            EndElement endModelo = event.createEndElement("", "", "modelo");
            EndElement endAnyo = event.createEndElement("", "", "año");
            EndElement endColor = event.createEndElement("", "", "color");

            // contenido de las etiquetas (texto)
            Characters marca = event.createCharacters(c.getMarca());
            Characters modelo = event.createCharacters(c.getModelo());
            Characters anyo = event.createCharacters(c.getAnyo());
            Characters color = event.createCharacters(c.getColor());

            // Elemento coche
            writer.add(iniCar);
            // atributo id
            writer.add(id);
            // intos y tabs
            writer.add(introTab);
            writer.add(tab);
            // hijos
                // marca
                writer.add(iniMarca);
                writer.add(marca);
                writer.add(endMarca);
                writer.add(introTab);
                writer.add(tab);
                // modelo
                writer.add(iniModelo);
                writer.add(modelo);
                writer.add(endModelo);
                writer.add(introTab);
                writer.add(tab);
                // año
                writer.add(iniAnyo);
                writer.add(anyo);
                writer.add(endAnyo);
                writer.add(introTab);
                writer.add(tab);
                // color
                writer.add(iniColor);
                writer.add(color);
                writer.add(endColor);
                writer.add(introTab);
            // cierre coche
            writer.add(endCar);

            // formato última entrada
            if (contador == cars.size()-1){
                writer.add(intro);
            } else {
                writer.add(introTab);
            }
            contador++;
        }
        writer.add(endMigaraje);
        writer.add(intro);
        writer.add(end);
    }
}
