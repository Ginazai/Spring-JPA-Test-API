package com.dashboard.Entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Productos")
public class Product {
	
	//constructor
	public Product() {
		super();
	}
	public Product(String name, String category, float price, String tags, 
			Boolean active, Set<ProductCategory> categories, Long id,
			int quantity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.tags = tags;
		this.quantity = quantity;
		this.active = active;
		this.categories = categories;
	}

	//Modified schema for PostgreSQL
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="producto_ID", nullable = false)
	private Long id;
	
//	@Column(name="nombre", nullable = false, length = 100,
//			columnDefinition = "VARCHAR(100) default ''")
	@Column(name="nombre", nullable = false, length = 100)
	private String name;
	
//	@Column(name="precio", nullable = false,
//			columnDefinition = "float default 0.0")
	@Column(name="precio", nullable = false)
	private float price;
	
//	@Column(name="cantidad", nullable = false
//			, columnDefinition = "int default 0")
	@Column(name="cantidad", nullable = false)
	private int quantity;
	
	@Column(name="descripcion", columnDefinition = "TEXT",
			nullable = true)
	private String description;
	
	@Column(name="tags", columnDefinition = "TEXT",
			nullable = true)
	private String tags;
	
	@Column(name="fecha_de_creacion",
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
			, nullable = false, updatable = false)
    private LocalDateTime create_date;
    
//    @Column(name="ultima_actualizacion",
//    		columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Column(name="ultima_actualizacion",
    		columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime last_update;
    
    @Column(name="activo", nullable = false,
    		columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;
    //Join
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
        name = "Productos_Categorias",
        joinColumns = @JoinColumn(name = "producto_ID"),
        inverseJoinColumns = @JoinColumn(name = "categoria_ID")
    )
    private Set<ProductCategory> categories = new HashSet<>();

    //Getters & Setters
    public Long getId() {
		return id;
	}
    public void setId(Long id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<ProductCategory> categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
