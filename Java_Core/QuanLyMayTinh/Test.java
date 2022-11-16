package QuanLyMayTinh;

public class Test {
	public static void main(String[] args) {
		Ngay n1 = new Ngay(1, 1, 2022);
		Ngay n2 = new Ngay(2, 2, 2022);

		QuocGia q1 = new QuocGia("VN", "Viet Nam");
		QuocGia q2 = new QuocGia("USA", "Hoa Ky");

		HangSanXuat h1 = new HangSanXuat("A", q1);
		HangSanXuat h2 = new HangSanXuat("B", q2);

		MayTinh m1 = new MayTinh(h1, n1, 1000, 1);
		MayTinh m2 = new MayTinh(h2, n2, 2000, 2);

		System.out.println("gia ban m1=" + m1.getGiaBan() + " co thap hon m2=" + m2.getGiaBan() + " khong: "
				+ m1.kiemTraGiaThapHon(m2));
		System.out.println("Ten quoc gia m1: " + m1.layTenQuocGia());
		System.out.println("Ten quoc gia m2: " + m2.layTenQuocGia());
	}

}
