package org.flywind.business.services.sys;

import java.util.List;

import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.Contact;
import org.flywind.widgets.core.dao.FPage;

/**
 * <p>Contact Service</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
public interface ContactService {

	/**
	 * Create contact me messages
	 * 添加联系飞风
	 * 
	 * @param c
	 * 			Contact
	 * @return
	 * 			Long
	 */
	public Long create(Contact c);
	
	/**
	 * Update contact me messages
	 * 修改联系飞风
	 * 
	 * @param c
	 * 			Contact
	 */
	public void update(Contact c);
	
	/**
	 * Delete record based on ID
	 * 根据ID删除记录
	 * 
	 * @param id
	 * 			Contact id
	 */
	public void delete(Long id);
	
	/**
	 * Delete record based on IDS
	 * 根据IDS删除记录
	 * 
	 * @param ids
	 * 			Contact id set
	 */
	public void deleteByIds(String ids);

	/**
	 * Get comments based on contact me messages
	 * 根据条件获得联系飞风
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
	
	/**
	 * Obtain contact me messages based on ID
	 * 根据ID获得联系飞风
	 * 
	 * @param id
	 * 			Contact id
	 * @return
	 * 			Object
	 */
	public Contact getById(Long id);
}
