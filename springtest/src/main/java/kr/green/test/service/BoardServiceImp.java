package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDao;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.Uservo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList() {
		//ArrayList<BoardVo> list = boardDao.getBoardList();
		//return list;
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo getBoard(Integer num) {
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(BoardVo board, Uservo user) {
		// 게시글 번호로 원본 게시글 정보를 가져옴
		BoardVo oriBoard = boardDao.getBoard(board.getNum());
		// 원본 게시글 정보를 수정된 제목과 내용으로 바꿈
		oriBoard.setTitle(board.getTitle());
		oriBoard.setContent(board.getContent());
		// 비회원 이거나 작성자와 로그인한 유저가 같지 않으면 수정하지 않음
		if(user == null || !user.getId().equals(oriBoard.getWriter())) {
			return;
		}
		// 수정된 게시글을 DB에 업데이트
		boardDao.updateBoard(oriBoard);
	}

	@Override
	public void deleteBoard(Integer num, Uservo user) {
		BoardVo board = boardDao.getBoard(num);
		if(user == null || !user.getId().equals(board.getWriter())) {
			return;
		}
		board.setIsDel("Y");
		boardDao.updateBoard(board);
	}
	
	
	
	
	
	
	
	
}
