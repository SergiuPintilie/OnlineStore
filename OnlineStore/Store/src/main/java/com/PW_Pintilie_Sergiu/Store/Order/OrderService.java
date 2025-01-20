package com.PW_Pintilie_Sergiu.Store.Order;

import com.PW_Pintilie_Sergiu.Store.Cos.Cos;
import com.PW_Pintilie_Sergiu.Store.Cos.CosRepository;
import com.PW_Pintilie_Sergiu.Store.Produs.Produs;
import com.PW_Pintilie_Sergiu.Store.Produs.ProdusRepository;
import com.PW_Pintilie_Sergiu.Store.User.User;
import com.PW_Pintilie_Sergiu.Store.User.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    public final ProdusRepository produsRepository;
    public final UserRepository userRepository;
    public final OrderRepository orderRepository;
    public final CosRepository cosRepository;

    public OrderService(ProdusRepository produsRepository, UserRepository userRepository, OrderRepository orderRepository, CosRepository cosRepository) {
        this.produsRepository = produsRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.cosRepository = cosRepository;
    }
    @Transactional
    public void placeOrder(String username,String address) {
        Optional<User> op = userRepository.findByEmail(username);

        if (op.isPresent()) {
            User user = op.get();
            Cos cos = cosRepository.findByUser(user);
            Set<Produs> produse = cos.getProduse();
            Set<Produs> newProduse=new HashSet<Produs>();
            for(Produs p :produse){
                newProduse.add(p);
            }
            Orders newOrder = new Orders(user, newProduse,address);
            orderRepository.save(newOrder);
        }
    }

    public Set<Orders> getOrderByUser(String username) {
        Optional<User> op = userRepository.findByEmail(username);

        if (op.isPresent()) {
            User user = op.get();
            return orderRepository.findByUser(user);
        }
        return null;
    }
    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }
    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

    public Optional<Orders> findById(int id){
       return orderRepository.findById(id);
    }

    public void updateOrder(int id, String status, String address){
        Optional<Orders> op=orderRepository.findById(id);
        if(op.isPresent())
        {
            Orders orders=op.get();
            orders.setAddress(address);
            orders.setStatus(status);
            orderRepository.save(orders);
        }
    }

}
