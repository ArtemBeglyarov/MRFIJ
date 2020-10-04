package Task2.buildings;


public class Flat {

    private static final int AREA_DEFAULT =50;
    private static final int ROOM_DEFAULT = 2;

    private int area;
    private int room;


    @Override
    public String toString()
    {
        return "Flat{" +
                "area=" + area +
                ", room=" + room +
                '}';
    }

    public Flat() {
     this.area = AREA_DEFAULT;
     this.room = ROOM_DEFAULT;
    }

    public Flat(int area) {
        room = 1;
        this.area = area;

    }

   public Flat(int room,int area) {
        this.room = room;
        this.area = area;

    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
