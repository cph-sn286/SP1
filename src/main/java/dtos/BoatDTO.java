package dtos;

import entities.Boat;
import entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class BoatDTO {
    private long id;
    private String brand;
    private String make;
    private String name;
    private String image;


    public BoatDTO(Boat rm) {

    }

    public static List<BoatDTO> getDtos(List<Boat> rms) {
        List<BoatDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new BoatDTO(rm)));
        return rmdtos;
    }

}
