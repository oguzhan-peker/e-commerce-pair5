package com.etiya.ecommercedemopair5.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
    
    private int id;
    private String productName;
    private double unitPrice;


}
