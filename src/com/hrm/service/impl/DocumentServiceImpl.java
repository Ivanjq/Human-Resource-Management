package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.DeptDao;
import com.hrm.dao.DocumentDao;
import com.hrm.domain.Document;
import com.hrm.service.DocumentService;
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentDao documentDao;
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return documentDao.deleteById(id);
	}

	@Override
	public void insertDocument(Document document) {
		// TODO Auto-generated method stub
		documentDao.insertDocument(document);
	}

	@Override
	public Document selectById(int id) {
		// TODO Auto-generated method stub
		return documentDao.selectById(id);
	}

	@Override
	public List<Document> selectDocument(Document document) {
		// TODO Auto-generated method stub
		return documentDao.selectDocument(document);
	}

	@Override
	public void updateDocument(Document document) {
		// TODO Auto-generated method stub
		documentDao.updateDocument(document);
	}

	@Override
	public List<Document> countDocument(Map params) {
		// TODO Auto-generated method stub
		return documentDao.countDocument(params);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return documentDao.countList();
	}

}
