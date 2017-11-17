package org.flywind.business.services.cms.impl;

import java.util.List;

import org.flywind.business.common.constants.FLogConstants;
import org.flywind.business.common.utils.FBaseUtil;
import org.flywind.business.common.utils.FLog;
import org.flywind.business.dao.base.SysParamDao;
import org.flywind.business.dao.cms.TechnologyDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.base.SysParam;
import org.flywind.business.entities.cms.Technology;
import org.flywind.business.services.cms.TechnologyService;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyDao technologyDao;
	
	@Autowired
	private SysParamDao sysParamDao;
	
	@FLog(infokey=FLogConstants.CREATE_TECHNOLOGY, optype = FLogConstants.CREATE)
	public Long create(Technology o){
		return technologyDao.save(o);
	}
	
	@FLog(infokey=FLogConstants.UPDATE_TECHNOLOGY, optype = FLogConstants.UPDATE)
	public void update(Technology o){
		technologyDao.update(o);
	}
	
	@FLog(infokey=FLogConstants.DELETE_TECHNOLOGY, optype = FLogConstants.DELETE)
	public void delete(Technology o){
		technologyDao.delete(o);
	}
	
	@FLog(infokey=FLogConstants.DELETE_TECHNOLOGY, optype = FLogConstants.DELETE)
	public boolean deleteById(Long id){
		return technologyDao.deleteById(Technology.class, id);
	}
	
	@FLog(infokey=FLogConstants.DELETE_TECHNOLOGY, optype = FLogConstants.DELETE)
	public void deleteByIds(String ids){
		List<Long> list = FBaseUtil.idsToList(ids);
		for(Long id : list){
			technologyDao.deleteById(Technology.class, id);
		}
	}
	
	//@FLog(infokey=FLogConstants.QUERY_TECHNOLOGY)
	public Technology getById(Long id){
		return technologyDao.getById(Technology.class, id);
	}
	
	//@FLog(infokey=FLogConstants.QUERY_TECHNOLOGY)
	public List<Technology> findAll(Technology technology, FPage paging, FSysInfo session, String lanage){
		List<Technology> technologys = technologyDao.findAll(technology, paging, session);
		
		for(Technology t : technologys){
			List<SysParam> sysParams = sysParamDao.getAllParamByBusinessType(2);
			for(SysParam s : sysParams){
				if(s.getParamKey() == t.getTechnologyType()){
					if("zh-cn".equalsIgnoreCase(lanage)){
						t.setTechnologyTypeName(s.getParamValue());
					}else{
						t.setTechnologyTypeName(s.getParamValueEn());
					}
					
				}
			}
		}
		
		return technologys;
	}
	
	//@FLog(infokey=FLogConstants.QUERY_TECHNOLOGY)
	public List<Technology> findAll(Technology technology, FPage paging, String customerCode){
		return technologyDao.findAll(technology, paging, customerCode);
	}
	
	//@FLog(infokey=FLogConstants.QUERY_TECHNOLOGY)
	public List<Technology> getListForLoop(Technology example, FPage page, String customerCode){
		return technologyDao.getListForLoop(example, page, customerCode);
	}
	
	//@FLog(infokey=FLogConstants.QUERY_TECHNOLOGY)
	public List<Technology> getListForHot(Technology example, FPage page, String customerCode){
		return technologyDao.getListForHot(example, page, customerCode);
	}
}
