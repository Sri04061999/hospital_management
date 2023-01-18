package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.Hospital_dao;
import dto.Doctor;
import dto.Hospital;

import dto.Medical_Record;
import dto.Patient;

public class Driver {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("**********Welcome to Hospital management application*********");
		boolean flag = true;
		Hospital_dao h = new Hospital_dao();
		while (flag) {
			System.out.println("Select any one option");
			System.out.println("1.add hospital");
			System.out.println("2.add doctor");
			System.out.println("3.add patient");
			System.out.println("4.add medical_report");
			System.out.println("5.update the hospital name");
			System.out.println("6.update the doctor name, salary");
			System.out.println("7.update patient name");
			System.out.println("8.update medical report");
			System.out.println("9.get hospital details");
			System.out.println("10.get doctor details");
			System.out.println("11.get patient details");
			System.out.println("12.get medical details");
			System.out.println("13.get all hospital details");
			System.out.println("14.get all doctor details");
			System.out.println("15.get all Patient details");
			System.out.println("16.get all medical details");
			System.out.println("17.exit");
			int opt = sc.nextInt();

			switch (opt) {
			case 1: {

				System.out.println("enter the Hospital Name");
				String name = sc.next();
				System.out.println("enter the Hospital city");
				String city = sc.next();
				System.out.println("enter the Hospital address");
				String haddress = sc.next();
				System.out.println("enter the Hospital id");
				int hid = sc.nextInt();
				Hospital hospital = new Hospital();
				hospital.setHname(name);
				hospital.setCity(city);
				hospital.setHaddress(haddress);
				hospital.setHid(hid);
				List<Hospital> lt = new ArrayList<Hospital>();
				lt.add(hospital);
				h.addHospitalDetails(hospital);
				System.out.println("Successfully added");

			}
				break;
			case 2: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter the name");
					String name = sc.next();
					System.out.println("enter the dsalary");
					int salary = sc.nextInt();
					System.out.println("enter the d_id");
					int id = sc.nextInt();
					System.out.println("enter the dqualification");
					String q = sc.next();
					Doctor doctor = new Doctor();
					doctor.setDname(name);
					doctor.setDsalary(salary);
					doctor.setDqualification(q);
					doctor.setId(id);

					List<Doctor> lt = hp.getDoctors();
					lt.add(doctor);

					hp.setDoctors(lt);
					doctor.setHospital(hp);

					dao.addDoctorDetails(doctor);
					System.out.println("added");
				}
			}
				break;
			case 3: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter the patient name");
					String name = sc.next();
					System.out.println("enter the patient id");
					int id = sc.nextInt();
					System.out.println("enter the patient pdiagnosis");
					String pdiagnosis = sc.next();
					System.out.println("enter the patient paddress");
					String paddress = sc.next();
					Patient p = new Patient();
					p.setId(id);
					p.setPaddress(paddress);
					p.setPname(name);
					p.setPdiagnosis(pdiagnosis);
					List<Patient> lt = hp.getPatient();
					lt.add(p);
					hp.setPatient(lt);
					p.setHospital(hp);
					dao.addPatientDetails(p);
					System.out.println("added");

				}

			}
				break;
			case 4: {
				System.out.println("enter the patient id");
				int pid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Patient pa = dao.findPatient(pid);
				if (pa != null) {

					System.out.println("enter the rid");
					int rid = sc.nextInt();
					System.out.println("enter the problem");
					String pro = sc.next();
					System.out.println("enter the rdate");
					String rdate = sc.next();
					Medical_Record m = new Medical_Record();
					m.setRid(rid);
					m.setProblem(pro);
					m.setRdate(rdate);
					List<Medical_Record> lt = pa.getMedical_Records();
					lt.add(m);
					pa.setMedical_Records(lt);
					m.setPatient(pa);
					dao.addMedicalRecord(m);
					System.out.println("added");

				}
			}
				break;
			case 5: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter the new hospital name");
					String name = sc.next();
					hp.setHname(name);
					dao.updateHname(hp);
					System.out.println("done");

				}

			}
				break;
			case 6: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter doctor id");
					int did = sc.nextInt();
					Doctor d = dao.findDoctor(did);
					if (d != null) {
						System.out.println("enter the new doctor name");
						String name = sc.next();
						d.setDname(name);
						System.out.println("enter the new doctor salary");
						int sal = sc.nextInt();
						d.setDsalary(sal);
						dao.updateDoctor(d);
						System.out.println("done");
					}

				}
			}
				break;
			case 7: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter patient id");
					int pid = sc.nextInt();
					Patient p = dao.findPatient(pid);
					if (p != null) {
						System.out.println("enter new patient name");
						String name = sc.next();
						p.setPname(name);
						dao.updatePatient(p);
						System.out.println("done");
					}

				}

			}
				break;
			case 8: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter patient id");
					int pid = sc.nextInt();
					Patient p = dao.findPatient(pid);
					if (p != null) {
						System.out.println("enter medical report id");
						int id = sc.nextInt();
						Medical_Record record = dao.findRecord(id);
						if (record != null) {
							System.out.println("enter new disease");
							String d = sc.next();
							record.setProblem(d);
							dao.updateMedicalRecord(record);
							System.out.println("done");
						}

					}
				}

			}
				break;
			case 9: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println(
							"name : " + hp.getHname() + " address :  " + hp.getHaddress() + " city :  " + hp.getCity());

				}

			}
				break;
			case 10: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter doctor id");
					int did = sc.nextInt();
					Doctor d = dao.findDoctor(did);
					if (d != null) {
						System.out.println("doctor name : " + d.getDname() + " salary : " + d.getDsalary()
								+ " qualification :  " + d.getDqualification());
					}
				}
			}
				break;
			case 11: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter patient id");
					int pid = sc.nextInt();
					Patient p = dao.findPatient(pid);
					if (p != null) {
						System.out.println("patient name : " + p.getPname() + " patient diagnosis : "
								+ p.getPdiagnosis() + " patient  address : " + p.getPaddress());
					}
				}

			}
				break;
			case 12: {
				System.out.println("enter the hospital id");
				int hid = sc.nextInt();
				Hospital_dao dao = new Hospital_dao();
				Hospital hp = dao.findHospital(hid);
				if (hp != null) {
					System.out.println("enter patient id");
					int pid = sc.nextInt();
					Patient p = dao.findPatient(pid);
					if (p != null) {
						System.out.println("enter medical report id");
						int id = sc.nextInt();
						Medical_Record record = dao.findRecord(id);
						if (record != null) {
							System.out.println("problem : " + record.getProblem() + " date : " + record.getRdate());

						}
					}
				}
			}
				break;
			case 13: {

				Hospital_dao h2 = new Hospital_dao();
				h2.getallHospitaldetails();
			}
				break;
			case 14: {
				Hospital_dao h2 = new Hospital_dao();
				h2.getalldoctors();
			}
				break;
			case 15: {
				Hospital_dao h2 = new Hospital_dao();
				h2.getallPatient();
			}
				break;
			case 16: {
				Hospital_dao h2 = new Hospital_dao();
				h2.getallMedicalDeatails();
			}
				break;

			case 17: {
				flag = false;
				System.out.println("thank you for using the application");

			}
				break;

			default:
				System.out.println("invalid option");
				break;
			}

		}
	}

}
