import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;


public class MobileCompany {
    private String name;
    private String country;
    private int establishment;
    private ArrayList<Tariff> tariffs = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public MobileCompany(String name, int establishment, String country){
        this.name = name;
        this.establishment = establishment;
        this.country = country;
    }

    public ArrayList<Tariff> getTariffs(){
        return tariffs;
    }

    public void setTariff(Tariff tariff){
        if (!checkTariff(tariff)){
            tariffs.add(tariff);
        }
    }

    public void removeTariff(Tariff tariff){
        tariffs.remove(tariff);
    }

    private boolean checkTariff(Tariff tariff){
        return tariffs.contains(tariff);
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public int getEstablishment(){
        return establishment;
    }

    public String getCompanyDetails(){

        return String.format("%s (%s, %d)", name, country, establishment);
    }

    public int getAbonentsCount(){
        return users.size();
    }

    private boolean validatePhoneNumber(String phoneNumber){
        if (phoneNumber.length() != 7){
            System.err.println("Wrong phone number length");
            return false;
        }
        if (!phoneNumber.matches("\\p{Digit}+")){
            System.err.println(phoneNumber + " Wrong phone number. Not numeric format");
            return false;
        }
        return true;
    }

    private boolean checkPhoneNumber(String dialCode,String phoneNumber){
        for( User user : users){
            if (Objects.equals(user.getPhoneNumber(), String.format("%s%s", dialCode, phoneNumber))){
                System.err.println(String.format(
                        "Abonent with phone number %s already exist",
                        user.getPhoneNumber())
                );
                return false;
            }
        }
        return true;
    }

    public void setUser(
            String firstNam,
            String lastName,
            String dialCode,
            String phoneNumber,
            Tariff tariff
    ){
        if(!checkTariff(tariff)){
            System.err.println("Unexpected tariff");
        } else if (validatePhoneNumber(phoneNumber)) {
            if (checkPhoneNumber(dialCode, phoneNumber)){
                User user = new User(
                        firstNam,
                        lastName,
                        dialCode,
                        phoneNumber,
                        tariff
                );
                users.add(user);
            }

        }
    }

    public int getTotalMonthPayment(){
        int total = 0;

        for (User abonent : users){
            total += abonent.getTariff().getPrice();
        }

        return total;
    }

    public Tariff[] getOrderedTariffsByCost(){
        int size = tariffs.size();
        Tariff[] tariff_arr = new Tariff[size];
        for (int i = 0; i < tariffs.size(); i++) {
            tariff_arr[i] = tariffs.get(i);
        }
        int n = tariff_arr.length;
        Tariff temp;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (tariff_arr[j - 1].getPrice() < tariff_arr[j].getPrice()) {
                    temp = tariff_arr[j - 1];
                    tariff_arr[j - 1] = tariff_arr[j];
                    tariff_arr[j] = temp;
                }
            }
        }
        return tariff_arr;
    }

    public Tariff[] getTariffByInternetLimit(int min, int max){
        if (min >= max || min < 0){
            System.err.println("Wrong filter range");
        }
        HashSet<Tariff> result = new HashSet<>();

        for (Tariff tariff : tariffs){
            if (tariff.conditions.getInternetGb() <= max && tariff.conditions.getInternetGb() >= min){
                result.add(tariff);
            }
        }
        Tariff[] tariffArr = {};
        tariffArr = result.toArray(new Tariff[result.size()]);

        return tariffArr;

    }

}
