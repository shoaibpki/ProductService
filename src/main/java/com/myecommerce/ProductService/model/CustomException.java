package com.myecommerce.ProductService.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomException {
    private String errorMessage;
    private String errorCode;
}
