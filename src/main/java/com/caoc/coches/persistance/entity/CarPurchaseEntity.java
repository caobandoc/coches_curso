package com.caoc.coches.persistance.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {
    @EmbeddedId
    private CarPurchasePK carPurchasePK;
    private Integer quantity;
    private Integer total;
    @ManyToOne
    @MapsId("purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;

}
