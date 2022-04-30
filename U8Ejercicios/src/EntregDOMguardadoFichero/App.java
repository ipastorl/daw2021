package EntregDOMguardadoFichero;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Persona p = new Persona("5","Isabel Pastor", "47");
        ModificarDOM modificarDOM = new ModificarDOM(p);
    }
}
