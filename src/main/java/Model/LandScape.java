package Model;

public class LandScape {
    private Long id;
    private String name;
    private String country;
    private String image;

    public LandScape(){

    }

    public LandScape(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public LandScape(String name, String country, String image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }

    public LandScape(Long id, String name, String country, String image) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
