package br.com.curso.son.springboot.springIntermediario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.son.springboot.springIntermediario.model.Product;
import br.com.curso.son.springboot.springIntermediario.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		 this.productRepository = productRepository;
	}
	
	
	@Override
	public List<Product> findAll() {
		
		return this.productRepository.findAll();
	}

	@Override
	public Product find(Long id) {
		
		return null;
	}

	@Override
	public Product create(Product product) {
		
		this.productRepository.save(product);
		return  product;
	}

	@Override
	public Product update(Long id, Product product) {
		Product productExists = this.productRepository.findOne(id);
		if (null != productExists) {
			product.setID(productExists.getID());
			this.productRepository.save(product);
			return product;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Product product = this.productRepository.findOne(id);
				
				if (null != product) {
					this.productRepository.delete(product);					
				}
		
	}

	
	
}
