

public class Order {

    private long orderNumber;
    private String date;
    private String time;
    private EntertainmentEvent event;


    public Order(String date, String time, EntertainmentEvent event) {
        this.date = date;
        this.time = time;
        this.event = event;
        this.orderNumber = 0;
    }

    public Ticket getTicket() {
        return null;
    }


}
