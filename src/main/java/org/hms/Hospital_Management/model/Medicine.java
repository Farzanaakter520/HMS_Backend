package org.hms.Hospital_Management.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicine_table")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Double price;
	private String manufacturer;
	private String category;
	private LocalDate expirationDate;
	private Integer stock;
	private String image;

	public Medicine(String name, Double price, String manufacturer, String category, Integer stock, LocalDate expirationDate,String image) {
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
		this.category = category;
		this.stock = stock;
		this.expirationDate = expirationDate;
		this.image = image;
	}

	@PreUpdate
	protected void expirationDate() {
		expirationDate = LocalDate.now();
	}

}
