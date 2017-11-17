package org.flywind.business.services.cms;

import java.util.List;

import org.flywind.business.entities.cms.Discuss;
import org.flywind.widgets.core.dao.FPage;

public interface DiscussService {

	public Long createDiscuss(Discuss d);
	
	public void updateDiscuss(Discuss d);
	
	public void deleteDiscuss(Discuss d);
	
	public Boolean deleteDiscussById(Long id);
	
	public List<Discuss> getDiscussByPostsId(Long id);
	
	public List<Discuss> getAllDiscuss(Discuss d, FPage page);
	
	public void deleteDsicussByIds(List<String> ids) throws Exception;
}
