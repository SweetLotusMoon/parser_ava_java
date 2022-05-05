import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        parse_stick_id();
        parse_clothes();
        parse_achievements();
    }
    static void parse_stick_id() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("config_all_ru/inventory/stickerPack.xml");
        NodeList nodeList = document.getElementsByTagName("item");
        for(int x=0,size=nodeList.getLength(); x<size; x++) {
            System.out.println(nodeList.item(x).getAttributes().getNamedItem("id").getNodeValue());
        }
    }
    static void parse_clothes() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        String[] genders = {"boy", "girl"};
        for (String L : genders) {
            Document document = documentBuilder.parse("config_all_ru/inventory/" + L + "Clothes.xml");
            NodeList nodeList = document.getElementsByTagName("item");
            for (int x = 0, size = nodeList.getLength(); x < size; x++) {
                System.out.println(nodeList.item(x).getAttributes().getNamedItem("id").getNodeValue());
            }
        }
    }
    static void parse_achievements() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("config_all_ru/modules/achievements.xml");
        NodeList nodeList = document.getElementsByTagName("achievement");
        for(int x=0,size= nodeList.getLength(); x<size; x++) {
            System.out.println(nodeList.item(x).getAttributes().getNamedItem("id").getNodeValue());
        }
    }
    }

