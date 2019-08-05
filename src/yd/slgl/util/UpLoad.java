package yd.slgl.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class UpLoad {
	public static String getFileName(HttpServletRequest request,@RequestParam MultipartFile photo) throws IllegalStateException, IOException{
		String realPath =request.getSession().getServletContext().getRealPath("/WEB-INF/file");
		String fileName = new Date().getTime()+photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
		File file = new File(realPath,fileName);
		photo.transferTo(file);
		return fileName;
	}
}
