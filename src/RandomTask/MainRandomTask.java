package RandomTask;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


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
            throws ParserConfigurationException, TransformerException, FileNotFoundException,
            UnsupportedEncodingException
    {

        if (args.length % 2 == 0)
        {


            Map<String, String> map = new HashMap<>();

            for (int i = 0; i < args.length; i += 2)
            {

                map.put(args[i], args[i + 1]);

            }


            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element gen = document.createElement("Gen");

            document.appendChild(gen);

            if (map.containsKey("-c"))
            {
                int count = Integer.parseInt(map.get("-c"));

                for (int i = 0; i < count; i++)
                {


                    Element root = document.createElement("person");
                    Element firstName = document.createElement("firstName");
                    Element secondName = document.createElement("secondName");
                    Element birthDay = document.createElement("birthDay");


                    gen.appendChild(root);
                    root.appendChild(firstName);
                    root.appendChild(secondName);
                    root.appendChild(birthDay);

                    firstName.setTextContent(Data.firstName());
                    secondName.setTextContent(Data.secondName());
                    birthDay.setTextContent(Data.birthday());


                }
            }

            if (map.containsKey("-s"))
            {
                String size = (map.get("-s"));

                int sum = 0;

                System.out.println(size.indexOf("kmgb"));

                if (size.endsWith("kb"))
                {

                    int sizeInt = Integer.parseInt(size.substring(0, size.length() - 2)) * 1000;


                    if (sizeInt > 2000000000)
                    {
                        System.out.println("превышен размер файла");
                    }
                    else

                    {
                        for (int i = 0; i < sizeInt; i++)
                        {


                            Element root = document.createElement("person");
                            Element firstName = document.createElement("firstName");
                            Element secondName = document.createElement("secondName");
                            Element birthDay = document.createElement("birthDay");


                            gen.appendChild(root);
                            root.appendChild(firstName);
                            root.appendChild(secondName);
                            root.appendChild(birthDay);


                            firstName.setTextContent(Data.firstName());
                            secondName.setTextContent(Data.secondName());
                            birthDay.setTextContent(Data.birthday());

                            byte[] byteFirstName = Data.firstName().getBytes("UTF-8");
                            byte[] byteSecondName = Data.secondName().getBytes("UTF-8");
                            byte[] byteBirthDay = Data.birthday().getBytes("UTF-8");

                            sum += byteFirstName.length + byteSecondName.length + byteBirthDay.length + 128;

                            if (sizeInt - 71 <= sum)
                            {
                                break;
                            }


                        }
                    }
                }

                if (size.endsWith("mb"))
                {


                    int sizeInt = Integer.parseInt(size.substring(0, size.length() - 2)) * 1000000;//mb

                    if (sizeInt > 2000000000)
                    {
                        System.out.println("превышен размер файла");
                    }

                    for (int i = 0; i < sizeInt; i++)
                    {


                        Element root = document.createElement("person");
                        Element firstName = document.createElement("firstName");
                        Element secondName = document.createElement("secondName");
                        Element birthDay = document.createElement("birthDay");


                        gen.appendChild(root);
                        root.appendChild(firstName);
                        root.appendChild(secondName);
                        root.appendChild(birthDay);


                        firstName.setTextContent(Data.firstName());
                        secondName.setTextContent(Data.secondName());
                        birthDay.setTextContent(Data.birthday());

                        byte[] byteFirstName = Data.firstName().getBytes("UTF-8");
                        byte[] byteSecondName = Data.secondName().getBytes("UTF-8");
                        byte[] byteBirthDay = Data.birthday().getBytes("UTF-8");

                        sum += byteFirstName.length + byteSecondName.length + byteBirthDay.length + 128;


                        if (sizeInt - 71 <= sum)
                        {
                            break;
                        }


                    }

                }

                if (size.endsWith("gb"))
                {


                    int sizeInt = Integer.parseInt(size.substring(0, size.length() - 2)) * 1000000000;//gb

                    if (sizeInt > 2000000000)
                    {
                        System.out.println("превышен размер файла");
                    }
                    else {

                        for (int i = 0; i < sizeInt; i++)
                        {


                            Element root = document.createElement("person");
                            Element firstName = document.createElement("firstName");
                            Element secondName = document.createElement("secondName");
                            Element birthDay = document.createElement("birthDay");


                            gen.appendChild(root);
                            root.appendChild(firstName);
                            root.appendChild(secondName);
                            root.appendChild(birthDay);


                            firstName.setTextContent(Data.firstName());
                            secondName.setTextContent(Data.secondName());
                            birthDay.setTextContent(Data.birthday());

                            byte[] byteFirstName = Data.firstName().getBytes("UTF-8");
                            byte[] byteSecondName = Data.secondName().getBytes("UTF-8");
                            byte[] byteBirthDay = Data.birthday().getBytes("UTF-8");

                            sum += byteFirstName.length + byteSecondName.length + byteBirthDay.length + 128;


                            if (sizeInt - 71 <= sum)
                            {
                                break;
                            }


                        }
                    }

                }
                if (size.indexOf("kmgb")==0)
                {


                    int sizeInt = Integer.parseInt(size);

                    if (sizeInt < 260)
                    {
                        System.out.println("нужно увеличить размер файла");
                    }
                    else
                    {
                        for (int i = 0; i < sizeInt; i++)
                        {


                            Element root = document.createElement("person");
                            Element firstName = document.createElement("firstName");
                            Element secondName = document.createElement("secondName");
                            Element birthDay = document.createElement("birthDay");


                            gen.appendChild(root);
                            root.appendChild(firstName);
                            root.appendChild(secondName);
                            root.appendChild(birthDay);


                            firstName.setTextContent(Data.firstName());
                            secondName.setTextContent(Data.secondName());
                            birthDay.setTextContent(Data.birthday());

                            byte[] byteFirstName = Data.firstName().getBytes("UTF-8");
                            byte[] byteSecondName = Data.secondName().getBytes("UTF-8");
                            byte[] byteBirthDay = Data.birthday().getBytes("UTF-8");

                            sum += byteFirstName.length + byteSecondName.length + byteBirthDay.length + 128;


                            if (sizeInt - 71 <= sum)
                            {
                                break;
                            }
                        }
                    }

                }

            }

            if (map.containsKey("-f") == true)
            {

                Transformer t = TransformerFactory.newDefaultInstance().newTransformer();
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(map.get("-f"))));
            }
            else
            {
                Transformer t = TransformerFactory.newDefaultInstance().newTransformer();
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("output.xml")));
            }
        }


        else
        {
            System.out.println("некорректные аргументы");
        }

    }
}

