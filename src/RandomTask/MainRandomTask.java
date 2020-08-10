package RandomTask;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

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
        String b;
        String size = "-s";
        String count = "-c";
        String file = "-f";


        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance(); //создание пустодого документа xml
        DocumentBuilder builder = factory.newDocumentBuilder();                       //
        Document document = builder.newDocument();

        Element gen = document.createElement("Gen");                     // создание корневого тега//

        document.appendChild(gen);             //добавить в xml докумет, корневой тег


        if (args[0] == count)
        {
            int intArgs = Integer.parseInt(args[1]);

            for (int i = 0; i < intArgs; i++)
            {


                Element root = document.createElement("person");                     // создание корневого тега
                Element firstName = document.createElement("firstName");             // содание дочернего тега
                Element secondName = document.createElement("secondName");           //
                Element birthDay = document.createElement("birthDay");               //


                gen.appendChild(root);             //добавить в xml докумет, корневой тег
                root.appendChild(firstName);            // добавить в корневой тег, дочерниие теги
                root.appendChild(secondName);
                root.appendChild(birthDay);

                firstName.setTextContent(Data.firstName());    // это метод устанавливает заначение тега
                secondName.setTextContent(Data.secondName()); //
                birthDay.setTextContent(Data.birthday());//

            }

            if (args[2] == file)
                {
                    b = args[3];

                }
                else
                {
                    b = "output.xml";

                }


            Transformer t = TransformerFactory.newDefaultInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(b)));
        }


        if (args[0] == size)
        {
            for (int i = 0; i < 10; i++)
            {


                Element root = document.createElement("person");                     // создание корневого тега
                Element firstName = document.createElement("firstName");             // содание дочернего тега
                Element secondName = document.createElement("secondName");           //
                Element birthDay = document.createElement("birthDay");               //


                gen.appendChild(root);             //добавить в xml докумет, корневой тег
                root.appendChild(firstName);            // добавить в корневой тег, дочерниие теги
                root.appendChild(secondName);
                root.appendChild(birthDay);

                firstName.setTextContent(Data.firstName());    // это метод устанавливает заначение тега
                secondName.setTextContent(Data.secondName()); //
                birthDay.setTextContent(Data.birthday());//

            }
                if (args[2] == file)
                {
                    b = args[3];

                }
                else
                {
                    b = "output.xml";

                }

            Transformer t = TransformerFactory.newDefaultInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(b)));

        }


    }

}
