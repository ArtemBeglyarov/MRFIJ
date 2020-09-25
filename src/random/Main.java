package random;


import java.util.Scanner;



public class Main
{
    public static void main(String[] args)
    {
        for (int i = 0; i < args.length ; i++)
        {
            System.out.println(args[i]);
        }
    }
}        /*  Scanner scanner = new Scanner(System.in);
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
            NUMBER(number);
    }
    public static int NUMBER(int[] nubmber)
    {
        int sum = 0;
        for (int valie:nubmber)
        {
            sum = sum + valie;
        }
        for (int i = 0; i < nubmber.length; i++)
        {
            if (nubmber.length == 1)
            {
                System.out.println(nubmber[0]);
            }
            if (nubmber.length > 1)
            {
               if(nubmber[i] == 5)
               {
                   if (nubmber[i - 1] == 1)
                   {
                       sum = sum - 2;
                   }
               }

               if(nubmber[i] == 10)
               {
                   if(nubmber[i-1] == 1)
                   {
                       sum = sum - 2;
                   }
               }
               if(nubmber[i] == 50)
               {
                   if (nubmber[i-1]==10)
                   {
                       sum = sum - 10;
                   }

               } if(nubmber[i] == 100)
               {
                   if (nubmber[i-1]==10)
                   {
                       sum = sum - 10;
                   }

               }
               if(nubmber[i] == 500)
               {
                   if (nubmber[i-1]==100)
                   {
                       sum = sum - 100;
                   }

               }
               if(nubmber[i] == 1000)
               {
                   if (nubmber[i-1]==100)
                   {
                       sum = sum - 100;
                   }

               }

            }
        }
        System.out.println(sum);

        return sum;
    } /*


         */