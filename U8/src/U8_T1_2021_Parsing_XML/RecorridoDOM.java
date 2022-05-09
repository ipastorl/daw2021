package U8_T1_2021_Parsing_XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class RecorridoDOM {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Cargar fichero XML en memoria
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8\\src\\U8_T1_2021_Parsing_XML\\platos.xml"));
        // Etiquetas food
        NodeList nl = doc.getElementsByTagName("food");

        System.out.println("-----------------------");
        mostrarXML(nl);
        System.out.println("-----------------------");
        cantidadDePlatos(nl);
        System.out.println("-----------------------");
        platoMasCaro(nl);

    }
    public static void mostrarXML(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList != null && nodeList.item(i).getNodeType() == 1) {
                // Si es de tipo 1 (Elemento), imprime el nombre del nodo
                System.out.print(nodeList.item(i).getNodeName() + " ");
                if (nodeList.item(i).hasAttributes()) {
                    // Recorrer atributos, si los hay
                    for (int k = 0; k < nodeList.item(i).getAttributes().getLength(); k++) {
                        System.out.println(nodeList.item(i).getAttributes().item(k) + " ");
                    }
                }
                if (nodeList.item(i).getChildNodes().getLength() > 0) {
                    // Recorrer nodos hijos, si los hay
                    NodeList nlsub = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < nlsub.getLength(); j++) {
                        if (nlsub.item(j).getNodeType() == 1) {
                            System.out.print("  " + nlsub.item(j).getNodeName() + ": ");
                            System.out.println(nlsub.item(j).getTextContent());
                        }
                    }
                }
            }
        }
    }
    public static void cantidadDePlatos(NodeList nodeList){
        System.out.println("Se han encontrado " + nodeList.getLength() + " platos");
    }
    public static void platoMasCaro(NodeList nodeList){
        Double masCaro = 0.0;
        String plato = "";
        Double precioPlatoActual = 0.0;
        System.out.println("El plato más caro es ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);

            //Es un hijo que es etiqueta (element)
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                //Muestro la información del elemento (etiqueta)
                NodeList nodosHijos = nodo.getChildNodes();
                for (int j = 0; j < nodosHijos.getLength(); j++) {
                    Node nodoHijo = nodosHijos.item(j);
                    if (nodoHijo.getNodeType() == Node.ELEMENT_NODE){
                        if (nodoHijo.getNodeName().equals("price")){
                            Element element = (Element) nodoHijo;
                            precioPlatoActual = Double.valueOf(element.getTextContent());
                            if (precioPlatoActual > masCaro) {
                                masCaro = precioPlatoActual;
                                plato = nodosHijos.item(j-2).getTextContent();
                            }
                        }
                    }
                }

            }
        }
        System.out.println(plato + " : " + masCaro);
    }
}