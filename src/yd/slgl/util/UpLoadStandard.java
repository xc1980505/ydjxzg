package yd.slgl.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class UpLoadStandard {
	public static String getFileName(HttpServletRequest request,@RequestParam MultipartFile file) throws IllegalStateException, IOException{
		String realPath = "/home/www/cdn.xqit.net/zg/file";
				/*"D:/ceshi";*/
		
		System.out.println("路径+++++++"+realPath);
		String fileName = new Date().getTime()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		File file1 = new File(realPath,fileName);
		file.transferTo(file1);
		return fileName;
	}
	
	public static void deleteFile(String fullFilePath){
        File deleteFile = new File(fullFilePath);
        deleteFile.delete();
    }
}
