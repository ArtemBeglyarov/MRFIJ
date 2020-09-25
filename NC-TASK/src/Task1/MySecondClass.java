package Task1;

public class MySecondClass {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    public  int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    MySecondClass() {
       this.a=a;
       this.b=b;
    }
    public static int sum(int a,int b) {
        int summa = a + b;
        return summa;
    }
}
