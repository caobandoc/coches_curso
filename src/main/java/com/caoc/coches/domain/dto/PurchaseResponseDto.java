package com.caoc.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PurchaseResponseDto {
    private Long numberInvoice;
    private String CustomerCardId;
    private Date date;
    private Double total;
    private String paymentMethod;
}
