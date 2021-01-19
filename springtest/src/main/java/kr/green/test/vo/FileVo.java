package kr.green.test.vo;

public class FileVo {
	private int num;		// 기본키
	private int boardNum;	// 외래키
	private String oriFilename;
	private String filename;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getOriFilename() {
		return oriFilename;
	}
	public void setOriFilename(String oriFilename) {
		this.oriFilename = oriFilename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "FileVo [num=" + num + ", boardNum=" + boardNum + ", oriFilename=" + oriFilename + ", filename="
				+ filename + "]";
	}
	
}
