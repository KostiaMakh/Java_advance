public class Neurosurgeon extends Surgeon implements Doctor{
    public Neurosurgeon(
            String firstName,
            String lastName,
            String clinic,
            String department,
            int experience
    ){
        this.clinic = clinic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.experirnce = experience;
    }

    @Override
    public void doSurgery(){
        System.out.println(String.format("%s %s (neurosurgeon) doing surgery", firstName, lastName));
    }

    @Override
    public void makeDiagnosis() {
        System.out.println(String.format("%s %s (neurosurgeon) made diagnose", firstName, lastName));
    }

    @Override
    public void patientReception() {
        System.out.println(String.format("%s %s (neurosurgeon) meeting with patient", firstName, lastName));

    }

    @Override
    public void makeDiagnostic() {
        System.out.println(String.format("%s %s (neurosurgeon) makes diagnostic", firstName, lastName));
    }

    @Override
    public void visitsPatient() {
        System.out.println(String.format("%s %s (neurosurgeon) visits patient after surgery", firstName, lastName));
    }

    public void doOperationOnBrain(){
        System.out.println(String.format("%s %s (neurosurgeon) doing operation on brain", firstName, lastName));
    }
}
