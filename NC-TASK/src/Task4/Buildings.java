package Task4;
import Task3.Space;
import Task3.Floor;
import Task3.Building;

import java.io.*;

public class Buildings {
    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream data = new DataOutputStream(out);
        data.writeInt(building.getCountFloor());
        for (int i = 0; i <building.getCountFloor() ; i++) {
            data.writeInt(building.getFloorByNum(i).getCountSpaceOnFloor());
            for (int j = 0; j < building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                data.writeInt(building.getFloorByNum(i).getSpaceFloorNum(j).getRoom());
                data.writeDouble(building.getFloorByNum(i).getSpaceFloorNum(j).getArea());
            }

        }

    }
    public static Building inputBuilding (InputStream in) {

    }
    public static void writeBuilding (Building building, Writer out) {

    }
    public static Building readBuilding (Reader in) {

    }
}
