import java.math.BigDecimal;
import java.util.Date;

public class Tariff {
    private int id;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private BigDecimal price;
    public Conditions conditions;

    public Tariff(String name,
                  Date dateFrom,
                  Date dateTo,
                  BigDecimal price) {
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
    }

    public class Conditions {
        private int innerNetworkCallsMinutes;
        private int externalNetworkCallsMinutes;
        private int smsPcs;
        private int internetGb;

        public Conditions(int innerNetworkCallsMinutes,
                          int externalNetworkCallsMinutes,
                          int smsPcs,
                          int internetGb) {
            this.externalNetworkCallsMinutes = externalNetworkCallsMinutes;
            this.smsPcs = smsPcs;
            this.innerNetworkCallsMinutes = innerNetworkCallsMinutes;
            this.internetGb = internetGb;
        }

        public int getInnerNetworkCallsMinutes(){
            return innerNetworkCallsMinutes;
        }

        public int getInternetGb(){
            return internetGb;
        }
    }

    public void setConditions(int innerNetworkCallsMinutes,
                              int external_network_calls_minutes,
                              int smsPcs,
                              int internetGb) {
        conditions = new Conditions(innerNetworkCallsMinutes,
                external_network_calls_minutes,
                smsPcs,
                internetGb);
    }

    public String getName() {
        return name;
    }

    public Double getPrice(){
        return price.doubleValue();
    }
    
    public String getDateFromStr(){
        return String.format("%d-%d-%d", dateFrom.getYear(), dateFrom.getMonth(), dateFrom.getDay());
    }

    public String getDateToStr(){
        return String.format("%d-%d-%d", dateTo.getYear(), dateTo.getMonth(), dateTo.getDay());
    }

    public Date getDateTo(){
        return dateTo;
    }

}
