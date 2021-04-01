package com.jpa.relation.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.jpa.relation.database.entitiy.MataKuliah;
import com.jpa.relation.database.entitiy.Nilai;
import com.jpa.relation.database.entitiy.Pertanyaan;
import com.jpa.relation.database.entitiy.PlotMatakuliah;
import com.jpa.relation.database.entitiy.Soal;
import com.jpa.relation.database.entitiy.TabelAdmin;
import com.jpa.relation.database.entitiy.TabelDosen;
import com.jpa.relation.database.entitiy.TabelMahasiswa;
import com.jpa.relation.database.repository.MatakuliahRepository;
import com.jpa.relation.database.repository.NilaiRepository;
import com.jpa.relation.database.repository.PertanyaanRepository;
import com.jpa.relation.database.repository.PlotMataKuliahRepository;
import com.jpa.relation.database.repository.SoalRepository;
import com.jpa.relation.database.repository.TabelAdminRepository;
import com.jpa.relation.database.repository.TabelDosenRepository;
import com.jpa.relation.database.repository.TabelMahasiswaRepository;


@SpringBootApplication
public class JpaRelationDatabaseUjian4Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationDatabaseUjian4Application.class, args);
	}
	@Autowired
	TabelAdminRepository tabeladminRepository;
	@Autowired
	TabelDosenRepository tabeldosenRepository;
	@Autowired
	TabelMahasiswaRepository tabelmahasiswaRepository;
	@Autowired
	MatakuliahRepository matkulRepository;
	@Autowired
	PlotMataKuliahRepository plotMatkulRepository;
	@Autowired
	SoalRepository soalRepository;
	@Autowired
	PertanyaanRepository pertanyaanRepository;
	@Autowired
	NilaiRepository nilaiRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		TabelAdmin admin = new TabelAdmin();
		admin.setUsername("Holly");
		admin.setPassword("taikkucing");
		this.tabeladminRepository.save(admin);
		
		TabelDosen dosen = new TabelDosen();
		dosen.setIdDosen("D1");
		dosen.setNamaDosen("marbun");
		dosen.setUsername("marbuns");
		dosen.setPassword("marbun1");
		
		
		TabelMahasiswa mahasiswa = new TabelMahasiswa();
		mahasiswa.setNim("1456");
		mahasiswa.setNamaMahasiswa("asep");
		mahasiswa.setJenisKelamin("laki_laki");
		mahasiswa.setPassword("asep1");
		
		MataKuliah matkul = new MataKuliah();
		matkul.setIdMataKuliah("MtkS1");
		matkul.setNamaMataKuliah("Aljabar");
		
		List<TabelDosen> lstDosen = new ArrayList<TabelDosen>();
		lstDosen.add(dosen);
		this.tabeldosenRepository.save(dosen);
		
		List<TabelMahasiswa> lstMahasiswa = new ArrayList<TabelMahasiswa>();
		lstMahasiswa.add(mahasiswa);
		this.tabelmahasiswaRepository.save(mahasiswa);
		
		List<MataKuliah> lstMatakuliah = new ArrayList<MataKuliah>();
		lstMatakuliah.add(matkul);
		this.matkulRepository.save(matkul);
		
		PlotMatakuliah plotmatkul = new PlotMatakuliah();
		plotmatkul.setIdDosen(dosen.getIdDosen());
		plotmatkul.setNim(mahasiswa.getNim());
		plotmatkul.setIdMataKuliah(matkul.getIdMataKuliah());
		
		List<PlotMatakuliah> lstplotmatkul = new ArrayList <PlotMatakuliah>();
		lstplotmatkul.add(plotmatkul);


		mahasiswa.setLstPlotMatkul(lstplotmatkul);
		matkul.setLstPlotMatkul(lstplotmatkul);
		this.plotMatkulRepository.save(plotmatkul);
		
		Soal soal1 = new Soal();
		soal1.setIdSoal("Soal1");
		soal1.setNamaSoal("Soal_Aljabar");
		soal1.setStatus(1);
		
		Pertanyaan pertanyaan1 = new Pertanyaan();
		pertanyaan1.setIdPertanyaan("Pertanyaan");
		pertanyaan1.setJawaban1("A");
		pertanyaan1.setJawaban2("B");
		pertanyaan1.setJawaban3("C");
		pertanyaan1.setJawaban4("D");
		pertanyaan1.setJawaban_benar("C");
		pertanyaan1.setStatusGambar(1);
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();	
		lstPertanyaan.add(pertanyaan1);
		soal1.setLstPertanyaan(lstPertanyaan);
		this.soalRepository.save(soal1);
		
		Nilai nilai1 = new Nilai();
		nilai1.setNilai(100);
		
		List<Nilai> lstNilai = new ArrayList<Nilai>();
		lstNilai.add(nilai1);
		soal1.setLstNilai(lstNilai);
		this.soalRepository.save(soal1);
				
	
	}


}
