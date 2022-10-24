package com.stussy.stussyclone20220903SHC.service;

import com.stussy.stussyclone20220903SHC.dto.CollectionListRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;
}
