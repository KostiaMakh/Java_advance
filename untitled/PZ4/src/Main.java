import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

//    12. Мобильная связь. Определить иерархию тарифов мобильной компании.
//    Создать список тарифов компании.
//    Подсчитать общую численность клиентов.
//    Провести сортировку тарифов на основе размера абонентской платы.
//    Найти тариф в компании, соответствующий заданному диапазону параметров.

    public static void main(String[] args) {

        // Create company
        MobileCompany company = new MobileCompany("LifeCell", 2014, "Ukraine");

        // Create tariff
        Tariff[] tariffsArr = setTariffs();
        setCompanyTariffs(tariffsArr, company);
        setUsers(tariffsArr, company);

        System.out.println(company.getCompanyDetails() + '\n');

        System.out.println("Company tariffs:");
        for (Tariff tarif : company.getTariffs()){
            System.out.println(
                    String.format("%s - price - %.2f, internet - %d Gb;",
                            tarif.getName(),
                            tarif.getPrice(),
                            tarif.conditions.getInternetGb()));
        }

        // Abonents count
        System.out.println(String.format("\nTotal abonents quantity: %d;", company.getAbonentsCount()));
        // Total company payment
        System.out.println(String.format("\nTotal monthly payment: %d;", company.getTotalMonthPayment()));

        // Ordered tariffs by cost
        Tariff[] tariffsOrd = new Tariff[company.getOrderedTariffsByCost().length];
        tariffsOrd = company.getOrderedTariffsByCost();
        System.out.println("\nCompany tariffs ordered by cost:");
        for (Tariff tarif : tariffsOrd){
            System.out.println(String.format("%s - %.2f;", tarif.getName(), tarif.getPrice()));
        }

        // Filter tariff by internet traffic limits
        Tariff[] tariffsInternetOrd;
        tariffsInternetOrd = company.getTariffByInternetLimit(5, 20);

        System.out.println("\nCompany tariffs filtered by internet traffic:");
        for (Tariff tarif : tariffsInternetOrd){
            System.out.println(String.format("%s - %d;", tarif.getName(), tarif.conditions.getInternetGb()));
        }
    }


    public static Tariff[] setTariffs() {
        Tariff[] tariffsArr = new Tariff[4];
        for (int x = 0; x < tariffsArr.length; x++) {
            tariffsArr[x] = new Tariff(String.format("SuperMax-%d00", x),
                    new Date(2022, Calendar.DECEMBER, 1),
                    new Date(2024, Calendar.DECEMBER, 1),
                    new BigDecimal(100*(x+1)));
            tariffsArr[x].setConditions(
                    (x+1)*100,
                    (x+1)*200,
                    (x+1)*40,
                    (x+1)*10);
        }
        return tariffsArr;
    }

    public static void setCompanyTariffs(Tariff[] tariffs, MobileCompany company){
        for (int x=0; x < tariffs.length; x++){
            company.setTariff(tariffs[x]);
        }
    }

    public static void setUsers(Tariff[] tariffs, MobileCompany company){
        User[] users = new User[200];
        for (int x = 0; x < 200; x++){
            company.setUser(
                    "Kirill",
                    "Keyn",
                    "+38050",
                    String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 9999999)),
                    tariffs[ThreadLocalRandom.current().nextInt(0, tariffs.length-1)]);
        }
    }
}