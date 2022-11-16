package QuanLySinhVien;

public class SinhVien {
	private String maSinhVien;
	private String hoVaTen;
	private Ngay ngaySinh;
	private double diemTB;
	private Lop lop;

	public SinhVien(String maSinhVien, String hoVaTen, Ngay ngaySinh, double diemTB, Lop lop) {
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.diemTB = diemTB;
		this.lop = lop;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public Ngay getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Ngay ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public String layTenKhoa() {
		return this.lop.getTenKhoa();
	}

	public boolean kiemTraThiDat() {
		return this.diemTB >= 5;
	}

	public boolean kiemTraCungNgaySinh(SinhVien s) {
		return this.ngaySinh.equals(s.ngaySinh);
	}
}
