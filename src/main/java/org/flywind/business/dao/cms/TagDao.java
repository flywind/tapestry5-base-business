package org.flywind.business.dao.cms;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Tag;

public interface TagDao extends FBaseDao<Tag> {

	public List<Tag> getAllTags();
}
