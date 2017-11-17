package org.flywind.business.services.sys.impl;

import java.util.List;

import org.flywind.business.common.utils.FBaseUtil;
import org.flywind.business.dao.sys.CommentDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.Comment;
import org.flywind.business.services.sys.CommentService;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public Long create(Comment c) {
		return commentDao.save(c);
	}

	@Override
	public void update(Comment c) {
		commentDao.update(c);
	}

	@Override
	public void delete(Long id) {
		commentDao.deleteById(Comment.class, id);
	}
	
	@Override
	public void deleteByIds(String ids) {
		List<Long> list = FBaseUtil.idsToList(ids);
		for(Long id : list){
			commentDao.deleteById(Comment.class, id);
		}
	}

	@Override
	public List<Comment> findAll(Comment c, FPage paging, FSysInfo session) {
		return commentDao.findAll(c, paging, session);
	}
	
	public List<Comment> findAllByContentId(Long id, FPage paging, String customerCode){
		return commentDao.findAllByContentId(id, paging, customerCode);
	}

	@Override
	public Comment getById(Long id) {
		return commentDao.getById(Comment.class, id);
	}

}
