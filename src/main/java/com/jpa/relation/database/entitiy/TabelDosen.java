package com.jpa.relation.database.entitiy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="tabeldosen")
public class TabelDosen {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@Column(name = "id_dosen", length = 10, unique = true)
	private String idDosen;
	@Column(length = 25, unique = true)
	private String username;
	@Column(length = 25)
	private String password;
	@Column(name = "nama_dosen", length = 25)
	private String namaDosen;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "plotmatakuliah",
		@JoinColumn= {
				@JoinColumn(name = "id_dosen", referencedColumnName = "id",
				nullable = false, updatable = false)
		},
		inverseJoinColumns = {
				@JoinColumn(name = "id", referencedColumnName = "id",
						nullable =  false, updatable = false)		
		})

	private List<PlotMatakuliah> lstPlotMatkul = new ArrayList<PlotMatakuliah>();
	
	

}
