package net.codejava.spring;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/uploadFile.do")
public class FileUploadController {
	
	private String saveDirectory = "E:/Test/Upload/";
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request, 
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
		
		System.out.println("description: " + request.getParameter("description"));
		
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload){
				
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}

		// returns to the view "Result"
		return "Result";
	}
}