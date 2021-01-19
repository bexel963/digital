package kr.green.test.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	//파일을 업로드하는 메소드
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);							// savedPath(datePath) => \2021\01\12			         
		File target = new File(uploadPath + savedPath, savedName);			// uploadPath		   => C:\Users\Administrator\Downloads\\upload  
		FileCopyUtils.copy(fileData, target);								// savedName		   => 62ae8ee1-ce01-4067-99b6-6bd321efa540_기본작업-1.xlsx
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);	// uploadFileName	   => C:/Users/Administrator/Downloads/upload/2021/01/12/62ae8ee1-ce01-4067-99b6-6bd321efa540_기본작업-1.xlsx	
		return uploadFileName;
	}
	//업로드한 파일을 저장할 경로를 계산하는 메소드
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();	// 현재 날짜 구하기
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);	// File.separator는 파일간의 구분자 (윈도우는 \)
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);	// DecimalFormat("00")는 10진수를 두자리로 맞춤, get(Calendar.MONTH)는 0~11
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}
	//폴더를 생성하는 메소드
	private static void makeDir(String uploadPath, String... paths) {
		if(new File(uploadPath + paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName)throws Exception{
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');	// 역슬래쉬를 슬래쉬로 교체
	}

}
