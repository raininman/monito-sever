package com.raininman.monito.petItem;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class PetItem {
    @Id
    @SequenceGenerator(
            name = "petitem_sequence",
            sequenceName = "petitem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "petitem_sequence"
    )
    private Long id;
    private String title;
    private String description;

    private String age;

    private String price;
    private String gender;
    private String color;
    private String size;
    private boolean vaccinated;
    private boolean dewormed;
    private boolean cert;
    private boolean microchip;
    private String location;
    private LocalDate publishDate;
    private String additionalInformation;
    private List<String> imgs;

    public PetItem(String title, String description, String age, String price, String gender, String color, String size, boolean vaccinated, boolean dewormed, boolean cert, boolean microchip, String location, LocalDate publishDate, String additionalInformation, List<String> imgs) {
        this.title = title;
        this.description = description;
        this.age = age;
        this.price = price;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.vaccinated = vaccinated;
        this.dewormed = dewormed;
        this.cert = cert;
        this.microchip = microchip;
        this.location = location;
        this.publishDate = publishDate;
        this.additionalInformation = additionalInformation;
        this.imgs = imgs;
    }

    public PetItem(Long id, String title, String description, String age, String price, String gender, String color, String size, boolean vaccinated, boolean dewormed, boolean cert, boolean microchip, String location, LocalDate publishDate, String additionalInformation, List<String> imgs) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.age = age;
        this.price = price;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.vaccinated = vaccinated;
        this.dewormed = dewormed;
        this.cert = cert;
        this.microchip = microchip;
        this.location = location;
        this.publishDate = publishDate;
        this.additionalInformation = additionalInformation;
        this.imgs = imgs;
    }

    public PetItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isDewormed() {
        return dewormed;
    }

    public void setDewormed(boolean dewormed) {
        this.dewormed = dewormed;
    }

    public boolean isCert() {
        return cert;
    }

    public void setCert(boolean cert) {
        this.cert = cert;
    }

    public boolean isMicrochip() {
        return microchip;
    }

    public void setMicrochip(boolean microchip) {
        this.microchip = microchip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "PetItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", vaccinated=" + vaccinated +
                ", dewormed=" + dewormed +
                ", cert=" + cert +
                ", microchip=" + microchip +
                ", location='" + location + '\'' +
                ", publishDate=" + publishDate +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", imgs=" + imgs +
                '}';
    }
}
