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
@Table(name = "medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicine_id;

	private String name;
	private String dosage;
	private Double price;
	private String manufacturer;
	private String category;
	private LocalDate expirationDate;
	private Integer stock;

	public Medicine(String name, String dosage, Double price, String manufacturer, String category, Integer stock) {
		this.name = name;
		this.dosage = dosage;
		this.price = price;
		this.manufacturer = manufacturer;
		this.category = category;
		this.stock = stock;
	}

	@PreUpdate
	protected void expirationDate() {
		expirationDate = LocalDate.now();
	}

}
