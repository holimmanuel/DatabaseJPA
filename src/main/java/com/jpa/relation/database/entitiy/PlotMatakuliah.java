package com.jpa.relation.database.entitiy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="plotmatakuliah")
public class PlotMatakuliah {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	private String idDosen;
	private String nim;
	private String idMataKuliah;
	
	@ManyToMany(mappedBy = "lstPlotMatkul")	
	private List<TabelDosen> lstDosen = new ArrayList<TabelDosen>();
	
	@ManyToMany(mappedBy = "lstPlotMatkul")	
	private List<TabelMahasiswa> lstMahasiswa = new ArrayList<TabelMahasiswa>();
	
	@ManyToMany(mappedBy = "lstPlotMatkul")	
	private List<MataKuliah> lstMatkul = new ArrayList<MataKuliah>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_plot_matkul" , referencedColumnName = "id")
	private List <Soal> lstSoal = new ArrayList<Soal>();

}
