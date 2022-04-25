package Entregable1XMLSAXDOM;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RecorridoSAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser SaxParser = spf.newSAXParser();
        FeriaSAX f = new FeriaSAX();
        DefaultHandler feriaSAX = f;
        SaxParser.parse(new File("/home/ipastorl/IdeaProjects/daw2021/U8Ejercicios/src/Entregable1XMLSAXDOM/feriaXML.xml"), feriaSAX);
        ArrayList<Feria> casetas = f.getCasetas();
        System.out.println(casetas);
    }
}
