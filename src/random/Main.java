package random;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] array = a.toCharArray();
        int[] number = new int[10];
        for (int i = 0; i <number.length ; i++)
        {
            for (int j = 0; j <array.length ; j++)
            {
                {
                    if (array[j] == 'I')
                    {
                        number[i] = 1;

                    }
                    if (array[j] == 'V')
                    {
                        number[i] = 5;

                    }
                    if (array[j] == 'X')
                    {
                        number[i] = 10;

                    }
                    if (array[j] == 'L')
                    {
                        number[i] = 50;

                    }
                    if (array[j] == 'D')
                    {
                        number[i] = 100;

                    }
                    if (array[j] == 'M')
                    {
                        number[i] = 1000;

                    }
                }
            }

            System.out.println(number[i]);
        }




    }
}


