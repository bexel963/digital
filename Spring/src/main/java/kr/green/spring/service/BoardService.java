package kr.green.spring.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.FileVo;
import kr.green.spring.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(BoardVo board, UserVo user);

	void deleteBoard(Integer num, UserVo user);

	void view(Integer num);

	int getTotalCount(Criteria cri);

	void registerFile(int num, String originalFilename, String fileName);

	ArrayList<FileVo> getFileList(Integer num);

}
