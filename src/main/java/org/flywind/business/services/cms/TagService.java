package org.flywind.business.services.cms;

import java.util.List;

import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Tag;

public interface TagService {

	public Long createTag(Tag t);
	
	public void updateTag(Tag t);
	
	public Boolean deleteTagById(Long id);
	
	public void deleteTag(Tag t);
	
	public List<Tag> getAllTags();
}
