package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList(@Param("cri")Criteria cri);

	BoardVo getBoard(@Param("num")Integer num);

	void registerBoard(@Param("board")BoardVo board);

	void modifyBoard(@Param("board")BoardVo board);

	void updateView(@Param("num")Integer num);

	int getTotalCount();

	
}
