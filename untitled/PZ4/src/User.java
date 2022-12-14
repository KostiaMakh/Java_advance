public class User {
    private String firstName;
    private String lastName;
    private String dialCode;
    private String phoneNumber;
    private boolean isActive = true;
    private Tariff tariff;

    public User(String firstNam,
                String lastName,
                String dialCode,
                String phoneNumber,
                Tariff tariff
                ) {
        this.firstName = firstNam;
        this.dialCode = dialCode;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    public Tariff getTariff(){
        return tariff;
    }

    public String getPhoneNumber(){
        return String.format("%s%s", dialCode, phoneNumber);
    }
}

