import java.util.*;
// TODO an abstraction/interface of <EventVenue>?
/**
 * a Class representing a seating in am auditorium for a
 * particular event.
 */
public class Auditorium implements EventVenue {

    private List<List<Boolean>> seats;
    private long auditoriumNumber;
    public static Set<Long> auditoriumNumbers = new HashSet<>();

    /**
     * A Constructor of the class that build an empty seating
     * in a particular auditorium. This constructor assumes that
     * all rows in the auditorium have the same number of seats
     *
     * @param auditoriumNumber an id of a particular auditorium
     * @param rows the number of rows in the auditorium
     * @param seatsInRow a number of seats in each row
     */
    public Auditorium(long auditoriumNumber, int rows, int seatsInRow) {

        auditoriumNumbers.add(auditoriumNumber);
        this.auditoriumNumber = auditoriumNumber;
        this.seats = new ArrayList<>();

        for(int i = 0; i < rows; ++i) {
            this.seats.add(new ArrayList<>());
            for(int j = 0; j < seatsInRow; ++j) {
                this.seats.get(i).add(false);
            }
        }

    }

    /**
     * a Constrouctor of the class that builds an empty seating
     * in a particular auditorium. This constructor is for auditoriums
     * where all rows do not have the same number of seats.
     * @param auditoriumNumber an id of a particular auditorium
     * @param seatsInRows an array on integer, the size of the array
     *                    is the number of rows. Each element of the
     *                    array represents the number of seats in that row.
     */
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

    /**
     *
     * @return the number of seats in the auditorium
     */
    @Override
    public long capacity() {

        int sum = 0;
        for(List<Boolean> row: seats)
            sum += row.size();
        return sum;

    }

    /**
     * check if a particular seat is empty in a seating
     * @param row row number
     * @param seatInRow number of seat in the row
     * @return true, if the seat is empty. false, otherwise
     */
    public boolean isSeatEmpty(int row, int seatInRow) {
        if(row <= this.seats.size() && seatInRow <= this.seats.get(row).size()) {
            return !this.seats.get(row).get(seatInRow);
        }
        return false;

    }

    /**
     * reserves a seat in an auditorium, by marking it as occupied
     * @param row row number
     * @param seatInRow number of seat in a row
     */
    public void bookSeat(int row, int seatInRow) {
        if(row <= this.seats.size() && seatInRow <= this.seats.get(row).size()) {
            this.seats.get(row - 1).remove(seatInRow - 1);
            this.seats.get(row - 1).add(seatInRow - 1, true);
        }

    }

    /**
     *
     * @return the id of the auditorium
     */
    @Override
    public long getId(){
        return this.auditoriumNumber;
    }

    /**
     *
     * @return all ids of the auditoriums
     */
    public static Set<Long> getAllAuditoriumNumbers(){
        return auditoriumNumbers;
    }

    /**
     *
     * @return the name of the auditorium
     */
    @Override
    public String getName() {
        return "Auditorium " + this.getId();
    }



}
