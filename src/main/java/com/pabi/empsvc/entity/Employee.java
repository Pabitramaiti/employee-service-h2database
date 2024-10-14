package com.pabi.empsvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emploee")
//@Builder
@Entity
//@SequenceGenerator(name="employee_id_seq", initialValue=5, allocationSize=100)
public class Employee {

	@Id
	@Column
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_id_seq")
	private int id;

	@Column
	@NotEmpty
	private String firstName;

	@Column
	private String lastName;

	@Column
	@Min(value = 18)
	@Max(value = 55)
	private int age;

	@Column
	@NotNull
	private double salary;

}
