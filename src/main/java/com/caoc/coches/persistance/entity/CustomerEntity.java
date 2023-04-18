package com.caoc.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity  {

    @Id
    @Column(name = "cedula")
    private String cardId;
    @Column(name = "nombre_completo")
    private String fullName;
    @Column(name = "correo")
    private String email;
    @Column(name = "numero_celular")
    private Double numberPhone;
    @Column(name = "activo")
    private Integer active;
    @Column(name = "contrasenia")
    private String password;
    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntityList;


}
