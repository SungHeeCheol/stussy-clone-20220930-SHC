package com.stussy.stussyclone20220903SHC.service;

import com.stussy.stussyclone20220903SHC.dto.CheckoutRespDto;
import com.stussy.stussyclone20220903SHC.dto.CollectionListRespDto;
import com.stussy.stussyclone20220903SHC.dto.ProductRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;
    public ProductRespDto getProduct(int pdtId) throws Exception;
    public CheckoutRespDto getCheckoutProduct(int pdtDtlId) throws Exception;
}
