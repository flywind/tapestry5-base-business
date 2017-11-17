package org.flywind.business.dao.sys.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.flywind.business.common.constants.FBaseConstants;
import org.flywind.business.dao.base.AbstractFBaseDao;
import org.flywind.business.dao.sys.RoleDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.Role;
import org.flywind.business.entities.sys.User;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.stereotype.Repository;

/**
 * <p>Role Dao Impl</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
@Repository
public class RoleDaoImpl extends AbstractFBaseDao<Role> implements RoleDao {

	@Override
	public List<Role> findAll(Role role, FPage paging, FSysInfo session) {
		StringBuilder hql = new StringBuilder("FROM Role");
		StringBuilder countHql = new StringBuilder("SELECT COUNT(id) FROM Role");
		StringBuilder condition = new StringBuilder(" WHERE customerCode = :customerCode AND creater = :creater");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.CUSTOMER_CODE, session.getCustomerCode());
		//can only see their own characters
		params.put(FBaseConstants.CREATER, session.getUser().getUsername());
		
		if (null != role.getName()) {
			condition.append(" AND name LIKE :name");
			params.put(FBaseConstants.NAME_STRING, "%" + role.getName().trim() + "%");
		}
		if (null != role.getDescription()) {
			condition.append(" AND description LIKE :description");
			params.put(FBaseConstants.DESC_STRING, "%" + role.getDescription().trim() + "%");
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
	
	@Override
	public boolean checkRoleExist(String roleName, String customerCode) {
		String hql = "SELECT count(id) FROM Role WHERE name = :name AND customerCode = :customerCode";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.NAME_STRING, roleName);
		params.put(FBaseConstants.CUSTOMER_CODE, customerCode);
		Long result = count(hql, params);
		return result > 0 ? true : false;
	}
	
	@Override
	public Set<Role> getRolesByUserId(Long userId) {
		String hql = "SELECT r FROM Role r, UserRole ur WHERE r.id = ur.roleId AND ur.userId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.ID_STRING, userId);
		Set<Role> roleSet = new HashSet<Role>(this.query(hql, params));
		return roleSet;
	}

	@Override
	public List<Role> getRoleByLoginUser(User loginUser) {
		String hql = "from Role where creater=:creater and customerCode=:customerCode";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("creater", loginUser.getUsername());
		params.put("customerCode", loginUser.getCustomerCode());	
		return this.query(hql, params);
	}
	
	@Override
	public List<Role> getRoleByUser(Long userId) {
		String hql = "FROM Role r WHERE r.id IN (SELECT ur.roleId FROM UserRole ur WHERE ur.userId = :id)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(FBaseConstants.ID_STRING, userId);
		return this.query(hql, params);
	}
	
}
