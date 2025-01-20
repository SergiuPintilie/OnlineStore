package com.PW_Pintilie_Sergiu.Store.Order;

import com.PW_Pintilie_Sergiu.Store.Produs.Produs;
import com.PW_Pintilie_Sergiu.Store.User.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(
            name = "order_produs",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "produs_id")
    )
    private Set<Produs> produse;

    private String status;
    private String address;

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Orders(User user, Set<Produs> produse,String address) {
        this.user = user;
        this.produse = produse;
        this.status = "comanda plasata";
        this.address=address;
    }

    public Orders() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Produs> getProduse() {
        return produse;
    }

    public void setProduse(Set<Produs> produse) {
        this.produse = produse;
        produse.forEach(produs -> produs.getOrders().add(this));
    }
}
