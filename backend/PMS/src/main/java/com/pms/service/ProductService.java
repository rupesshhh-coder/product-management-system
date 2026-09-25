package com.pms.service;

import java.util.List;

import com.pms.dto.ProductDTO;
import com.pms.exception.ResourceNotFoundException;

public interface ProductService {

	public ProductDTO saveProduct(ProductDTO pdto);

	public List<ProductDTO> getAllProduct();

	public ProductDTO getProductById(int id) throws ResourceNotFoundException;

	public String deleteProduct(int id) throws ResourceNotFoundException;

	public ProductDTO updateProduct(int id, ProductDTO pdto) throws ResourceNotFoundException;

}
