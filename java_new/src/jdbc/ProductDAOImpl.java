package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class ProductDAOImpl implements DAO{
	
	//DB연결
	private Connection conn;
	
	//sql 구분을 실행시키는 기능하는 객체
	private PreparedStatement pst;
	
	//쿼리 구문 저장 스트링
	private String query="";
	
	public ProductDAOImpl() {
		//DBConnection class 생성(싱글톤)
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getcConnection();
	}
	
	//sql 구문 처리
	@Override
	public int insert(ProductVO p) {
		System.out.println("Insert DAOImpl Success!");
		query = "insert into product(pname,price,madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			//insert, update, delete -> executeUpdate() return int(처리된 개수로 리턴)
			
			//만들어진 pst에서 실행하고 처리해줌
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Insert Error!");
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<ProductVO> selectList() {
		System.out.println("List DAOImpl Success!");
		query = "select * from product order by pno desc";
		List<ProductVO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			//list -> executeQuery(); -> return ResultSet
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("List error!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		System.out.println("SelectOne DAOImple Success!");
		query = "select * from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new ProductVO(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby")
						);
			}
		} catch (SQLException e) {
			System.out.println("Detail Error!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(ProductVO p) {
		System.out.println("Update DAOImpl Success!");
		query = "update product set pname=?, price=?, madeby=?, regdate=now() where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update Error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int pno) {
		System.out.println("Delete DAOImpl Success!");
		query = "delete from product where pno=?"; //delete는 *(all)이 없음
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete Error!");
			e.printStackTrace();
		}
		return 0;
	}
		
}
