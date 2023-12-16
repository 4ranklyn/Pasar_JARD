/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

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
            File inputFile = new File("src\\main\\Data_gudang.xml");
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
    
    public static void writeXML(){
        try {
            // Create a new DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create root element
            Element rootElement = doc.createElement("barang"); // Replace 'root' with your root element
            doc.appendChild(rootElement);

            // Create and append multiple child elements to the root element
            for(String id : gudang.rak.keySet()){
                barang Barang = gudang.rak.get(id);
                
                Element node = doc.createElement("sayur");
                rootElement.appendChild(node);
                
                Element child_id = doc.createElement("productID");
                child_id.setTextContent(id);
                node.appendChild(child_id);
                
                Element child_nama = doc.createElement("nama");
                child_nama.setTextContent(Barang.getName());
                node.appendChild(child_nama);
                
                Element child_jumlahstok = doc.createElement("jumlah_stok");
                child_jumlahstok.setTextContent(Integer.toString(Barang.getQty()));
                node.appendChild(child_jumlahstok);
                
                Element child_harga = doc.createElement("harga");
                child_harga.setTextContent(Integer.toString(Barang.getPrice()));
                node.appendChild(child_harga);
            }

            // Write the new XML content to the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src\\main\\Data_gudang.xml")); // Replace 'output.xml' with your output file path
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}