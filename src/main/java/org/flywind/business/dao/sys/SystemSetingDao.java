package org.flywind.business.dao.sys;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.sys.SystemSeting;

/**
 * <p>自定义入库Dao</p>
 * 
 * @author flywind(飞风)
 * @date 2015年11月18日
 * @网址：http://www.flywind.org
 * @QQ技术群：41138107(人数较多最好先加这个)或33106572
 * @since 1.0
 */
public interface SystemSetingDao   extends FBaseDao<SystemSeting> 
{
	/**
	 * Query customer custom information through customer code
	 * 通过客户编码查询客户自定义信息
	 * 
	 * @param customerCode
	 * 			Customer code
	 * @return
	 * 			Object
	 */
   public SystemSeting querySysSetingByCustomerCode(String customerCode);
}
