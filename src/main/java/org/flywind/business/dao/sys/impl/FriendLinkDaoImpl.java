package org.flywind.business.dao.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flywind.business.common.constants.FBaseConstants;
import org.flywind.business.dao.base.AbstractFBaseDao;
import org.flywind.business.dao.sys.FriendLinkDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.FriendLink;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.stereotype.Repository;

/**
 * <p>Friend Link Dao Impl</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
@Repository
public class FriendLinkDaoImpl extends AbstractFBaseDao<FriendLink> implements FriendLinkDao{

	@Override
	public List<FriendLink> findAll(FriendLink link, FPage paging, FSysInfo session) {
		StringBuilder hql = new StringBuilder("FROM FriendLink");
		StringBuilder countHql = new StringBuilder("SELECT COUNT(id) FROM FriendLink");
		StringBuilder condition = new StringBuilder(" WHERE customerCode = :customerCode");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.CUSTOMER_CODE, session.getCustomerCode());
		
		if (null != link.getLinkName()) {
			condition.append(" AND name LIKE :linkName");
			params.put("linkName", "%" + link.getLinkName().trim() + "%");
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
	
	public List<FriendLink> findAll(String customerCode){
		StringBuilder hql = new StringBuilder("FROM FriendLink");
		hql.append(" WHERE customerCode = :customerCode");
		hql.append(" and isOpen = true");
		hql.append(" order by seqNum desc");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("customerCode", customerCode);
		return this.query(hql.toString(), params,0,5);
	}

}
