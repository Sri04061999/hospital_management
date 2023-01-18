package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Doctor;
import dto.Hospital;
import dto.Medical_Record;
import dto.Patient;

public class Hospital_dao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void addHospitalDetails(Hospital h) {

		transaction.begin();
		manager.persist(h);
		transaction.commit();

	}

	public Hospital findHospital(int hid) {
		Hospital hosp = manager.find(Hospital.class, hid);
		if (hosp != null) {
			return hosp;
		}
		return null;

	}

	public Doctor findDoctor(int did) {
		Doctor doc = manager.find(Doctor.class, did);
		if (doc != null) {
			return doc;
		}
		return null;

	}

	public void addDoctorDetails(Doctor doctor) {
		transaction.begin();
		manager.persist(doctor);
		transaction.commit();
	}

	public void addPatientDetails(Patient patient) {
		transaction.begin();
		manager.persist(patient);
		transaction.commit();
	}

	public Patient findPatient(int hid) {
		Patient p = manager.find(Patient.class, hid);
		if (p != null) {
			return p;
		}
		return null;

	}

	public Medical_Record findRecord(int mid) {
		Medical_Record mr = manager.find(Medical_Record.class, mid);
		if (mr != null) {
			return mr;
		}
		return null;

	}

	public void addMedicalRecord(Medical_Record m) {

		transaction.begin();
		manager.persist(m);
		transaction.commit();

	}

	public void updateHname(Hospital hospital) {
		transaction.begin();
		manager.persist(hospital);
		transaction.commit();
	}

	public void updateDoctor(Doctor doc) {
		transaction.begin();
		manager.persist(doc);
		transaction.commit();
	}

	public void updatePatient(Patient p) {
		transaction.begin();
		manager.persist(p);
		transaction.commit();
	}

	public void updateMedicalRecord(Medical_Record m) {
		transaction.begin();
		manager.persist(m);
		transaction.commit();
	}

	public void getallHospitaldetails() {
		Query q = manager.createQuery("Select h from Hospital_Details h", Hospital.class);
		List<Hospital> hl = q.getResultList();
		for (Hospital e : hl) {
			System.out.println("city : " + e.getCity() + " address : " + e.getHaddress() + " id ; " + e.getHid()
					+ " name : " + e.getHname());

			System.out.println("Doctors present in this hospital:");
			List<Doctor> lt1 = e.getDoctors();
			for (Doctor lt : lt1) {
				System.out.println(lt.getDname());
			}
			System.out.println("patient present in this hospital:");
			List<Patient> lt2 = e.getPatient();
			for (Patient lt : lt2) {
				System.out.println(lt.getPname());
			}
		}
	}

	public void getalldoctors() {
		Query q = manager.createQuery("select d from Doctor_Details d", Doctor.class);
		List<Doctor> hl = q.getResultList();
		for (Doctor d : hl) {
			System.out.println(" doctor name : " + d.getDname() + " qualification : " + d.getDqualification()
					+ " salary : " + d.getDsalary() + " id : " + d.getId());
		}
	}

	public void getallPatient() {
		Query q = manager.createQuery("select d from Patient_Details d", Patient.class);
		List<Patient> hl = q.getResultList();
		for (Patient d : hl) {
			System.out.println(" patient address : " + d.getPaddress() + " id : " + d.getId() + " diagnosis : "
					+ d.getPdiagnosis() + " name : " + d.getPname());
			List<Medical_Record> lt = d.getMedical_Records();
			for (Medical_Record m : lt) {
				System.out.println("problem : " + m.getProblem());
			}
		}

	}

	public void getallMedicalDeatails() {
		Query q = manager.createQuery("select d from Medical_Record d", Medical_Record.class);
		List<Medical_Record> hl = q.getResultList();
		for (Medical_Record d : hl) {
			System.out.println(
					" patient address : " + d.getProblem() + " id : " + d.getRdate() + " diagnosis : " + d.getRid());
		}
	}
}
