/*package com.stockapp.service.Impl;

import com.stockapp.domain.TYProduct;
import com.stockapp.dto.product.ProductSearchRequest;
import com.stockapp.repository.ProductRepository;
import com.stockapp.repository.projection.ProductProjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.stockapp.util.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TYProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private SpelAwareProxyProjectionFactory factory;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void findProductById() {
        TYProduct TYProduct = new TYProduct();
        TYProduct.setId(123L);

        when(productRepository.findById(123L)).thenReturn(java.util.Optional.of(TYProduct));
        productService.getProductById(123L);
        assertEquals(123L, TYProduct.getId());
        assertNotEquals(1L, TYProduct.getId());
        verify(productRepository, times(1)).findById(123L);
    }

    @Test
    public void findAllProducts() {
        Pageable pageable = PageRequest.of(0, 20);
        List<ProductProjection> productProjectionList = new ArrayList<>();
        productProjectionList.add(factory.createProjection(ProductProjection.class));
        productProjectionList.add(factory.createProjection(ProductProjection.class));
        Page<ProductProjection> productList = new PageImpl<>(productProjectionList);

        when(productRepository.findAllByOrderByIdAsc(pageable)).thenReturn(productList);
        productService.getAllProducts(pageable);
        assertEquals(2, productProjectionList.size());
        verify(productRepository, times(1)).findAllByOrderByIdAsc(pageable);
    }

    @Test
    public void saveProduct() {
        MultipartFile multipartFile = new MockMultipartFile(FILE_NAME, FILE_NAME, "multipart/form-data", FILE_PATH.getBytes());
        TYProduct TYProduct = new TYProduct();
        TYProduct.setId(1L);

        when(productRepository.save(TYProduct)).thenReturn(TYProduct);
        productService.saveProduct(TYProduct);
        verify(productRepository, times(1)).save(TYProduct);
    }
}
*/