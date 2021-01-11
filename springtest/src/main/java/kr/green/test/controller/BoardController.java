package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.BoardService;
import kr.green.test.service.UserService;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.Uservo;

@Controller	// 컨트롤러가 url패턴 분석할때 @Controller를 먼저 모으고 @RequestMapping의 value를 확인한 후 해당 url을 처리한다.
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)		
	public ModelAndView boardListGet(ModelAndView mv) {
		ArrayList<BoardVo> list = boardService.getBoardList();
		
		mv.addObject("list",list);	// 화면에 추가하는 메소드
		mv.setViewName("/board/list");	
		return mv;
	}
	/* 게시판 상세 */
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)		
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num) {
		BoardVo board = boardService.getBoard(num);
		System.out.println(board);
		mv.addObject("board",board);		// 서버에서 화면으로 데이터 전송 / 화면은 jsp / detail.jsp에서 board 사용 -> 화면에 출력됨
		mv.setViewName("/board/detail");	// detail이라는 jsp를 화면에 보여준다.
		return mv;
	}
	/* 게시글 등록 GET */
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)		
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		
		mv.setViewName("/board/register");	
		return mv;
	}
	/* 게시글 등록 POST */
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)		
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board) {
		boardService.registerBoard(board);
		mv.setViewName("redirect:/board/list");	
		return mv;
	}
	/* 게시글 수정 GET */
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)		
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVo board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");	
		return mv;
	}
	/* 게시글 수정 POST */
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)		
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVo board, HttpServletRequest request) {
		Uservo user = userService.getUser(request);
		boardService.modifyBoard(board,user);
		mv.setViewName("redirect:/board/list");	
		return mv;
	}
	/* 게시글 삭제 GET */
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)		
	public ModelAndView boarddeleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		Uservo user = userService.getUser(request);
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/list");	
		return mv;
	}
}





