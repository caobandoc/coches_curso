package com.caoc.coches.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseRequestDto {
    private Integer numberBill;
    private String cardIdCustomer;
    private LocalDateTime date;
    private Double total;
    private String paymentMethod;
    private List<CarPurchaseRequestDto> carPurchaseRequestDtoList;
}
