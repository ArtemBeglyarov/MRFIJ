package Task3;


public interface Space extends Comparable<Space> {

    double getArea();

    void setArea(double area);

    int getRoom();

    void setRoom(int room);

    int getClassID();

    Object clone();

    int compareTo (Space o);
}
