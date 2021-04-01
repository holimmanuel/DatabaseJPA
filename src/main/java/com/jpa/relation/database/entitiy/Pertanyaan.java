package com.jpa.relation.database.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="prtanyaan")
public class Pertanyaan {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	private String idPertanyaan;
	private String pertanyaan;
	private String jawaban1;
	private String jawaban2;
	private String jawaban3;
	private String jawaban4;
	
	private String jawaban_benar;
	
	@Column(name = "status_gambar", length = 1)
	private int statusGambar;

}
