package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Boat {
    private long id;
    private static final long serialVersionUID = 1L;
    @Id
    private String brand;
    private String make;
    private String name;
    private String image;

    @ManyToMany(mappedBy = "boatList")
    private List<Owner> ownerList;


    @ManyToOne(cascade = CascadeType.ALL)
    private Harbour harbour;

    public Boat() {
    }

    public Boat(long id, String brand, String make, String name, String image) {
        this.id = id;
        this.brand = brand;
        this.make = make;
        this.name = name;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
