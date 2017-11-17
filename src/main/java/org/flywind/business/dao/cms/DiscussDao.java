package org.flywind.business.dao.cms;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.cms.Discuss;
import org.flywind.widgets.core.dao.FPage;

public interface DiscussDao extends FBaseDao<Discuss> {
	
	public int deleteDiscussByPostsId(Long id);

	public List<Discuss> getDiscussByPostsId(Long id);
	
	public List<Discuss> getAllDiscuss(Discuss d, FPage page);
}
