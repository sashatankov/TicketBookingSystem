import java.util.ArrayList;
import java.util.List;

public class Auditorium {

    private List<List<Boolean>> seats;
    private long auditoriumNumber;
    public Auditorium(long auditoriumNumber, int rows, int seatsInRow) {

        this.auditoriumNumber = auditoriumNumber;
        this.seats = new ArrayList<>();

        for(int i = 0; i < rows; ++i) {
            this.seats.add(new ArrayList<>());
            for(int j = 0; j < seatsInRow; ++j) {
                this.seats.get(i).add(false);
            }
        }

    }

    public Auditorium(long auditoriumNumber, int[] seatsInRows) {

        this.auditoriumNumber = auditoriumNumber;
        this.seats = new ArrayList<>();

        for(int i = 0; i < seatsInRows.length; ++i) {
            this.seats.add(new ArrayList<>());
            for(int j = 0; j < seatsInRows[i]; ++j) {
                this.seats.get(i).add(false);
            }
        }
    }

    public int numberOfSeats() {

        int sum = 0;
        for(List<Boolean> row: seats)
            sum += row.size();
        return sum;

    }

    public boolean isSeatEmpty(int row, int seatInRow) {
        if(row <= this.seats.size() && seatInRow <= this.seats.get(row).size()) {
            return !this.seats.get(row).get(seatInRow);
        }
        return false;

    }

    public void bookSeat(int row, int seatInRow) {
        if(row <= this.seats.size() && seatInRow <= this.seats.get(row).size()) {
            this.seats.get(row - 1).remove(seatInRow - 1);
            this.seats.get(row - 1).add(seatInRow - 1, true);
        }

    }

    public long getAuditoriumnumber(){
        return this.auditoriumNumber;
    }



}
