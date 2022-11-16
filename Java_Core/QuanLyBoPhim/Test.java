package QuanLyBoPhim;

public class Test {
	public static void main(String[] args) {
		Ngay n1 = new Ngay(1, 1, 2022);
		Ngay n2 = new Ngay(2, 2, 2022);

		HangSanXuat h1 = new HangSanXuat("A", "VietNam");
		HangSanXuat h2 = new HangSanXuat("B", "VietNam");

		BoPhim b1 = new BoPhim("Vua su tu", 2022, h1, 1000, n1);
		BoPhim b2 = new BoPhim("Hai tac", 2022, h2, 2000, n2);

		System.out.println("Kiem tra gia ve b1=" + b1.getGiaVe() + " re hon b2=" + b2.getGiaVe() + " : "
				+ b1.kiemTraGiaVeReHon(b2));

		System.out.println("Ten hang san xuat cua b1 la: " + b1.layTenHangSanXuat());
		System.out.println("Ten hang san xuat cua b2 la: " + b2.layTenHangSanXuat());
		
		System.out.println("b1 giam 10%: "+b1.giaSauKhuyenMai(10));
		System.out.println("b2 giam 50%: "+b2.giaSauKhuyenMai(50));
	}
}
