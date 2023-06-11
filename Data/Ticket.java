package Data;

import java.util.Date;

public class Ticket {
    private int ticketNumber;
    private String userID;
    private String airplaneName;
    private Date departureTime;
    private String startDestination;
    private String endDestination;

    public Ticket(int ticketNumber, String userID, String airplaneName, Date departureTime, String startDestination, String endDestination) {
        this.ticketNumber = ticketNumber;
        this.userID = userID;
        this.airplaneName = airplaneName;
        this.departureTime = departureTime;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getUserID() {
        return userID;
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
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", userID='" + userID + '\'' +
                ", airplaneName='" + airplaneName + '\'' +
                ", departureTime=" + departureTime +
                ", startDestination=" + startDestination +
                ", endDestination=" + endDestination +
                '}';
    }
}
