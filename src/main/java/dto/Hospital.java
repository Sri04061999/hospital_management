package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Hospital_Details")
public class Hospital {
	@Override
	public String toString() {
		return "Hospital [hname=" + hname + ", city=" + city + ", haddress=" + haddress + ", hid=" + hid + ", patient="
				+ patient + ", doctors=" + doctors + "]";
	}
	@Column(nullable = false)
	private String hname;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String haddress;
	@Id
	private int hid;
	@OneToMany (mappedBy = "hospital")
	private List<Patient> patient=new ArrayList<Patient>();

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	@OneToMany (mappedBy = "hospital")
	private List<Doctor> doctors=new ArrayList<Doctor>();
	
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

}
