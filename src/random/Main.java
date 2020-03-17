package random;

import java.nio.channels.NotYetBoundException;
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
        }
        for (int i = 0; i < number.length; i++)
        {
            if (number[0] == 1)
            {
                if (number.length == 1)
                {
                    System.out.println(number[0]);
                    break;
                }
                if (number.length > 1)
                {
                    if (number.length == 2)
                    {
                        if (number[1] == 5)
                        {
                            System.out.println(number[1] - number[0]);
                            break;
                        }
                        if (number[1] == 10)
                        {
                            System.out.println(number[1] - number[0]);
                            break;
                        }
                        if (number[0] == 1 && number[1] == 1)
                        {
                            System.out.println(number[0] + number[1]);
                            break;
                        }

                    }
                    if (number.length == 3)
                    {
                        if (number[0] == 1 && number[1] == 1 && number[2] == 1)
                        {
                            System.out.println(number[0] + number[1] + number[2]);
                            break;
                        }

                    }
                    else
                    {
                        System.out.println("error");
                        break;
                    }
                }

            }
            if (number[0] == 5)
            {
                if (number.length == 1)
                {
                    System.out.println(number[0]);
                    break;
                }
                if (number.length > 1)
                {
                    if (number.length == 2 && number[1] == 1)
                    {
                        System.out.println(number[0] + number[1]);
                        break;
                    }
                    if (number.length == 3 && number[1]== 1 && number[2] == 1)
                    {
                        System.out.println(number[0]+number[1]+number[2]);
                        break;
                    }
                    if (number.length == 4 && number[1] == 1 && number[2] == 1 && number[3] == 1)
                    {
                        System.out.println(number[0] + number[1] + number[2] + number[3]);
                        break;
                    }
                    else
                    {
                        System.out.println("error");
                        break;
                    }

                }
            }
            if (number[0] == 10)
            {
                if (number.length == 1)
                {
                    System.out.println(number[0]);
                    break;
                }
                if (number.length == 2)
                {
                    if (number[1] == 50)
                    {

                        System.out.println(number[1] - number[0]);
                        break;
                    }
                    else if (number[1] == 100 || number[1] == 1000)
                    {
                        System.out.println("error");
                    }
                    else
                    {
                        System.out.println(number[0] + number[1]);
                    }
                    break;
                }
                if (number.length == 3)
                {

                }

            }

        }


    }
}