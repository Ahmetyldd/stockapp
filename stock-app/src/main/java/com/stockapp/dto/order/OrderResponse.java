package com.stockapp.dto.order;

import com.stockapp.dto.trendyol.TYProductDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private List<TYProductDto> tyProductDtoList;
}
