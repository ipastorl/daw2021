package Entregable1XMLSAXDOM;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class FeriaSAX extends DefaultHandler {
    private final ArrayList<Feria> casetas = new ArrayList<>();
    private Feria feria_actual;
    private String contenido_nodo = "";


    public FeriaSAX () {
        super();
    }

    public ArrayList<Feria> getCasetas(){
        return casetas;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("caseta")) {
            feria_actual = new Feria();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("caseta")) {
            casetas.add(feria_actual);
        } else if (qName.equals("nombreCaseta")) {
            feria_actual.setNombreCaseta(contenido_nodo);
        } else if (qName.equals("aforo")){
            feria_actual.setAforo(Integer.parseInt(contenido_nodo));
        } else if (qName.equals("m2")){
            feria_actual.setM2(Integer.parseInt(contenido_nodo));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        contenido_nodo =  new String(ch,start,length);
    }
}
