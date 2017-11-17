package org.flywind.business.dao.cms;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.cms.Category;

public interface CategoryDao extends FBaseDao<Category> {

	public List<Category> getAllCategory();
}
