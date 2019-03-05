package com.hrm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.*;
import com.hrm.domain.Document;
import com.hrm.domain.Notice;
import com.hrm.domain.Pages;
import com.hrm.domain.User;
import com.hrm.service.DocumentService;

/*处理用户请求控制器*/
@Controller
public class DocumentController {
	/*自动注入DocumentService*/
	@Autowired
	@Qualifier("documentService")
	//@Resource("DocumentService")
	DocumentService documentService;
	int pageSize=3;
	//动态查询
	@RequestMapping("main/selectDocument")
	public String countDocument(Document document,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("document",document);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=documentService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Document> list=documentService.countDocument(params);
		model.addAttribute("documentList",list);
		model.addAttribute("page",page);
		return "document/document_selectself";
	}
	//动态查询
	@RequestMapping("main/selectDocument2")
	public String countDocument2(Document document,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("document",document);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=documentService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Document> list=documentService.countDocument(params);
		model.addAttribute("documentList",list);
		model.addAttribute("page",page);
		return "document/document_select";
	}
	//插入
	@RequestMapping("document/insertDocument")
	public String insertDocument(Document document,MultipartFile file,HttpServletRequest request) throws Exception, IOException{
		if(file!=null){
			String path=request.getSession().getServletContext().getRealPath("/file/");
			String filename=file.getOriginalFilename();
			document.setFilename(filename);
			file.transferTo(new File(path+"/"+filename));
		}
		Date createDate=new Date();
		document.setCreateDate(createDate);
		User user=(User)request.getSession().getAttribute("user");
		document.setUser(user);
		documentService.insertDocument(document);
		return "redirect:../main/selectDocument2";
	}
	//删除
	@RequestMapping("/deleteDocument")
	public String deleteDocument(int id){
		documentService.deleteById(id);
		return "redirect:main/selectDocument2";
	}
	//下载
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam("filename") String filename,
			Model model) throws Exception{
		String path=request.getSession().getServletContext().getRealPath("/file/");
		File file=new File(path+File.separator+filename);
		HttpHeaders headers=new HttpHeaders();
		//下载显示的文件名，解决中文名称乱码问题
		String downloadFileName=new String(filename.getBytes("iso-8859-1"),"utf-8");
		//通知浏览器以attachment（下载方式）打开照片
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream:二进制流数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	//修改 
	@RequestMapping("/updatedocument")
	public String updatedocument(Document document,Model model){
		//根据id查询 返回页面
		Document target=documentService.selectById(document.getId());
		model.addAttribute("document",target);
		return "document/document_update";
	}
	@RequestMapping("/updatedocumentView")
	public String updatedocumentView(Document document){
		System.out.println("updatedocumentView");
		documentService.updateDocument(document);
		return "redirect:main/selectDocument2";
	}
}
