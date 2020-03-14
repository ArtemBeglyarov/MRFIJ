package random;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] array = a.toCharArray();
        int [] number = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == 'I')
            {
                number[i] = 1;
            }
            if (array[i] == 'V')
            {
                number[i] = 5;
            }
            if (array[i] == 'X')
            {
                number[i] = 10;
            }
            if (array[i] == 'L')
            {
                number[i] = 50;
            }
            if (array[i] == 'D')
            {
                number[i] = 100;
            }
            if (array[i] == 'M')
            {
                number[i] = 1000;
            }
            System.out.println(number[i]);
        }


    }
}