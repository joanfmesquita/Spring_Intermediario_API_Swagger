package br.com.curso.son.springboot.springIntermediario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.son.springboot.springIntermediario.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
