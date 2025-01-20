package com.PW_Pintilie_Sergiu.Store.Order;

import com.PW_Pintilie_Sergiu.Store.Produs.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder/{address}")
    public String placeOrder(@RequestParam(name="address") String adress){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            orderService.placeOrder(username,adress);
        }
        return "redirect:/";
    }
    @GetMapping("/Admin_listaComenzi")
    public String getOrders(Model model){
        model.addAttribute("orders",orderService.getAllOrders());
        return "admin-lista-comenzi";
    }

    @PostMapping("/deleteOrder/id:{id}")
    public String delete(@PathVariable int id) {
        System.out.println("Intrat in delete");
        orderService.deleteOrder(id);
        System.out.println("produs sters");
        return "redirect:/Admin_listaComenzi";
    }
    @GetMapping("/updateOrder/id:{id}")
    public String update(Model model,@PathVariable int id){
        Optional<Orders> op=orderService.findById(id);
        if(op.isPresent()){
            Orders orders=op.get();
            model.addAttribute("order", op.orElse(null));
        }
        return "update-order";
    }
    @PostMapping("/UpdateOrder")
    public String updateProdus(Model model,
                               @RequestParam("id") int id,
                               @RequestParam("status") String status,
                               @RequestParam("address") String address) throws IOException {
        orderService.updateOrder(id,status,address);
        return "redirect:/Admin_listaComenzi";
    }

}
