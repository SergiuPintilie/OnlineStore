package com.PW_Pintilie_Sergiu.Store.Produs;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.PW_Pintilie_Sergiu.Store.Produs.ProdusCategory.*;

@Service
@Transactional
public class ProdusService {

    private final ProdusRepository produsRepository;
    @Autowired
    public ProdusService(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }


    public List<Produs> getProduse(){
        return produsRepository.findAll();
    }
    public Page<Produs> getPagination(Pageable pageable) {
        return produsRepository.findAll(pageable);
    }
    public Page<Produs> getPaginationTelefoane(ProdusCategory category,Pageable pageable) {
        return produsRepository.findByCategory(category,pageable);
    }
    public Page<Produs> getSearch(String keyWord,Pageable pageable){
        return produsRepository.searchProducts(keyWord.toLowerCase(),pageable);
    }
    public Optional<Produs> getProdus(int id){
        return produsRepository.findById(id);
    }

    public void saveProdus(String category,String imagePath,String nume,String descriere,double pret) throws IOException {
        Produs newProdus=new Produs(category,imagePath,nume,descriere,pret);
        produsRepository.save(newProdus);
    }
    public void updateProdus(int id,
                               String category,
                               String nume,
                               String descriere,
                               double pret) throws IOException{
        Optional<Produs> o=produsRepository.findById(id);
        if(o.isPresent()){
            Produs p=o.get();
            p.setNume(nume);
            p.setCategory(ProdusCategory.valueOf(category));
            p.setDescriere(descriere);
            p.setPret(pret);
            produsRepository.save(p);
        }
    }
    void deleteProduct(int id){
        produsRepository.deleteById(id);
    }
}
