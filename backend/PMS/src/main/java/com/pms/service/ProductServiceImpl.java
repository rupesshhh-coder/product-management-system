package com.pms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dto.ProductDTO;
import com.pms.entity.Product;
import com.pms.exception.ResourceNotFoundException;
import com.pms.mapper.ProductMapper;
import com.pms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	// inject- productRepository ---setter

	@Autowired
	ProductRepository pr;

	public void setPr(ProductRepository pr) {
		this.pr = pr;
	}

	@Override
	public ProductDTO saveProduct(ProductDTO pdto) {

		// 1. convert dto to entity
		// 2. operate entity
		// 3. convert entty to dto

		Product p = ProductMapper.mapToProduct(pdto);
		Product savedProduct = pr.save(p);
		ProductDTO savedDto = ProductMapper.mapToProductDTO(savedProduct);

		return savedDto;
	}

	@Override
	public List<ProductDTO> getAllProduct() {

		List<Product> allProduct = pr.findAll();

//		List<ProductDTO> allDto = new ArrayList<ProductDTO>();
//		for(Product p:allProduct) {
//			ProductDTO pd = ProductMapper.mapToProductDTO(p);
//			allDto.add(pd);
//			
//		}

//		Stream<Product> productStream = allProduct.stream();
//		Stream<ProductDTO> dtoStream = productStream.map((Product) -> (ProductMapper.mapToProductDTO(Product)));
//		List<ProductDTO> allDto = dtoStream.collect(Collectors.toList());
//		return allDto;

		return allProduct.stream().map((product) -> (ProductMapper.mapToProductDTO(product)))
				.collect(Collectors.toList());

	}

	@Override
	public ProductDTO getProductById(int id) throws ResourceNotFoundException {
		Product p = pr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product With Given Id " + id + " -  Is Not Exist."));

		ProductDTO pd = ProductMapper.mapToProductDTO(p);
		return pd;
	}

	@Override
	public String deleteProduct(int id) throws ResourceNotFoundException {

		Product p = pr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product With Given Id " + id + " - Is Not Exist."));
		pr.delete(p);
		return "deleted";
	}

	@Override
	public ProductDTO updateProduct(int id, ProductDTO pdto) throws ResourceNotFoundException {

		Product p = pr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product With Given Id " + id + " - Is Not Exist."));
		p.setName(pdto.getName());
		p.setCost(pdto.getCost());
		p.setCategory(pdto.getCategory());
		p.setQty(pdto.getQty());

		Product savedProduct = pr.save(p);

		ProductDTO pd = ProductMapper.mapToProductDTO(savedProduct);

		return pd;
	}

}
