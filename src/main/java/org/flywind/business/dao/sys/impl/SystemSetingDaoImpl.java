package org.flywind.business.dao.sys.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.flywind.business.common.constants.FBaseConstants;
import org.flywind.business.dao.base.AbstractFBaseDao;
import org.flywind.business.dao.sys.SystemSetingDao;
import org.flywind.business.entities.sys.SystemSeting;
import org.springframework.stereotype.Repository;


/**
 * <p>System Seting Dao Impl</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
@Repository
public class SystemSetingDaoImpl extends AbstractFBaseDao<SystemSeting>  implements  SystemSetingDao
{

	@Override
	public SystemSeting querySysSetingByCustomerCode(String customerCode) {
		String hql ="from SystemSeting where customerCode=:customerCode";
		Map<String,Object>  params = new HashMap<String,Object>();
		params.put(FBaseConstants.CUSTOMER_CODE, customerCode);
		List<SystemSeting> systemSetings = super.query(hql, params);
		SystemSeting systemSeting = new SystemSeting();
		if(null!=systemSetings&&systemSetings.size()>0){
			systemSeting=systemSetings.get(0);
		}
		return systemSeting;
	}
   
}
