package RandomTask;


import java.util.Date;
import java.util.Random;


public class Data
{
    public static String secondName()
    {
        String[] surname = {"Иванов", "Петоров", "Сидоров", "Котов", "Мохнаткин", "Подопри - Гора", "Свинотов", "Царь",
                "Свинотов"};
        int randomSurname = new Random().nextInt(surname.length);
        String secondName = surname[randomSurname];
        return secondName;
    }

    public static String firstName()
    {
        String[] firstname = {"Олег", "Игорь", "Варфоломей", "Леха", "Санчес", "Богдан", "Прокол", "Володя", "Борис"};
        int randomFirstname = new Random().nextInt(firstname.length);
        String firstName = firstname[randomFirstname];
        return firstName;
    }

    public static String birthday()
    {

        Random random = new Random();
        Date date = new Date();

        int b = random.nextInt(30); int a = date.getDay(); int c = a - b;
        int b2 = random.nextInt(12); int a2 = date.getMonth(); int c2 = a2 - b2;
        int b3 = 1900 + random.nextInt(2020 - 1900); int a3 = date.getYear(); int c3 = a3 - b3;

        if ((c > 0 && c < 31) & (c2 > 0 && c2 < 12) & (c3 > 1900 && c3 < 2020))
        {
            System.out.println(c + "." + c2 + "." + c3 + ".");

        }

        return birthday();


    }


}
