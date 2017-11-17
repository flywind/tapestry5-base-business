package org.flywind.business.dao.cms.impl;

import java.util.List;

import org.flywind.business.dao.base.AbstractFBaseDao;
import org.flywind.business.dao.cms.CategoryDao;
import org.flywind.business.entities.cms.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends AbstractFBaseDao<Category> implements CategoryDao{

	public List<Category> getAllCategory(){
		StringBuilder hql = new StringBuilder("FROM Category WHERE isShow = 1 ORDER BY seqNum ASC");
		
		return super.query(hql.toString());
	}
}
