package Data;

import java.util.Date;

public class Ticket {
    //티켓번호 primry key
    private int ticketNumber;
    //예약한 user id
    private String userID;
    //비행기 이름
    private String airplaneName;
    //출발시간
    private Date departureTime;
    //줄발지
    private String startDestination;
    //도착지
    private String endDestination;

    private String seat;

    public Ticket(int ticketNumber, String userID, String airplaneName, Date departureTime, String startDestination, String endDestination, String seat) {
        this.ticketNumber = ticketNumber;
        this.userID = userID;
        this.airplaneName = airplaneName;
        this.departureTime = departureTime;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.seat = seat;
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

    public String getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", userID='" + userID + '\'' +
                ", airplaneName='" + airplaneName + '\'' +
                ", departureTime=" + departureTime +
                ", startDestination='" + startDestination + '\'' +
                ", endDestination='" + endDestination + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
