package br.com.curso.son.springboot.springIntermediario.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID;
	
	@Min(value = 0)
	@Max(value = 100)
	private Integer qtd;
	
	@NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Can not be blank")
	@Size(min = 4 , max = 255)
	private String nome;
	
	private Date dateCreated;
	
	
	public Product() {
		
	}
	
	@PrePersist
	public void onPrepesist() {
		if (this.dateCreated == null) {
			this.dateCreated = new Date();
		}
	}
	

	public Product(Long iD, Integer qtd, String nome) {
		super();
		ID = iD;
		this.qtd = qtd;
		this.nome = nome;
	}



	@Override
    public String toString() {
        return "{ id: " + this.ID + " ,name: " + this.nome + ", qtd: " + this.qtd + ", dateCreated: " + this.dateCreated + "}"; 
}


	public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
}
    
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
