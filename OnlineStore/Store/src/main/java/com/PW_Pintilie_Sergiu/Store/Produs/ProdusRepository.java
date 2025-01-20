package com.PW_Pintilie_Sergiu.Store.Produs;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProdusRepository extends JpaRepository<Produs,Integer> {
    Page<Produs> findByCategory(ProdusCategory category, Pageable pageable);
    @Query("SELECT p FROM Produs p WHERE LOWER(p.nume) LIKE %:keyword% OR LOWER(p.descriere) LIKE %:keyword%")
    Page<Produs> searchProducts(@Param("keyword") String keyword, Pageable pageable);

}
