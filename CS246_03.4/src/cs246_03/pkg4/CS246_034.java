/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs246_03.pkg4;

import java.io.IOException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Brad, Brandon
 */
public class CS246_034 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        
        CS246_034 main = new CS246_034();
        main.loadFile("conference.xml");
        
    }
    
    /**
     * 
     * @param filename
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    private void loadFile(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document doc = builder.parse("conference.xml");
        
        NodeList sessions = doc.getElementsByTagName("speaker");
        
        for (int i = 0; i < sessions.getLength(); i++) {
            Element speaker = (Element) sessions.item(i);
            String speakerName = speaker.getAttribute("name");
            System.out.println(speakerName);
            
        }
    }
    
}
