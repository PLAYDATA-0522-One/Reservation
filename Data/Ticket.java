package Data;

import java.util.Date;

public class Ticket {
    private int ticketNumber;
    private String userID;
    private String airplaneName;
    private Date departureTime;
    private Date startDestination;
    private Date endDestination;

    public Ticket(int ticketNumber, String userID, String airplaneName, Date departureTime, Date startDestination, Date endDestination) {
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

    public Date getStartDestination() {
        return startDestination;
    }

    public Date getEndDestination() {
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
