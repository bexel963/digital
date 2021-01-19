package kr.green.test.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.UserService;
import kr.green.test.utils.UploadFileUtils;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.Uservo;

@Controller	// 컨트롤러가 url패턴 분석할때 @Controller를 먼저 모으고 @RequestMapping의 value를 확인한 후 해당 url을 처리한다.
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	String uploadPath = "D:\\digit\\a\\upfile";
	
	/* 게시글 리스트*/
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)		
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri) {	// Criteria cri : 현재 페이지 정보를 화면에서 전달 받아옴(매개변수) header.jsp화면에서 게시판 탭을 클릭하면 cri라는 매개변수로 정보가 넘어가는데 정보값을 아무것도 입력 안 하면 Criteria클래스의 기본생성자가 자동으로 호출되어 정보가 생성된다.
		ArrayList<BoardVo> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		System.out.println("총 개수 : " + totalCount);
		int displayPageNum = 3;
		PageMaker pm = new PageMaker(totalCount, displayPageNum, cri);
		System.out.println("페이지메이커 : " + pm);
		
		mv.addObject("pm",pm);
		mv.addObject("list",list);	
		mv.setViewName("/board/list");	
		return mv;
	}
	/* 게시글 상세 */
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)		
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num, Criteria cri) {
		boardService.updateView(num);
		BoardVo board = boardService.getBoard(num);
		ArrayList<FileVo> fileList = boardService.getFileList(num);
		System.out.println(board);
		System.out.println(fileList);
		
		mv.addObject("fileList",fileList);
		mv.addObject("cri",cri);
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
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, MultipartFile[] fileList)throws IOException, Exception {
		boardService.registerBoard(board);
		System.out.println(board);
		//첨부파일 배열에 첨부파일이 있으면
		if(fileList != null && fileList.length != 0) {
			//화면에서 넘어온 파일이 있고, 파일명이 0글자가 아닐때
			for(MultipartFile file : fileList) {			
				if(file != null && file.getOriginalFilename().length() != 0) {
					String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					System.out.println("파일명 : " + fileName);
					boardService.registerFile(board.getNum(), file.getOriginalFilename(), fileName);
					System.out.println(file);
				}
			}
		}
		mv.setViewName("redirect:/board/list");	
		return mv;
	}
	/* 게시글 수정 GET */
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)		
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVo board = boardService.getBoard(num);
		ArrayList<FileVo> fileList = boardService.getFileList(num);
		mv.addObject("fileList",fileList);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");	
		return mv;
	}
	/* 게시글 수정 POST */
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)		
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVo board, HttpServletRequest request, MultipartFile[] fileList) throws IOException, Exception{
		Uservo user = userService.getUser(request);
		boardService.modifyBoard(board,user);
		//기존 첨부파일 삭제
		boardService.deleteFile(board.getNum());
		//새 첨부파일 업로드 및 DB추가
		if(fileList != null){
			System.out.println("수정될 첨부패일 개수 : " + fileList.length);
			for(MultipartFile file : fileList) {
				if(file != null && file.getOriginalFilename().length() != 0) {
					String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					System.out.println("추가된 파일명 :" + fileName);
					boardService.registerFile(board.getNum(), file.getOriginalFilename(), fileName);
				}
			}
		}
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
	
	@ResponseBody
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String filename)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+filename);

	        filename = filename.substring(filename.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(filename.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
}





