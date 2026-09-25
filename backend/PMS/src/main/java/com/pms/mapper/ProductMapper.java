package com.pms.mapper;

import com.pms.dto.ProductDTO;
import com.pms.entity.Product;

public class ProductMapper {

	public static Product mapToProduct(ProductDTO pdto) {
		Product p = new Product();
		p.setId(pdto.getId());
		p.setName(pdto.getName());
		p.setCost(pdto.getCost());
		p.setCategory(pdto.getCategory());
		p.setQty(pdto.getQty());
		return p;

	}

	public static ProductDTO mapToProductDTO(Product p) {

//		ProductDTO pdto = new ProductDTO(p.getId(), p.getName(), p.getCost(), p.getCategory(), p.getQty());
//		return pdto;

//	return new ProductDTO(p.getId(),p.getName(),p.getCost(),p.getCategory(),p.getQty());

		ProductDTO pd = new ProductDTO();
		pd.setId(p.getId());
		pd.setName(p.getName());
		pd.setCost(p.getCost());
		pd.setCategory(p.getCategory());
		pd.setQty(p.getQty());
		return pd;

	}

}
