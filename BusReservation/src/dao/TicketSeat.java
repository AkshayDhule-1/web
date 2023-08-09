package dao;

public class TicketSeat {
	private int id;
	private int tid;
	private int seatNumber;
	
	public TicketSeat() {
		
	}
	TicketSeat(int id, int tid, int seatNumber) {
		super();
		this.id = id;
		this.tid = tid;
		this.seatNumber = seatNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "TicketSeat [id=" + id + ", tid=" + tid + ", seatNumber=" + seatNumber + "]";
	}
	
	
}
