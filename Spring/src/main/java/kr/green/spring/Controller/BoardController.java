package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.UserService;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.FileVo;
import kr.green.spring.vo.LikeVo;
import kr.green.spring.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	
	private String uploadPath = "D:\\digit\\a\\upload";
	
	/* 게시글 리시트 */
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)		
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri) {
		System.out.println("현재 페이지 정보 : " + cri);
		ArrayList<BoardVo> list = boardService.getBoardList(cri);	// cri페이지에 해당하는 정보를 가져오는 메소드
		int totalCount = boardService.getTotalCount(cri);	//***
		
		PageMaker pm = new PageMaker(cri, 2, totalCount);
		
		System.out.println("페이지메이커 : " + pm);
		
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/board/list");	
		return mv;
	}
	
	/* 게시글 상세 */
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)		
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num, Criteria cri, HttpServletRequest request) {
		System.out.println("화면에서 받은 번호 : " + num);
		boardService.view(num);		//해당 게시글의 조회수를 증가
		BoardVo board = boardService.getBoard(num);
		System.out.println("검색된 게시글 :" + board);
		ArrayList<FileVo> fList = boardService.getFileList(num);
		
		UserVo user = userService.getUser(request);
		LikeVo like = boardService.getLike(num, user);
		
		mv.addObject("like",like);
		mv.addObject("fList", fList);
		mv.addObject("board", board);
		mv.addObject("cri", cri);
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
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, MultipartFile[] fileList) throws IOException, Exception {
		boardService.registerBoard(board);

		System.out.println(fileList.length);
		
		if(fileList != null){
			for(MultipartFile file : fileList) {
				if(file != null && file.getOriginalFilename().length() != 0) {
					String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					boardService.registerFile(board.getNum(), file.getOriginalFilename(), fileName);
				}
			}
		}

		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	/* 게시글 수정 */
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)		
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		System.out.println("수정할 번호 : " + num);
		BoardVo board = boardService.getBoard(num);
		ArrayList<FileVo> fList = boardService.getFileList(num);
		mv.addObject("fList", fList);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)		
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVo board, HttpServletRequest request, MultipartFile[] fileList ) throws IOException, Exception {
		UserVo user = userService.getUser(request);		// HttpServletRequest의 세션 안에있는 회원정보를 가져옴
		System.out.println("회원정보 : " + user);
		System.out.println("게시글 정보 : " + board);
		boardService.modifyBoard(board, user);
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
	
	/* 다운로드 */
	@ResponseBody
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();	// post로 전송한 데이터가 hearder에 실려옴
	        in = new FileInputStream(uploadPath+fileName);	// uploadPath에 fileName을 추가해서 해당하는 파일을 가져옴 (실제 파일을 복사해서 in에 담아줌)

	        fileName = fileName.substring(fileName.indexOf("_")+1);	// _다음 위치부터 파일명을 가져옴
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);	// hearders의 멤버변수 값 설정
	        headers.add("Content-Disposition",  "attachment; filename=\"" 	// headers에 정보를 추가 ( filename이라는 정보를 headers에 추가
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);	// 1byte 배열 만들어서 in이라는파일 배열 여러개를 객체로 만들어서 entity에 저장
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	    	
	        in.close();
	    }
	    return entity;	// 해당 화면에서는 entity를 받아서 다운로드
	}
	
	/* like기능 */
	@RequestMapping(value = "/board/like", method = RequestMethod.POST)		
	@ResponseBody
	// 리턴타입을 Object로 하면 아무거다 다 리턴 할수있다.
	public Object authorModifyPost(@RequestBody LikeVo likeVo) {
		System.out.println("/board/like : " + likeVo);
		boardService.like(likeVo);
		HashMap<String, Object> map = new HashMap<String, Object>();	// json형태로 보내준다는 말은 map으로 보내주는거다.
		return map;
	}
	
}
