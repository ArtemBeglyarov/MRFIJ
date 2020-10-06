package Task3;

public class Office {

    private int area;
    private int room;

    private static final int DEFAULT_AREA = 250;
    private static final int DEFAULT_ROOM =1;


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


    public Office() {
        this.area =DEFAULT_AREA;
        this.room =DEFAULT_ROOM;

    }
    public Office(int area) {
        this.area=area;
        this.room=1;
    }
    public Office(int area,int room) {
        this.room=room;
        this.area=area;
    }
}
