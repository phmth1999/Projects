package QuanLySach;

public class Test {
	public static void main(String[] args) {
		Ngay n1 = new Ngay(1, 1, 2022);
		Ngay n2 = new Ngay(2, 2, 2022);

		TacGia t1 = new TacGia("Nguyen Van A", n1);
		TacGia t2 = new TacGia("Nguyen Van B", n2);

		Sach s1 = new Sach("Book 1", 1000, 2022, t1);
		Sach s2 = new Sach("Book 2", 2000, 2022, t2);
		
		s1.inTenSach();
		s2.inTenSach();
		
		System.out.println("so sanh nam xuat ban sach1 va sach2: "+s1.kiemTraCungNamXuatBan(s2));
		System.out.println("gia sau khi giam 10%: "+s1.giaSauKhiGiam(10));
		System.out.println("gia sau khi giam 50%: "+s2.giaSauKhiGiam(50));
	}
}
