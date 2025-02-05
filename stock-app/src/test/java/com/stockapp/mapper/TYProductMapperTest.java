/*package com.stockapp.mapper;

import com.stockapp.domain.TYProduct;
import com.stockapp.dto.product.ProductRequest;
import com.stockapp.dto.product.FullProductResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.stockapp.util.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TYProductMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void convertToEntity() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductr(PERFUMER_CHANEL);
        productRequest.setProductTitle(PERFUME_TITLE);
        productRequest.setYear(YEAR);
        productRequest.setCountry(COUNTRY);
        productRequest.setProductGender(PERFUME_GENDER);
        productRequest.setFragranceTopNotes(FRAGRANCE_TOP_NOTES);
        productRequest.setFragranceMiddleNotes(FRAGRANCE_MIDDLE_NOTES);
        productRequest.setFragranceBaseNotes(FRAGRANCE_BASE_NOTES);
        productRequest.setPrice(PRICE);
        productRequest.setVolume(VOLUME);
        productRequest.setType(TYPE);

        TYProduct TYProduct = modelMapper.map(productRequest, TYProduct.class);

    }

    @Test
    public void convertToResponseDto() {
        TYProduct TYProduct = new TYProduct();
        TYProduct.setId(1L);

        FullProductResponse fullProductResponse = modelMapper.map(TYProduct, FullProductResponse.class);
        assertEquals(TYProduct.getId(), fullProductResponse.getId());
    }
}
*/