package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.ProductDTO;
import com.pms.exception.ResourceNotFoundException;
import com.pms.service.ProductService;

@CrossOrigin("*")     // Application Permission Frontend & Backend
@RestController
@RequestMapping(path = "/pms")
public class ProductController {

	// inject-productService--setter

	@Autowired
	ProductService ps;

	public void setPs(ProductService ps) {
		this.ps = ps;
	}

//	@PostMapping
//	public String save(@RequestBody ProductDTO pd) {
//		ps.saveProduct(pd);
//		return "Saved.";
//	}

//	@PostMapping
//	public ResponseEntity<String> save(@RequestBody ProductDTO pd) {
//		ps.saveProduct(pd);
//		ResponseEntity<String> re = new ResponseEntity<String>("Saved.",HttpStatus.CREATED);
//		
//		return re;
//	}

	@PostMapping
	public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO pd) {
		ProductDTO pdto = ps.saveProduct(pd);
		ResponseEntity<ProductDTO> re = new ResponseEntity<ProductDTO>(pdto, HttpStatus.CREATED);

		return re;
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> viewAll() {
		List<ProductDTO> allP = ps.getAllProduct();
		return ResponseEntity.ok(allP);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> viewProduct(@PathVariable int id) throws ResourceNotFoundException {
		ProductDTO pd = null;
		pd = ps.getProductById(id);
		return ResponseEntity.ok(pd);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteproduct(@PathVariable int id) throws ResourceNotFoundException {
		String s = ps.deleteProduct(id);
		return new ResponseEntity(s, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable int id, @RequestBody ProductDTO pd)
			throws ResourceNotFoundException {
		ProductDTO upProduct = ps.updateProduct(id, pd);

		return new ResponseEntity(upProduct, HttpStatus.OK);
	}

}
