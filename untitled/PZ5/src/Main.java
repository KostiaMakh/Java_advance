public class Main {

//    Создать класс Mobile с внутренним классом,
//    с помощью объектов которого можно хранить информацию о моделях телефонов и их свойствах.

    public static void main(String[] args) {

        Mobile mob1 = new Mobile(
                1, "3310", 450, 180, 70, 35,
                "Nokia", "Finland", "China",
                (float) 6.4, 320, 280, "Monochrome");

        System.out.println(mob1.getHeight());
        System.out.println(mob1.getSize());

        System.out.println(mob1.manufacture.getBrande());
        System.out.println(mob1.manufacture.getFatcoryDet());
        System.out.println(mob1.screen.getDetails());
    }
}