package EntregDOMguardadoFichero;

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

public class ModificarDOM {

    // Carga el contenido del XML en la estructura DOM
    private final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    private final DocumentBuilder db = dbf.newDocumentBuilder();
    private final Document doc = db.parse(new File("C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8Ejercicios\\src\\EntregDOMguardadoFichero\\personasXML.xml"));
    private final Node nodoRaiz = doc.getDocumentElement();
    private final NodeList nodeList = nodoRaiz.getChildNodes();

    public ModificarDOM() throws ParserConfigurationException, SAXException, IOException, TransformerException {
        addComentario();
        transformarDOMaXML();
    }

    public ModificarDOM(Persona p) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        addComentario();
        addPersona(p);
        reemplazar();
        transformarDOMaXML();
    }

    public boolean esElemento (Node nodo){
        return nodo.getNodeType()==1;
    }

    //  Crear un nuevo nodo etiqueta (en el ejemplo una nueva persona)
    //  y reemplazar la primera etiqueta hija por ese nodo creado.
    private void reemplazar(){
        // elemento a reemplazar
        Element p = (Element) listaNodos("persona").item(0);
        Element p1 = (Element) listaNodos("persona").item(listaNodos("persona").getLength()-1);
        nodoRaiz.replaceChild(p1,p);
    }

    // Buscar una lista de nodos por nombre de etiqueta
    private NodeList listaNodos ( String nombreEtiqueta){
        return doc.getElementsByTagName(nombreEtiqueta);
    }

    // Añadir un nueva etiqueta hija (en el ejemplo una nueva persona) como último hijo.
    public void addPersona(Persona persona){
        Element elementoPersona = doc.createElement("persona");
        elementoPersona.setAttribute("id",persona.getId());
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent(persona.getNombre());
        Element edad = doc.createElement("edad");
        edad.setTextContent(persona.getEdad());
        elementoPersona.appendChild(nombre);
        elementoPersona.appendChild(edad);
        nodoRaiz.appendChild(elementoPersona);
    }

    // Añadir antes de cada nodo hijo de tipo etiqueta
    // (en el ejemplo los nodos hijos eran <persona> el siguiente comentario
    // <!-- COMENTARIO AÑADIDO DESDE DOM -->
    public void addComentario(){
        Comment comentario = doc.createComment("COMENTARIO AÑADIDO DESDE DOM");
        Element elementoPrimeraPersona = (Element) listaNodos("persona").item(0);
        nodoRaiz.insertBefore(comentario,elementoPrimeraPersona);
    }

    // Volcar todo a un fichero XML llamado dom_modificado.xml
    public void transformarDOMaXML() throws TransformerException {
        //Configuración del transformer
        TransformerFactory transFry = TransformerFactory.newInstance();
        Transformer trans = transFry.newTransformer();
        trans.setOutputProperty( OutputKeys.INDENT, "yes" );
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        trans.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
        trans.setOutputProperty( OutputKeys.METHOD, "xml" );
        trans.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

        //Creación del origen DOMSource
        DOMSource origenDOM = new DOMSource(nodoRaiz);
        File nuevoXML = new File("C:\\Users\\issa2\\OneDrive\\Documentos\\DAW\\PROGRAMACION\\daw2021\\U8Ejercicios\\src\\EntregDOMguardadoFichero\\personasXML_nuevo.xml");
        StreamResult destino = new StreamResult(nuevoXML);
        //Hacemos la transformación que en nuestro caso es la escritura
        trans.transform(origenDOM,destino);
    }
}
