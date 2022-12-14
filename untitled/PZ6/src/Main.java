public class Main {

    // interface Врач class Хирург class Нейрохирург.
    public static void main(String[] args) {
        Neurosurgeon doc1 = new Neurosurgeon("Alex",
                "Berchen",
                "Ohmadit",
                "Surgery",
                40);

        doc1.doOperationOnBrain();
        doc1.visitsPatient();
        System.out.println(doc1.getExperirnce());

    }
}