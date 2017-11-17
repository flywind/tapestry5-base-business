package org.flywind.business.dao.sys;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.Contact;
import org.flywind.widgets.core.dao.FPage;

/**
 * <p>Contact Dao</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
public interface ContactDao extends FBaseDao<Contact>{

	/**
	 * Get comments based on contact me messages
	 * 根据条件获得留言
	 * 
	 * @param c
	 * 			contact me messages
	 * @param paging
	 * 			Pagination
	 * @param session
	 * 			System base info
	 * @return
	 * 			Object collection
	 */
	public List<Contact> findAll(Contact c, FPage paging, FSysInfo session);
	
}
