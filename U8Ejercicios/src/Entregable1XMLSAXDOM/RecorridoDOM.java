package Entregable1XMLSAXDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class RecorridoDOM {
    public static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    public static DocumentBuilder db;
    public static NodeList getNodeList(){
        try {
            db = dbf.newDocumentBuilder();
            Document documento = db.parse(new File("C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8Ejercicios\\src\\Entregable1XMLSAXDOM\\feriaXML.xml"));
            Node root = documento.getDocumentElement();
            return root.getChildNodes();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        /**
         * numNodosHijos() que mostrará por pantalla el número de nodos hijos (descendientes directos del nodo raíz)
         * y el tipo de cada uno de esos nodos (etiqueta, texto, comentario).
         */
        numNodosHijos();
        /**
         * mostrarXMLDom() que mostrará por pantalla el contenido del fichero XML llegando únicamente al primer nivel.
         * A partir de ahí puedo mostrar el contenido completo de los nodos.
         */
        mostrarXMLDom();
        /**
         * mostrarContenidoEtiqueta(String s) que recibe como parámetro una nombre de (etiqueta)
         * y recorrerá las ocurrencias de esas etiquetas mostrando el contenido de los mismos.
         * Si no hay ninguna ocurrencia de esa etiqueta deberá mostrar un mensaje de aviso.
         */
        mostrarContenidoEtiqueta("");
    }
    public static Integer numNodosHijos(){
        return Objects.requireNonNull(getNodeList()).getLength();
    }
    public static void mostrarXMLDom(){
        for (int i = 0; i < numNodosHijos(); i++) {
            NodeList nl = getNodeList();
            if (nl != null && nl.item(i).getNodeType() == 1) {
                // Si es de tipo 1 (Elemento), imprime el nombre del nodo
                System.out.print(nl.item(i).getNodeName() + " ");
                if (nl.item(i).hasAttributes()) {
                    // ¿cuántos atributos tiene?, recorrerlos
                    for (int k = 0; k < nl.item(i).getAttributes().getLength(); k++) {
                        System.out.println(nl.item(i).getAttributes().item(k) + " ");
                    }
                }
                if (nl.item(i).getChildNodes().getLength() > 0) {
                    // ¿Tiene hijos?, recorrerlos
                    NodeList nlsub = nl.item(i).getChildNodes();
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
    public static void mostrarContenidoEtiqueta(String nombreEtiqueta){
        boolean coincidencia = false;
        NodeList nl = getNodeList();
        for (int i = 0; i < numNodosHijos(); i++) {
            if (nl != null && nl.item(i).getNodeType() == 1) {
                if (nl.item(i).getNodeName().equals(nombreEtiqueta)) {
                    coincidencia = true;
                    System.out.println(nl.item(i).getNodeName());
                    if (nl.item(i).getChildNodes().getLength() > 0) {
                        NodeList nlsub = nl.item(i).getChildNodes();
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
        if (!coincidencia){
            System.out.println("No se han encontrado coincidencias");
        }
    }
}
