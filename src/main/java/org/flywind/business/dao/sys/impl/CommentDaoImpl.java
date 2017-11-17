package org.flywind.business.dao.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flywind.business.common.constants.FBaseConstants;
import org.flywind.business.dao.base.AbstractFBaseDao;
import org.flywind.business.dao.sys.CommentDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.Comment;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.stereotype.Repository;

/**
 * <p>Comment Dao impl</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
@Repository
public class CommentDaoImpl extends AbstractFBaseDao<Comment> implements CommentDao {

	@Override
	public List<Comment> findAll(Comment c, FPage paging, FSysInfo session) {
		StringBuilder hql = new StringBuilder("FROM Comment");
		StringBuilder countHql = new StringBuilder("SELECT COUNT(id) FROM Comment");
		StringBuilder condition = new StringBuilder(" WHERE customerCode = :customerCode");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.CUSTOMER_CODE, session.getCustomerCode());
		
		if (null != c.getName()) {
			condition.append(" AND name LIKE :name");
			params.put("name", "%" + c.getName().trim() + "%");
		}
		
		if (null != paging) { 
			condition.append(" order by " + paging.getSortName() + " " + paging.getSortOrder());
		}
		
		countHql.append(condition);
		Long count = super.count(countHql.toString(), params);
		paging.setRowCount(count.intValue());
		
		hql.append(condition);
		return super.query(hql.toString(), params, paging.getPageNumber(), paging.getPageSize());
	}
	
	public List<Comment> findAllByContentId(Long id, FPage paging, String customerCode){
		StringBuilder hql = new StringBuilder("FROM Comment");
		StringBuilder condition = new StringBuilder(" WHERE customerCode = :customerCode");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.CUSTOMER_CODE, customerCode);
		condition.append(" AND contentId =:id And isOpen =1");
		params.put("id", id);
		hql.append(condition);
		return super.query(hql.toString(), params, paging.getPageNumber(), paging.getPageSize());
	}

}
