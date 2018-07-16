package global.sesoc.web4.dao;

import java.util.ArrayList;
import java.util.Map;

import global.sesoc.web4.vo.Board;

/**
 * 방명록 관련 Mybatis 사용 메서드
 */
public interface BoardMapper {
	//글 저장
	public int insert(Board board);
	//전체 글정보 검색
	public ArrayList<Board> select();
	//번호와 비밀번호로 해당 글 삭제 (VO)
	public int delete(Board board);
	//번호와 비밀번호로 해당 글 삭제 (Map)
	public int delete2(Map map);
	//번호와 비밀번호로 해당 글 삭제 (여러 개의 parameter)
	public int delete3(int boardnum, String password);
}
