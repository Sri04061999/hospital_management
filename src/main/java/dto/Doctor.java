package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Doctor_Details")
public class Doctor {
	@Column(nullable = false)
	private int dsalary;
	@Column(nullable = false)
	private String dname;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Column(nullable = false)
	private String dqualification;
	@Id
	private int id;
	@ManyToOne
	@JoinColumn
	private Hospital hospital;

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getDsalary() {
		return dsalary;
	}

	public void setDsalary(int dsalary) {
		this.dsalary = dsalary;
	}

	public String getDqualification() {
		return dqualification;
	}

	public void setDqualification(String dqualification) {
		this.dqualification = dqualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
