package org.flywind.business.services.base.impl;

import java.util.List;

import org.flywind.business.dao.base.SysParamDao;
import org.flywind.business.entities.base.SysParam;
import org.flywind.business.services.base.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysParamServiceImpl implements SysParamService {

	@Autowired
	private  SysParamDao sysParamDao;
	
	@Override
	public  List<SysParam> getAllParamByBusinessType(int businessType)
	{	
		List<SysParam>   sysParams = sysParamDao.getAllParamByBusinessType(businessType);
		
		return sysParams;
	}

}
