package org.hms.Hospital_Management.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name= "pms_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //1
    @Column(name = "Company")
    private String companyName;

    //2
    @Column(name = "item_name", nullable = false)
    private String itemName;


    //3
    @Column(nullable = false)
    private String category;

    //4
    private String generic;

    //5
    @Column(nullable = false)
    private int quantity;

    //6
    @Column(name = "unit_price", precision = 10, scale = 2 , nullable = false)
    private BigDecimal unitPrice;   //regular purchase price

    //7
    @Column(name = "purchase_discount", precision = 10, scale = 2)
    private BigDecimal purchaseDiscount;

    //8
    @Column(name = "net_purchase_price", precision = 10, scale = 2)
    private BigDecimal netPurchasePrice;

    //9
    @Column(name = "sell_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal sellPrice;

    //10
    @Column(name = "total_inventory_value", precision = 10, scale = 2)
    private BigDecimal totalInventoryValue;
}