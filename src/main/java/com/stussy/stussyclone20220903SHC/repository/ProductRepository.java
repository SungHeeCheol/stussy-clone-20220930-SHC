package com.stussy.stussyclone20220903SHC.repository;

import com.stussy.stussyclone20220903SHC.domain.CollectionsProduct;
import com.stussy.stussyclone20220903SHC.domain.Product;
import com.stussy.stussyclone20220903SHC.domain.PaymentProduct;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
   public List<CollectionsProduct> getProductList(Map<String, Object> map) throws Exception;

   public Product getProduct(int pdtId) throws Exception;
   public PaymentProduct getPaymentProduct(int pdtDtlId) throws Exception;
}
