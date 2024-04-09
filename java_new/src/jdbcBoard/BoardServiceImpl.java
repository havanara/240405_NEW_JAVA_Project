package jdbcBoard;

public class BoardServiceImpl implements Service {
	
	private DAO dao; //interface
	
	//생성자
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	//게시글 등록
	public int register(BoardVO b) {
		System.out.println("Register ServiceImpl Success!");
		return dao.insert(b);
	}

	@Override
	//게시글 검색
	public BoardVO search(int bno) {
		System.out.println("Search SericeImpl Success!");
		return dao.selectOne(bno);
	}

	@Override
	//게시글 수정
	public int modify(BoardVO b) {
		System.out.println("Modify SericeImpl Success!");
		return dao.update(b);
	}

	@Override
	//게시글 삭제
	public int remove(int bno) {
		System.out.println("Remove SericeImpl Success!");
		return dao.delete(bno);
	}

	@Override
	//게시글 목록
	public java.util.List<BoardVO> List() {
		System.out.println("List SericeImpl Success!");
		return dao.selectList();
	}

}
