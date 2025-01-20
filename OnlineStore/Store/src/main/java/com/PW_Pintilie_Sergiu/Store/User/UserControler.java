package com.PW_Pintilie_Sergiu.Store.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
public class UserControler {
    @Autowired
    public final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addAdminPage")
    public String renderHtml() {
        return "adaugare-administratori";
    }
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password){
        User u=new User(firstName,lastName,email,password,Role.ADMIN.name());
        userService.addAdmin(u);
        return "redirect:/Admin_listaAdmin";
    }
    @GetMapping("/Admin_listaAdmin")
    public String adminList(Model model){
        model.addAttribute("admins",userService.getAdmins());
        return "admin-lista-administratori";
    }
    @PostMapping("/deleteAdmin/id:{id}")
    public String deleteAdmin(@PathVariable int id){
        userService.deleteAdmin(id);
        return "redirect:/Admin_listaAdmin";
    }
    @GetMapping("/UpdateAdmin/id:{id}")
    public String updateAdminPage(Model model,@PathVariable int id){
        Optional<User> user=userService.findAdminById(id);
        model.addAttribute("admin",user.orElse(null));
        return "update-administratori";
    }
    @PostMapping("/updAdmin")
    public String updateAdmin(@RequestParam("id") int id,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("email") String email){
        userService.updateAdmin(id,firstName,lastName,email);
        return "redirect:/Admin_listaAdmin";
    }
}
