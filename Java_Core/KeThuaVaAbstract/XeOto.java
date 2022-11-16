package KeThuaVaAbstract;

public class XeOto extends PhuongTienDiChuyen {
	private String loaiNhienLieu;

	public XeOto(String loaiPhuongTien, HangSanXuat hangSanXuat, String loaiNhienLieu) {
		super(loaiPhuongTien, hangSanXuat);
		this.loaiNhienLieu = loaiNhienLieu;
	}

	public String getLoaiNhienLieu() {
		return loaiNhienLieu;
	}

	public void setLoaiNhienLieu(String loaiNhienLieu) {
		this.loaiNhienLieu = loaiNhienLieu;
	}

	@Override
	public double layVanToc() {
		return 100;
	}

}
