package com.PW_Pintilie_Sergiu.Store.Cos;

import com.PW_Pintilie_Sergiu.Store.Produs.Produs;
import com.PW_Pintilie_Sergiu.Store.User.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cos")
public class Cos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne
    User user;
    @ManyToMany
    private Set<Produs> produse = new HashSet<>();

    public Cos(User user, Set<Produs> produse) {
        this.user = user;
        this.produse = produse;
    }

    public Cos() {

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
    }
}
