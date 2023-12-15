/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketplaceSayur;

/**
 *
 * @author ryanf
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class AccessXML {
    public static void readXML(){
        try {
            File inputFile = new File("src\\MarketplaceSayur\\Data_gudang.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("sayur");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getElementsByTagName("productID").item(0).getTextContent();
                    String nama = element.getElementsByTagName("nama").item(0).getTextContent();
                    int harga = Integer.parseInt(element.getElementsByTagName("harga").item(0).getTextContent());
                    int qty = Integer.parseInt(element.getElementsByTagName("jumlah_stok").item(0).getTextContent());
                    gudang.barangBaru(id, nama, harga, qty);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
