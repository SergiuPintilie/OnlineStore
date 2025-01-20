package com.PW_Pintilie_Sergiu.Store.Cos;

import com.PW_Pintilie_Sergiu.Store.Produs.Produs;
import com.PW_Pintilie_Sergiu.Store.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CosRepository extends JpaRepository<Cos,Integer> {
    public Cos findByUser(User user);
    public Cos findById(int id);
}
