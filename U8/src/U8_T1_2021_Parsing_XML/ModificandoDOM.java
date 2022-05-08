package U8_T1_2021_Parsing_XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModificandoDOM {
    public static void main(String[] args) {

        try {

            //Obtenemos la referencia al objeto Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Parseamos el documento XML para tenerlo en memoria cargado
            Document doc = db.parse(new File("C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8\\src\\U8_T1_2021_Parsing_XML\\platos.xml"));

            //Obtenemos el nodo raíz
            Node root = doc.getDocumentElement();

            //Nodo texto de salto de línea que voy a utilizar posteriormente
            Text saltoLinea = doc.createTextNode("\n");



            // Creo la etiqueta padre food, le doy nombre
            Element food = doc.createElement("food");

            //Creo la etiqueta hija nombre y le doy valor
            Element name = doc.createElement("name");
            name.setTextContent("Paella");

            //Creo la etiqueta hija precio y le doy valor
            Element price = doc.createElement("price");
            price.setTextContent("18.50");

            //Creo la etiqueta hija descripción y le doy valor
            Element description = doc.createElement("description");
            description.setTextContent("Conejo, Pimiento Rojo, Alubia Garrafón, Judías verdes, Azafrán, Romero, Arroz, Aceite");

            //Construyo toda la estructura general de la etiqueta
            food.appendChild(saltoLinea);
            food.appendChild(name);
            food.appendChild(price);
            food.appendChild(description);


            //Añadimos ese nuevo nodo al root
            root.appendChild(food);


            // Crear la etiqueta healthy - true
            Element healthy = doc.createElement("healthy");
            healthy.setTextContent("true");
            // Insertar la etiqueta healthy - true en los platos (food)
            NodeList platos = doc.getElementsByTagName("food");
            for (int i = 0; i < platos.getLength(); i++) {
                Node plato = platos.item(i);
                Element elem = (Element) plato;
                elem.appendChild(healthy);
            }



            // PROCEDEMOS A VOLCAR TODAS LAS MODIFICACIONES, TODO ÉL ARBOL AL FICHERO

            //Obtenemos el objeto transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            //Configuración del transformer
            //Podéis ver toda la lista de propiedes aquí
            // https://docs.oracle.com/javase/7/docs/api/javax/xml/transform/OutputKeys.html
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            //Creación del origen DOMSource
            DOMSource origenDOM = new DOMSource(root);

            //Creación del fichero que va a ser mi destino
            File nuevoFood = new File("C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8\\src\\U8_T1_2021_Parsing_XML\\ejercicio2.xml");
            StreamResult destino = new StreamResult(nuevoFood);

            //Hacemos la transformación que en nuestro caso es la escritura
            transformer.transform(origenDOM,destino);

        } catch (ParserConfigurationException | IOException | SAXException
                | TransformerException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
