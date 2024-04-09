package jdbcBoard;

public class BoardVO {
	private int bno; //자동생성 게시글넘버
	private String title; //제목
	private String writer; //작성자
	private String content; //내용
	private String regdate; //작성일
	private String moddate;
	
	//생성자
	public BoardVO() {}
	
	//게시글 등록
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	//게시글 검색
	public BoardVO(int bno, String title, String content, String writer) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	//게시글 수정
	public BoardVO(int bno, String title, String writer, String content, String moddate) {
		this(bno,title,content,writer);
		this.moddate = moddate;
	}
	
	//게시글 삭제
	
	//게시글 목록(전부)
	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate) {
		this(bno,title,content,writer);
		this.regdate = regdate;
		this.moddate = moddate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + "]";
	}
	
	public String print() {
		return bno + ". title : " + title + " / content : " + content + " / " + writer + "(" + regdate + "/" + moddate+ ")";
	}

}
