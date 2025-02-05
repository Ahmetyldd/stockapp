package com.stockapp.repository;

import com.stockapp.domain.TYProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<TYProduct, Long> {

    Page<TYProduct> findByCompanyIdAndStatus(Long companyId, Integer status, Pageable pageable);
    Page<TYProduct> findByCompanyId(Long companyId, Pageable pageable);

    List<TYProduct> findAllByOrderByIdAsc();
    
    @Query("SELECT product FROM TYProduct product ORDER BY product.id ASC")
    Page<TYProduct> findAllByOrderByIdAsc(Pageable pageable);

    List<TYProduct> findByIdIn(List<Long> productsIds);

    @Query("SELECT product FROM TYProduct product WHERE product.id IN :productsIds")
    List<TYProduct> getProductsByIds(List<Long> productsIds);

}
