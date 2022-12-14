import java.util.ArrayList;
import java.util.List;

public abstract class Surgeon {
    protected String firstName;
    protected String lastName;
    protected String clinic;
    protected String department;
    protected int experirnce;
    protected ArrayList<Patient> patients = new ArrayList<>();
    protected abstract void doSurgery();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExperirnce() {
        return experirnce;
    }

    public void setExperirnce(int experirnce) {
        this.experirnce = experirnce;
    }

    public void setPatients(Patient patient){
        if (!patients.contains(patient)){
            patients.add(patient);
        }
    }
    public ArrayList<Patient> getPatients(){
        return patients;
    }
    public void removePatients(Patient patient) {
        if (patients.contains(patient)) {
            patients.add(patient);
        }
        else {
            System.err.println("There are no this patient");
        }
    }
}
