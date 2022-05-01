package Entregable_1920_Uso_de_StaX;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MostrarSax {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        // Recorrer el fichero XML con Stax
        //Mostrar por pantalla el contenido del fichero XML
        ArrayList<Coche> cars = new ArrayList<>();
        Coche car = null;
        String tag = "";

        // lector
        XMLInputFactory in = XMLInputFactory.newInstance();
        XMLEventReader lector = in.createXMLEventReader(new FileInputStream(
                "C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8Ejercicios\\src\\Entregable_1920_Uso_de_StaX\\migaraje.xml"));

        // leer eventos
        while (lector.hasNext()) {

            // próximo evento
            XMLEvent evento = lector.nextEvent();

            // si es apertura de etiqueta
            if (evento.isStartElement()) {
                StartElement inicioEtiqueta = evento.asStartElement();
                /** print **/
                System.out.print("<"+inicioEtiqueta.getName().getLocalPart());

                String etiqueta = inicioEtiqueta.getName().getLocalPart();
                switch (etiqueta) {
                    case "coche":
                        car = new Coche();
                        tag = "coche";
                        //Si tuviera varios atributos
                        //Iterator it = startTag.getAttributes();
                        Attribute id = inicioEtiqueta.getAttributeByName(new QName("id"));

                        car.setId(Integer.valueOf(id.getValue()));
                        /** print **/
                        System.out.print(" "+id.getName()+"=\""+id.getValue()+"\"");
                        break;
                    case "marca":
                        tag = "marca";
                        break;
                    case "modelo":
                        tag = "modelo";
                        break;
                    case "anyo":
                        tag = "anyo";
                        break;
                    case "color":
                        tag = "color";
                        break;
                }
                System.out.println(">");
            } else if ( evento.isEndElement()){
                EndElement endTag = evento.asEndElement();
                /** print **/
                System.out.println("<\\" + endTag.getName().getLocalPart()+">");

                // si estoy cerrando una etiqueta coche, lo añado al array
                if(endTag.getName().getLocalPart().equals("coche")){
                    cars.add(car);
                }
                // borro etiqueta
                tag = "";
            } else if (evento.isStartDocument()){
                /** print **/
                System.out.println("Inicio del parseado del documento xml");
            } else if (evento.isEndDocument()) {
                /** print **/
                System.out.println("Fin del parseado del documento xml");
            } else if (evento.isCharacters()) {
                Characters txt = evento.asCharacters();

                if (txt.getData().contains("\n")){
                    /** print **/
                    System.out.println(txt.getData());
                }

                if (!tag.equals("")) {
                    switch (tag) {
                        case "marca" :
                            car.setMarca(txt.getData());
                            break;
                        case "modelo" :
                            car.setModelo(txt.getData());
                            break;
                        case "anyo" :
                            car.setAnyo(txt.getData());
                            break;
                        case "color" :
                            car.setColor(txt.getData());
                            break;
                    }
                }
            }
        }
        System.out.println(cars);
    }
}
