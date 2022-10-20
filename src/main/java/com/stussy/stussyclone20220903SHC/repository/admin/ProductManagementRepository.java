package com.stussy.stussyclone20220903SHC.repository.admin;

import com.stussy.stussyclone20220903SHC.domain.Product;
import com.stussy.stussyclone20220903SHC.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductManagementRepository {
    public List<ProductCategory> getCategoryList() throws Exception;

    public int saveProductMst(Product product) throws Exception;
}
