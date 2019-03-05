package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrm.dao.NoticeDao;
import com.hrm.domain.Notice;
import com.hrm.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeDao noticeDao;

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return noticeDao.deleteById(id);
	}

	@Override
	public void insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.insertNotice(notice);
	}

	@Override
	public Notice selectById(int id) {
		// TODO Auto-generated method stub
		return noticeDao.selectById(id);
	}

	@Override
	public List<Notice> selectNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.selectNotice(notice);
	}

	@Override
	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.updateNotice(notice);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return noticeDao.countList();
	}

	@Override
	public List<Notice> countNotice(Map params) {
		// TODO Auto-generated method stub
		return noticeDao.countNotice(params);
	}
	
}
