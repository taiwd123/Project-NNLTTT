package BEAN;

public class ThongKeNam {
	private int thang;
	private double tong;
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public double getTong() {
		return tong;
	}
	public void setTong(double tong) {
		this.tong = tong;
	}
	public ThongKeNam(int thang, double tong) {
		super();
		this.thang = thang;
		this.tong = tong;
	}
	
}
