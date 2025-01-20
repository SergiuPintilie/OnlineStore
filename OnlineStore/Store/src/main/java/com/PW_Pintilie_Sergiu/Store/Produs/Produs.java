package com.PW_Pintilie_Sergiu.Store.Produs;

import com.PW_Pintilie_Sergiu.Store.Cos.Cos;
import com.PW_Pintilie_Sergiu.Store.Order.Orders;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Produs {
    @Id
    @SequenceGenerator(
            name = "produs_sequence",
            sequenceName = "produs_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "produs_sequence"
    )
    private int id;
    @Lob
    private String image;
    private String nume;
    private String descriere;
    private double pret;
    @Lob
    @Enumerated
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ProdusCategory category;

    @ManyToMany(mappedBy = "produse")

    private Set<Cos> cosuri = new HashSet<>();

    @ManyToMany(mappedBy = "produse")
    private Set<Orders> orders = new HashSet<>();

    public String loadImageDataFromPath(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        byte[] imageBytes = Files.readAllBytes(path);
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        return base64Image;
    }
    public Produs() {
    }

    public void setCategory(ProdusCategory category) {
        this.category = category;
    }

    public ProdusCategory getCategory() {
        return category;
    }

    public Produs(String category, String imagePath, String nume, String descriere, double pret) throws IOException {
        this.category=ProdusCategory.valueOf(category);
        this.image = loadImageDataFromPath(imagePath);
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) throws IOException {
        this.image = loadImageDataFromPath(image);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                '}';
    }

    public Set<Cos> getCosuri() {
        return cosuri;
    }

    public void setCosuri(Set<Cos> cosuri) {
        this.cosuri = cosuri;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
