package com.stockapp.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ty_product")
public class TYProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typroduct_id_seq")
    @SequenceGenerator(name = "typroduct_id_seq", sequenceName = "typroduct_id_seq", initialValue = 100, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "isTrendyolPublish")
    private boolean isTrendyolPublish;

    @Column(name = "isHbPublish")
    private boolean isHbPublish;

    @Column(name = "barcode", length = 40)
    private String barcode;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "productMainId", length = 40)
    private String productMainId;
    
    @Column(name = "brandId")
    private Integer brandId;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "stockCode", length = 100)
    private String stockCode;
    
    @Column(name = "dimensionalWeight")
    private Long dimensionalWeight;

    @Column(name = "description")
    private String description;
    
    @Column(name = "currencyType")
    private String currencyType;
    
    @Column(name = "listPrice")
    private Long listPrice;
    
    @Column(name = "salePrice")
    private Long salePrice;
    
    @Column(name = "cargoCompanyId")
    private Integer cargoCompanyId;
    
    @Column(name = "deliveryDuration")
    private Integer deliveryDuration;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> images;

    @Column(name = "vatRate")
    private Integer vatRate;
    @Column(name = "shipmentAddressId")
    private Integer shipmentAddressId;
    @Column(name = "returningAddressId")
    private Integer returningAddressId;
    @OneToMany(mappedBy = "tyProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Attribute> attributes = new ArrayList<>();
    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @PrePersist
    void onPrePersist()
    {
        created_at = new java.util.Date();
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
        attribute.setTyProduct(this);
    }
}
