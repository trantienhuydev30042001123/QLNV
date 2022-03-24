package model;

public class nhanvien {
	private String MANV;
	private String TENNV;
	private int GIOITINH;
	private float LUONG;
	private String NGAYSINH;
	private String DIACHI;
	private String MAPB;
	public nhanvien() {
	}
	public nhanvien(String mANV, String tENNV, int gIOITINH, float lUONG, String nGAYSINH, String dIACHI, String mAPB) {
		MANV = mANV;
		TENNV = tENNV;
		GIOITINH = gIOITINH;
		LUONG = lUONG;
		NGAYSINH = nGAYSINH;
		DIACHI = dIACHI;
		MAPB = mAPB;
	}
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public String getTENNV() {
		return TENNV;
	}
	public void setTENNV(String tENNV) {
		TENNV = tENNV;
	}
	public int getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(int gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public float getLUONG() {
		return LUONG;
	}
	public void setLUONG(float lUONG) {
		LUONG = lUONG;
	}
	public String getNGAYSINH() {
		return NGAYSINH;
	}
	public void setNGAYSINH(String nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public String getMAPB() {
		return MAPB;
	}
	public void setMAPB(String mAPB) {
		MAPB = mAPB;
	}
	

}
