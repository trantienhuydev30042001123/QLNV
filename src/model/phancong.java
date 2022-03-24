package model;

public class phancong {
	private String MANV;
	private String MADA;
	private int SOGIO;
	public phancong() {
	}
	public phancong(String mANV, String mADA, int sOGIO) {
		MANV = mANV;
		MADA = mADA;
		SOGIO = sOGIO;
	}
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public String getMADA() {
		return MADA;
	}
	public void setMADA(String mADA) {
		MADA = mADA;
	}
	public int getSOGIO() {
		return SOGIO;
	}
	public void setSOGIO(int sOGIO) {
		SOGIO = sOGIO;
	}

}
