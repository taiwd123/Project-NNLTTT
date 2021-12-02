package BEAN;

public class ThongKeThang{
	private int ngay;
	private double tong;
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public double getTong() {
		return tong;
	}
	public void setTong(double tong) {
		this.tong = tong;
	}
	public ThongKeThang(int ngay, double tong) {
		super();
		this.ngay = ngay;
		this.tong = tong;
	}
	
}
