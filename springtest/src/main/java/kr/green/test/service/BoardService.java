package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.LikeVo;
import kr.green.test.vo.Uservo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(BoardVo board, Uservo user);

	void deleteBoard(Integer num, Uservo user);

	void updateView(Integer num);

	int getTotalCount(Criteria cri);

	void registerFile(int num, String originalFilename, String fileName);

	ArrayList<FileVo> getFileList(Integer num);

	void deleteFile(int num);

	void like(LikeVo likeVo);

	LikeVo getLike(Integer num, Uservo user);
	
	
}
