package RandomTask;

import java.time.LocalDate;
import java.util.Random;

public  class Data
{
         public static String secondName()
    {
        String [] surname = {"Иванов","Петоров","Сидоров","Котов","Мохнаткин","Подопри - Гора","Свинотов","Царь","Свинотов"};
        int randomSurname = new Random().nextInt(surname.length);
        String secondName = surname[randomSurname];
        return secondName;
    }
         public static String firstName()
    {
        String [] firstname = {"Олег","Игорь","Варфоломей","Леха","Санчес","Богдан","Прокол","Володя","Борис"};
        int randomFirstname = new Random().nextInt(firstname.length);
        String firstName = firstname[randomFirstname];
        return firstName;
    }
      public static String birthday()
    {
        String [] birhtday = {"21.12.1994","14.04.1956","07.10.2000","30.11.1902","15.02.1989","22.02.2020","11.03.2007","12.09.1785","08.08.1900"};
        int randomBirthday = new Random().nextInt(birhtday.length);
        String birthday = birhtday[randomBirthday];
        return birthday;


    }
        public static String birthday2()
    {
        LocalDate date = LocalDate.now();


    }


}
