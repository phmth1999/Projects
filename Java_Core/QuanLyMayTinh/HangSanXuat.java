package QuanLyMayTinh;

public class HangSanXuat {
	private String tenHAngSanXuat;
	private QuocGia quocGia;

	public HangSanXuat(String tenHAngSanXuat, QuocGia quocGia) {
		this.tenHAngSanXuat = tenHAngSanXuat;
		this.quocGia = quocGia;
	}

	public String getTenHAngSanXuat() {
		return tenHAngSanXuat;
	}

	public void setTenHAngSanXuat(String tenHAngSanXuat) {
		this.tenHAngSanXuat = tenHAngSanXuat;
	}

	public QuocGia getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(QuocGia quocGia) {
		this.quocGia = quocGia;
	}

	public String layTenQuocGia() {
		return this.quocGia.getTenQuocGia();
	}
}
