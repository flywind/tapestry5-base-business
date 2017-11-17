package org.flywind.business.dao.cms;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Work;
import org.flywind.widgets.core.dao.FPage;

/**
 * <p>Work Dao</p>
 * 
 * @author flywind(飞风)
 * @date 2016年6月22日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
public interface WorkDao extends FBaseDao<Work>{

	public List<Work> findAll(Work work, FPage paging, FSysInfo session);
	
	public List<Work> findAll(Work work, FPage paging, String customerCode);
	
	public List<Work> getListForLoop(Work work, FPage page, String customerCode);
	
	public List<Work> getListForHot(Work work, FPage page, String customerCode);
	
	public List<Work> getAllList(Work example, FPage page, String customerCode);

}
