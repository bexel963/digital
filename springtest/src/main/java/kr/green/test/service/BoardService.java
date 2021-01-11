package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.vo.BoardVo;
import kr.green.test.vo.Uservo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(BoardVo board, Uservo user);

	void deleteBoard(Integer num, Uservo user);
	
	
}
