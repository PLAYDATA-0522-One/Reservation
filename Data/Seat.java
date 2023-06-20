package Data;

public class Seat {
    // 좌석 이름 ,
    private String seatName;

    public Seat(String seatName) {
        this.seatName = seatName;
    }

    public String getSeatName() {
        return seatName;
    }

    @Override
    public String toString() {
        return seatName;
    }
}
