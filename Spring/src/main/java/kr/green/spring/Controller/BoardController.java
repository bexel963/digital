package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.UserService;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	
	/* 게시글 리시트 */
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)		
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri) {
		System.out.println("현재 페이지 정보 : " + cri);
		ArrayList<BoardVo> list = boardService.getBoardList(cri);	// cri페이지에 해당하는 정보를 가져오는 메소드
		int totalCount = boardService.getTotalCount();
		
		PageMaker pm = new PageMaker(cri, 2, totalCount);
		
		System.out.println("페이지메이커 : " + pm);
		
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/board/list");	
		return mv;
	}
	
	/* 게시글 상세 */
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)		
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num) {
		System.out.println("화면에서 받은 번호 : " + num);
		boardService.view(num);		//해당 게시글의 조회수를 증가
		BoardVo board = boardService.getBoard(num);
		System.out.println("검색된 게시글 :" + board);
		mv.addObject("board", board);	
		mv.setViewName("/board/detail");
		return mv;
	}
	
	/* 게시글 등록 */
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)		
	public ModelAndView boardRegisterGet(ModelAndView mv, BoardVo board) {
		
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)		
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board) {
		boardService.registerBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	/* 게시글 수정 */
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)		
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		System.out.println("수정할 번호 : " + num);
		BoardVo board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)		
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVo board, HttpServletRequest request ) {
		UserVo user = userService.getUser(request);		// HttpServletRequest의 세션 안에있는 회원정보를 가져옴
		System.out.println("회원정보 : " + user);
		System.out.println("게시글 정보 : " + board);
		boardService.modifyBoard(board, user);
		mv.setViewName("redirect:/board/list");		// board/list로 이동
		return mv;
	}
	
	/* 게시글 삭제 */
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)		
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		System.out.println("삭제할 번호 : " + num);
		UserVo user = userService.getUser(request);
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
}
