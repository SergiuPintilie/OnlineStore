package com.PW_Pintilie_Sergiu.Store.Order;

import com.PW_Pintilie_Sergiu.Store.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    public Set<Orders> findByUser(User user);
}
