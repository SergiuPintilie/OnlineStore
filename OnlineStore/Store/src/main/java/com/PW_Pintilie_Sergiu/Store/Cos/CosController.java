package com.PW_Pintilie_Sergiu.Store.Cos;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

@Controller
public class CosController {
    @Autowired
    public final CosService cosService;
    public CosController(CosService cosService) {
        this.cosService = cosService;
    }
    
    @GetMapping("/cos")
    public String getCos(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            model.addAttribute("produse",cosService.getProductsFromCosByUser(username));
        }
        return "cos";
    }
    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam int id, HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        System.out.println(token+ " id:"+id);
        cosService.adaugareProdusInCos(token,id);
        return ResponseEntity.ok("Ok");
    }
}
