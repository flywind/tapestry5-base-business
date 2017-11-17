package org.flywind.business.services.cms.impl;

import java.util.List;

import org.flywind.business.dao.cms.TagDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Tag;
import org.flywind.business.services.cms.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;
	
	public Long createTag(Tag t){
		return tagDao.save(t);
	}
	
	public void updateTag(Tag t){
		tagDao.update(t);
	}

	public Boolean deleteTagById(Long id){
		return tagDao.deleteById(Tag.class, id);
	}
	
	public void deleteTag(Tag t){
		tagDao.delete(t);
	}
	
	public List<Tag> getAllTags(){
		return tagDao.getAllTags();
	}
}
