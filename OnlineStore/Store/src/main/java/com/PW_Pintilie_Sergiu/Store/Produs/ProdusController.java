package com.PW_Pintilie_Sergiu.Store.Produs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping
public class ProdusController {
    @Autowired
    private final TemplateEngine templateEngine;
    private final ProdusService produsService;

    @Autowired
    public ProdusController(TemplateEngine templateEngine, ProdusService produsService) {
        this.templateEngine = templateEngine;
        this.produsService = produsService;
    }

    @GetMapping
    public String getHomePage(){
        return "index";
    }
    @GetMapping("/produse")
    public String listProducts(Model model, @RequestParam(defaultValue = "9") int size,@PageableDefault(size = 9) Pageable pageable) {
        Pageable customPageable= PageRequest.of(pageable.getPageNumber(), size,pageable.getSort());
        Page<Produs> productPage = produsService.getPagination(customPageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("category","Produse");
        model.addAttribute("pageSize",size);
        model.addAttribute("currentURL","/produse");
        return "product-list";
    }
    @GetMapping("/telefoane")
    public String listTelefoane(Model model, @RequestParam(defaultValue = "9") int size,@PageableDefault(size = 9) Pageable pageable) {
        Pageable customPageable= PageRequest.of(pageable.getPageNumber(), size,pageable.getSort());
        Page<Produs> productPage = produsService.getPaginationTelefoane(ProdusCategory.Telefoane,customPageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("category",ProdusCategory.Telefoane);
        model.addAttribute("pageSize",size);
        model.addAttribute("currentURL","/telefoane");
        return "product-list";
    }
    @GetMapping("/tablete")
    public String listTablete(Model model, @RequestParam(defaultValue = "9") int size,@PageableDefault(size = 9) Pageable pageable) {
        Pageable customPageable= PageRequest.of(pageable.getPageNumber(), size,pageable.getSort());
        Page<Produs> productPage = produsService.getPaginationTelefoane(ProdusCategory.Tablete,customPageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("category",ProdusCategory.Tablete);
        model.addAttribute("pageSize",size);
        model.addAttribute("currentURL","/tablete");
        return "product-list";
    }
    @GetMapping("/laptopuri")
    public String listLaptopuri(Model model, @RequestParam(defaultValue = "9") int size,@PageableDefault(size = 9) Pageable pageable) {
        Pageable customPageable= PageRequest.of(pageable.getPageNumber(), size,pageable.getSort());
        Page<Produs> productPage = produsService.getPaginationTelefoane(ProdusCategory.Laptopuri,customPageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("category",ProdusCategory.Laptopuri);
        model.addAttribute("pageSize",size);
        model.addAttribute("currentURL","/laptopuri");
        return "product-list";
    }
    @GetMapping("/*/id:{id}")
    public String showProduct(Model model, @PathVariable int id) {
        Optional<Produs> produs = produsService.getProdus(id);
        model.addAttribute("produs", produs.orElse(null));
        return "product-page";
    }
    @GetMapping("/search")
    public String searchProdus(Model model,@RequestParam("keyWord") String keyWord,@RequestParam(defaultValue = "9") int size, @PageableDefault(size=9) Pageable pageable) {
        //System.out.println(keyWord);
        Pageable customPageable= PageRequest.of(pageable.getPageNumber(), size,pageable.getSort());
        Page<Produs> productPage = produsService.getSearch(keyWord,customPageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("category","SearchResult");
        model.addAttribute("currentURL","/search");
        return "product-list";
    }
    @GetMapping("/add")
    public String add() {
        return "adaugare-produs";
    }
    @PostMapping("/AdaugareProdus")
    public String adaugareProdus(Model model,
                                 @RequestParam("category") String category,
                                 @RequestParam("imagePath") String imagePath,
                                 @RequestParam("nume") String nume,
                                 @RequestParam("descriere")String descriere,
                                 @RequestParam("pret") String pret) throws IOException {
        produsService.saveProdus(category,imagePath,nume,descriere,Double.parseDouble(pret));
        return "adaugare-produse";
    }

    @GetMapping("/update/id:{id}")
    public String update(Model model,@PathVariable int id){
        Optional<Produs> produs = produsService.getProdus(id);
        model.addAttribute("produs", produs.orElse(null));
        return "update-produs";
    }
    @PostMapping("/UpdateProdus")
    public String updateProdus(Model model,
                                 @RequestParam("id") int id,
                                 @RequestParam("category") String category,
                                 @RequestParam("nume") String nume,
                                 @RequestParam("descriere")String descriere,
                                 @RequestParam("pret") double pret) throws IOException {
        produsService.updateProdus(id,category,nume,descriere,pret);
        return "redirect:/Admin_listaProduse";
    }
    @PostMapping("/delete/id:{id}")
    public String delete(@PathVariable int id) {
        System.out.println("Intrat in delete");
        produsService.deleteProduct(id);
        System.out.println("produs sters");
        return "redirect:/Admin_listaProduse";
    }

    @GetMapping("/Admin_listaProduse")
    public String listProductsAdmin(Model model) {
        List<Produs> productPage = produsService.getProduse();
        model.addAttribute("produse", productPage);
        return "admin-lista-produse";
    }
}