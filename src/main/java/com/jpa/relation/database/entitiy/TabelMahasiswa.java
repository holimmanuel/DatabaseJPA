package com.jpa.relation.database.entitiy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="tabelmahasiswa")
public class TabelMahasiswa {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	@Column(name = "Nim", length = 8, unique = true)
	private String Nim;
	@Column(name = "nama_mahasiswa", length = 25)
	private String NamaMahasiswa;
	@Column(name = "jenis_kelamin", length = 10)
	private String JenisKelamin;
	@Column(name = "password", length = 25)
	private String Password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "plot_mata_kuliah",
	joinColumns = {
			@JoinColumn(name = "Nim", referencedColumnName = "id",
					nullable = false, updatable = false)
			},
	inverseJoinColumns = {
			@JoinColumn(name = "id", referencedColumnName = "id",
					nullable = false, updatable = false)
	})
	private List<PlotMatakuliah> lstPlotMatkul = new ArrayList<PlotMatakuliah>();
}
