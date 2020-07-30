package RandomTask;



import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class MainRandomTask
{
    public static void main(String[] args)
            throws ParserConfigurationException, TransformerException, FileNotFoundException
    {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("person");
        Element firstName = document.createElement("firstName");
        Element secondName = document.createElement("secondName");
        Element birthDay = document.createElement("birthDay");

        document.appendChild(root);             //добавить в xml докумет, корневой тег
        root.appendChild(firstName);            // добавить в корневой тег, дочерниие теги
        root.appendChild(secondName);
        root.appendChild(birthDay);

        firstName.setTextContent(Data.firstName());
        secondName.setTextContent(Data.secondName());
        birthDay.setTextContent(Data.birthday());


        Transformer t = TransformerFactory.newDefaultInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("persons.xml")));

    }
}