package jdbcBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements DAO {

	//DB연결
	private Connection conn;
	
	//sql 구분을 실행시키는 기능하는 객체
	private PreparedStatement bst;
	
	//쿼리 구문 저장 스트링
	private String query="";
	
	public BoardDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	@Override
	//게시글 등록
	public int insert(BoardVO b) {
		System.out.println("Insert DAOImpl Success!");
//		String title, String writer, String content
		query = "insert into board(title,writer,content) values(?,?,?)";
		try {
			bst = conn.prepareStatement(query);
			bst.setString(1, b.getTitle());
			bst.setString(2, b.getWriter());
			bst.setString(3, b.getContent());
			//insert, update, delete -> executeUpdate() return int(처리된 개수로 리턴)
			//만들어진 bst에서 실행하고 처리해줌
			return bst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Insert Error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	//게시글 검색
	public BoardVO selectOne(int bno) {
		System.out.println("selectOne DAOImpl Success!");
//		int bno, String title, String content, String writer
		query = "select * from board where bno=?";
		try {
			bst = conn.prepareStatement(query);
			bst.setInt(1, bno);
			ResultSet rs = bst.executeQuery();
			if(rs.next()) {
				return new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer")
						);
			}
		} catch (SQLException e) {
			System.out.println("Detail Error!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	//게시글 수정
	public int update(BoardVO b) {
		System.out.println("Update DAOImpl Success!");
//		int bno, String title, String writer, String content, String moddate
		query = "update board set title=?, writer=?, content=?, moddate=now() where bno=?";
		try {
			bst = conn.prepareCall(query);
			bst.setString(1, b.getTitle());
			bst.setString(2, b.getWriter());
			bst.setString(3, b.getContent());
			bst.setInt(4, b.getBno());
			return bst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update Error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	//게시글 삭제
	public int delete(int bno) {
		System.out.println("Delete DAOImpl Success!");
		query = "delete from board where bno=?";
		try {
			bst = conn.prepareStatement(query);
			bst.setInt(1, bno);
			return bst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete Error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	//게시글 목록
//	int bno, String title, String writer, String content, String regdate, String moddate
	public List<BoardVO> selectList() {
		System.out.println("List DAOImpl Success!");
		query = "select * from board order by bno desc";
		List<BoardVO> list = new ArrayList<>();
		try {
			bst = conn.prepareStatement(query);
			ResultSet rs = bst.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("List error!");
			e.printStackTrace();
		}
		return null;
	}

}