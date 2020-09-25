package com.mrfij.generate;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;


public class Data
{
    public static String secondName()         //Метод возвращающий случайную фамилию из массива
    {
        String[] surname = {"Иванов", "Петоров", "Сидоров", "Котов", "Мохнаткин", "Подопри - Гора", "Свинотов", "Царь",
                "Свинотов"};
        int randomSurname = new Random().nextInt(surname.length); //случаный элемент массива инициализированный в int переменную
        String secondName = surname[randomSurname];               // масив со случайным элеменотом приобарзоввнный в строку
        return secondName;
    }

    public static String firstName()
    {
        String[] firstname = {"Олег", "Игорь", "Варфоломей", "Леха", "Санчес", "Богдан", "Прокол", "Володя", "Борис"};
        int randomFirstname = new Random().nextInt(firstname.length);
        String firstName = firstname[randomFirstname];
        return firstName;
    }

    public static  String birthday()   // метод
    {

        Random random = new Random();
        Calendar calendar = new GregorianCalendar();


        int day2 = random.nextInt(31);   int day1 = calendar.get(Calendar.DAY_OF_MONTH);   int day3 = day1 - day2;
        int month2 = random.nextInt(12); int month1 = calendar.get(Calendar.MONTH);        int month3 = month1 - month2;
        int year2 = random.nextInt(100); int year1 = calendar.get(Calendar.YEAR);          int year3 = year1 - year2;


        if ((day3 > 0) && (month3 > 0) && (year3 > 0))
        {
            String strDay = Integer.toString(day3);
            String strMonth = Integer.toString(month3);
            String strYear = Integer.toString(year3);


            String strBirthDay = strDay + "." + strMonth + "." + strYear;

            return strBirthDay;
        }
        else
        {
            return birthday();
        }

    }

}
