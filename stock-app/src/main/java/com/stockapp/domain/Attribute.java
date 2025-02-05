package com.stockapp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ty_attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_id_seq")
    @SequenceGenerator(name = "attribute_id_seq", sequenceName = "attribute_id_seq", initialValue = 100, allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "attributeId")
    private Integer attributeId;
    @Column(name = "attributeValueId")
    private Integer attributeValueId;
    @Column(name = "customAttributeValue")
    private String customAttributeValue;

    @ManyToOne()
    @JoinColumn (name="tyProduct_id")
    private TYProduct tyProduct;

}
