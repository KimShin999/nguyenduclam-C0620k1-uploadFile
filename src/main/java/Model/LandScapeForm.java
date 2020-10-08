package Model;

import org.springframework.web.multipart.MultipartFile;

public class LandScapeForm {
    private Long id;
    private String name;
    private String country;
    private MultipartFile image;

    public LandScapeForm(){

    }

    public LandScapeForm(String name, String country, MultipartFile image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }

    public LandScapeForm( Long id, String name, String country, MultipartFile image) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
