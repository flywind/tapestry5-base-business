package org.flywind.business.dao.sys;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.base.FProp;
import org.flywind.business.entities.sys.GridHeader;


/**
 * <p>自定义表头dao</p>
 * 
 * @author flywind 2158
 * @date 2015年12月16日
 * @since 1.0
 */
public interface GridHeaderDao extends FBaseDao<GridHeader>{
	

	public List<GridHeader> getGridHeader(String tableName, String customerCode);

	public GridHeader getGridHeader(String tableName, String field, String customerCode);
	
	public List<GridHeader> getGridHeader( String customerCode);
	
	public List<GridHeader> getGridHeaderByLanguage(String customerCode, String language);
	
	public  long  saveGridHeader(GridHeader gridHeader);
	
	public void update(FProp prop, String customerCode, String language) throws Exception;

}
