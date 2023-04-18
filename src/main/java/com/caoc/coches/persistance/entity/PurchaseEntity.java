package com.caoc.coches.persistance.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Long numberBill;
    @Column(name = "cliente_cedula")
    private String cardIdCustomer;
    @Column(name = "fecha")
    private LocalDateTime date;
    @Column(name = "total")
    private Double total;
    @Column(name = "medio_pago")
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;
    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carPurchaseEntityList;
}
