package Data;

import java.sql.Date;

public class Airpalne {
    //primry key
    private int id;
    //비행기 이름
    private String airplaneName;
    //출발시간
    private Date departureTime;
    //출발지
    private String startDestination;
    //도착지
    private String endDestination;

    public Airpalne(int id, String airplaneName, Date departureTime, String startDestination, String endDestination) {
        this.id = id;
        this.airplaneName = airplaneName;
        this.departureTime = departureTime;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
    }

    public int getId() {
        return id;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public String getEndDestination() {
        return endDestination;
    }

    @Override
    public String toString() {
        return "Airpalne{" +
                "airplaneName='" + airplaneName + '\'' +
                ", departureTime=" + departureTime +
                ", startDestination=" + startDestination +
                ", endDestination=" + endDestination +
                '}';
    }
}
