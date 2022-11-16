package QuanLySinhVien;

public class Test {
	public static void main(String[] args) {
		Ngay n1 = new Ngay(1, 1, 2022);
		Ngay n2 = new Ngay(1, 1, 2022);

		Lop l1 = new Lop("DH1", "Cong nghe thong tin");
		Lop l2 = new Lop("DH2", "Khoa an ninh mang");

		SinhVien s1 = new SinhVien("001", "Nguyen Van A", n1, 9, l1);
		SinhVien s2 = new SinhVien("002", "Nguyen Van B", n2, 1, l2);

		System.out.println(s1.layTenKhoa());
		System.out.println(s2.layTenKhoa());
		System.out.println("Kiem tra thi dat s1=" + s1.getDiemTB() + " : " + s1.kiemTraThiDat());
		System.out.println("Kiem tra thi dat s2=" + s2.getDiemTB() + " : " + s2.kiemTraThiDat());
		System.out.println("s1 co trung ngay sinh s2 khong: " + s1.kiemTraCungNgaySinh(s2));
	}
}
