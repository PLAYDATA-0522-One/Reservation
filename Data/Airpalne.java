package Data;

import java.sql.Date;

public class Airpalne {
    private int id;
    private String airplaneName;
    private Date departureTime;
    private String startDestination;
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
