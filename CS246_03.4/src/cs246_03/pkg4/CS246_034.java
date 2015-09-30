package cs246_03.pkg4;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * CS 246 03.4 Team Activity: Parsing XML
 * @author Brad Bodily, Brandon Hartshorn
 */
public class CS246_034 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CS246_034 main = new CS246_034();
        main.parseConferenceFile("conference.xml");   
    }
    
    /**
     * Attempts to parse the specified file and display all speaker names.
     * @param filename  filename to parse
     */
    private void parseConferenceFile(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                
        // Attemp to create new DocumentBuilder
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Attempt to parse file
            try {
                // Parse
                Document doc = builder.parse(filename);
                
                // Get speaker elements
                NodeList sessions = doc.getElementsByTagName("speaker");

                for (int i = 0; i < sessions.getLength(); i++) {
                    Element speaker = (Element) sessions.item(i);
                    String speakerName = speaker.getAttribute("name");
                    System.out.println(speakerName);
                }                 
                
            } catch (SAXException e) {
                System.err.format("SAXException exception. Cannot continue.");
                System.exit(1);
            } catch (IOException e) {
                System.err.format("IOException parsing '%s'. Cannot continue.", filename);
                System.exit(1);                
            }
        } catch (ParserConfigurationException e) {
            System.err.format("Parser configuration error. Cannot continue.\n");
            System.exit(1);
        }
    }   
}
