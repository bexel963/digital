package kr.green.spring.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		ArrayList<BoardVo> list = boardDao.getBoardList(cri);
		return list;
	}

	@Override
	public BoardVo getBoard(Integer num) {
		// 검색할 번호가 없기 때문에 게시글을 가져올 수 없으므로 게시글이 없다는 의미로 null를 반환(리턴)
		if(num == null) {
			return null;
		}
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.registerBoard(board);
	}

	@Override
	public void modifyBoard(BoardVo board, UserVo user) {
		
		if(!user.getId().equals(board.getWriter())) {
			System.out.println("작성자와 아이디가 일치하지 않습니다.");
			return;
		}
		board.setIsDel("N");
		boardDao.modifyBoard(board); 
		
	}

	@Override
	public void deleteBoard(Integer num, UserVo user) {
		if(num == null) {
			return;
		}
		BoardVo board = boardDao.getBoard(num);
		if(user == null || !user.getId().equals(board.getWriter())) {
			System.out.println("작성자와 아이디가 일치하지 않습니다.");
			return;
		}
		board.setIsDel("Y");
		boardDao.modifyBoard(board);
		
	}

	@Override
	public void view(Integer num) {
		if(num == null) {
			return;
		}
		boardDao.updateView(num);
	}

	@Override
	public int getTotalCount() {
		return boardDao.getTotalCount();
	}





	
}
