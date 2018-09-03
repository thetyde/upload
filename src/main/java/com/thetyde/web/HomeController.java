package com.thetyde.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thetyde.utils.FileUtil;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "upload";
	}

	@PostMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException {
		model.addAttribute("contentType", file.getContentType());
		model.addAttribute("name", file.getName());
		model.addAttribute("originalFilename", file.getOriginalFilename());
		model.addAttribute("size", file.getSize());
		String path = request.getSession().getServletContext().getRealPath("upload/");
		FileUtil.uploadFile(file.getBytes(), path, file.getOriginalFilename());
		System.out.println("upload path : " + path);
		File file1 = new File(".");
		System.out.println("实际地址 : " + file1.getAbsolutePath());
		model.addAttribute("status", "success");
		return "result";
	}
}