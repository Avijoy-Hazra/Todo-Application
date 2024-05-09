package com.springapp.springapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tid")
    public int id;

    @Size(min = 3, message = "Title must be at least 3 characters")
    @NonNull
	@Column(name = "title")
	public String title;  

    @Size(min = 3, message = "Detail must be at least 3 characters")
    @NonNull
	@Column(name = "detail")
	public String detail;  
}
