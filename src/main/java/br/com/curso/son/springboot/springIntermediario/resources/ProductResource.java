package br.com.curso.son.springboot.springIntermediario.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.son.springboot.springIntermediario.model.Product;
import br.com.curso.son.springboot.springIntermediario.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API Rest - Model Product")
@RequestMapping("/product")
@RestController
public class ProductResource {
	
	
	
	@Autowired
	 private ProductService productService;

	public ProductResource(ProductService productService) {
	this.productService = productService;
	}
	
	@ApiOperation(value = "Create Product in DataBase")
	@PostMapping(produces = "application/json")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors erros){
		if (!erros.hasErrors()) {
			Product productCreate = this.productService.create(product);
			return new ResponseEntity<Product>(productCreate,HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest()
							 .body(erros.getAllErrors().stream()
							 .map(msg -> msg.getDefaultMessage())
							 .collect(Collectors.joining(",")));
	}
	
	@ApiOperation(value ="Edit Product in DataBase")
	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@Valid @PathVariable(value="id") Long id, @RequestBody Product product,Errors erros){
		
		if (!erros.hasErrors()) {
			Product productCreate = this.productService.update(id, product);
			return new ResponseEntity<Product>(productCreate,HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest()
							 .body(erros.getAllErrors().stream()
							 .map(msg -> msg.getDefaultMessage())
							 .collect(Collectors.joining(",")));
		
	}
	
	@ApiOperation(value ="FindAll Product in DataBase")
	@GetMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> findAll(){
		
		List<Product> list = this.productService.findAll();
		return new ResponseEntity<List>(list, HttpStatus.OK); 
	}
	
	@ApiOperation(value ="FindOne Product in DataBase")
	@GetMapping(value="/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> find(@PathVariable(value="id") Long id){
		Product productCreate = this.productService.find(id);
		return new ResponseEntity<Product>(productCreate, HttpStatus.OK); 
	}
	
	@ApiOperation(value ="Delete Product in DataBase")
	@DeleteMapping(value= "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id ,HttpServletResponse response){
		this.productService.delete(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		
	}
	
	
}
