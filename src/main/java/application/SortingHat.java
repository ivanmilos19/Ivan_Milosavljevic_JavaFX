package application;

import lombok.Data;
import java.util.Arrays;
@Data
public class SortingHat {

    private House house;


    public SortingHat() {

        String houseName = null;
        if (houseName == "Gryffindor")
            house = new Gryffindor();
        else if (houseName == "Ravenclaw") {
            house = new Ravenclaw();
        } else if (houseName == "Hufflepuff") {
            house = new Hufflepuff();
        } else if (houseName == "Slytherin") {
            house = new Slytherin();
        }
    }
}
