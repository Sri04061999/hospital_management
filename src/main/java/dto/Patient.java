package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Patient_Details")
public class Patient {
	@Column(nullable = false)
	private String pname;
	@Id
	private int id;
	@Column(nullable = false)

	private String pdiagnosis;
	@Column(nullable = false)
	private String paddress;
	@OneToMany (mappedBy = "patient")
	List<Medical_Record> medical_Records=new ArrayList<Medical_Record>();

	public List<Medical_Record> getMedical_Records() {
		return medical_Records;
	}

	public void setMedical_Records(List<Medical_Record> medical_Records) {
		this.medical_Records = medical_Records;
	}
	@ManyToOne
	@JoinColumn
	private Hospital hospital;

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPdiagnosis() {
		return pdiagnosis;
	}

	public void setPdiagnosis(String pdiagnosis) {
		this.pdiagnosis = pdiagnosis;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

}
