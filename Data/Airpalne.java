package Data;

import java.util.Date;

public class Airpalne {
    private int id;
    private String airplaneName;
    private Date departureTime;
    private Date startDestination;
    private Date endDestination;

    public Airpalne(int id, String airplaneName, Date departureTime, Date startDestination, Date endDestination) {
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

    public Date getStartDestination() {
        return startDestination;
    }

    public Date getEndDestination() {
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
