package Task1;

class MyFirstClass {

    public static void main (String [] s) {

        MySecondClass mySecondClass = new MySecondClass();
        int i,j;
        for (i=1; i<=8 ; i++) {
            for (j = 1; j <= 8; j++) {
                mySecondClass.setA(i);
                mySecondClass.setB(j);
                System.out.print(mySecondClass.sum(i,j));
                System.out.print(" ");
            }
            System.out.println();

        }



    }

}
