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

/*�����û����������*/
@Controller
public class DocumentController {
	/*�Զ�ע��DocumentService*/
	@Autowired
	@Qualifier("documentService")
	//@Resource("DocumentService")
	DocumentService documentService;
	int pageSize=3;
	//��̬��ѯ
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
	//��̬��ѯ
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
	//����
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
	//ɾ��
	@RequestMapping("/deleteDocument")
	public String deleteDocument(int id){
		documentService.deleteById(id);
		return "redirect:main/selectDocument2";
	}
	//����
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam("filename") String filename,
			Model model) throws Exception{
		String path=request.getSession().getServletContext().getRealPath("/file/");
		File file=new File(path+File.separator+filename);
		HttpHeaders headers=new HttpHeaders();
		//������ʾ���ļ������������������������
		String downloadFileName=new String(filename.getBytes("iso-8859-1"),"utf-8");
		//֪ͨ�������attachment�����ط�ʽ������Ƭ
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream:������������
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	//�޸� 
	@RequestMapping("/updatedocument")
	public String updatedocument(Document document,Model model){
		//����id��ѯ ����ҳ��
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
