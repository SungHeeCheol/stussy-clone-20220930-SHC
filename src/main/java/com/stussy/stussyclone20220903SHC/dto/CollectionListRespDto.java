package com.stussy.stussyclone20220903SHC.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CollectionListRespDto {
    private int productId;
    private String productName;
    private int productPrice;
    private String mainImg;
    private int productTotalCount;
}
