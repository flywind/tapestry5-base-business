package org.flywind.business.dao.sys;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.VersionLog;
import org.flywind.widgets.core.dao.FPage;

/**
 * <p>Version Log Dao</p>
 * 
 * @author flywind(飞风)
 * @date 2016年1月7日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
public interface VersionLogDao extends FBaseDao<VersionLog> {
	
	/**
	 * Query version log
	 * 查询版本日志
	 * 
	 * @param log
	 *        	VersionLog
	 * @param paging
	 *        	Pagination
	 * @param session
	 *        	System base info
	 * @return
	 * 			Object collection
	 */
	public List<VersionLog> findAll(VersionLog log, FPage paging, FSysInfo session);
	

}
