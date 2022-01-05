package dtos;

import entities.Owner;
import entities.RenameMe;

import java.util.ArrayList;
import java.util.List;

public class OwnerDTO {
    private long id;
    private String name;
    private String address;
    private String phone;

    public OwnerDTO(Owner rm) {

    }

    public static List<OwnerDTO> getDtos(List<Owner> rms) {
        List<OwnerDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new OwnerDTO(rm)));
        return rmdtos;
    }

}
