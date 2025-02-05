package com.stockapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
//@Entity
//@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", initialValue = 6, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private Integer status;

    @OneToMany(fetch = FetchType.EAGER)
    private List<TYProduct> tyProducts;

}
