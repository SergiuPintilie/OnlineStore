package com.PW_Pintilie_Sergiu.Store.Cos;

import com.PW_Pintilie_Sergiu.Store.Produs.Produs;
import com.PW_Pintilie_Sergiu.Store.Produs.ProdusService;
import com.PW_Pintilie_Sergiu.Store.Security.JwtService;
import com.PW_Pintilie_Sergiu.Store.User.User;
import com.PW_Pintilie_Sergiu.Store.User.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CosService {
    @Autowired
    public final CosRepository cosRepository;
    @Autowired
    public final JwtService jwtService;
    @Autowired
    public final UserRepository userRepository;
    @Autowired
    public final ProdusService produsService;

    public CosService(CosRepository cosRepository, JwtService jwtService, UserRepository userRepository, ProdusService produsService) {
        this.cosRepository = cosRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.produsService = produsService;
    }

    @Transactional
    public Set<Produs> getProductsFromCosByUser(String username){
        User user=userRepository.findByEmail(username).orElse(null);
        Set<Produs>p=cosRepository.findByUser(user).getProduse();
        for (Produs pr:p
             ) {
            System.out.println(pr.getNume());
        }
        return p;
    }
    @Transactional
    public void adaugareProdusInCos(String header, int id) {
        String user = jwtService.extractClaim(header, Claims::getSubject);
        System.out.println("USER:" + user+" id:" +id);

        if (cosRepository.findByUser(userRepository.findByEmail(user).orElse(null)) == null) {
            System.out.println("SUNT AICI");
            Set<Produs> produse = new HashSet<>(); // Initialize with an empty set
            produse.add(produsService.getProdus(id).orElse(null));
            Cos cos = new Cos(userRepository.findByEmail(user).orElse(null), produse);
            cosRepository.save(cos);

        } else {
            Cos cos = cosRepository.findByUser(userRepository.findByEmail(user).orElse(null));
            Set<Produs> produse = cos.getProduse();
            Optional<Produs> pr=produsService.getProdus(id);
            if(pr.isPresent()) {
                Produs p = pr.get();
                produse.add(p);
                cos.setProduse(produse);
                cosRepository.save(cos);
            }
        }
    }
}
