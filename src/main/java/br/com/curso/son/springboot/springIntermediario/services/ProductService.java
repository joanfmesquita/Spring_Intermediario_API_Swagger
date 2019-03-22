package br.com.curso.son.springboot.springIntermediario.services;

import java.util.List;

import br.com.curso.son.springboot.springIntermediario.model.Product;

public interface ProductService {
	

	public List<Product> findAll();
	
	public Product find(Long id);
	
	public Product create(Product product);
	
	public Product update(Long id,Product product);
	
	public void delete(Long id);
	
	
}
