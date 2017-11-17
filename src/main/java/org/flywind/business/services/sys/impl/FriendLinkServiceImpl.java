package org.flywind.business.services.sys.impl;

import java.util.List;

import org.flywind.business.common.utils.FBaseUtil;
import org.flywind.business.dao.sys.FriendLinkDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.FriendLink;
import org.flywind.business.services.sys.FriendLinkService;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendLinkServiceImpl implements FriendLinkService {
	
	@Autowired
	private FriendLinkDao friendLinkDao;
	
	@Override
	public Long create(FriendLink link){
		return friendLinkDao.save(link);
	}
	
	@Override
	public void update(FriendLink link){
		friendLinkDao.update(link);
	}
	
	@Override
	public void delete(Long linkId){
		friendLinkDao.deleteById(FriendLink.class, linkId);
	}
	
	@Override
	public void deleteByIds(String ids){
		List<Long> list = FBaseUtil.idsToList(ids);
		for(Long id : list){
			friendLinkDao.deleteById(FriendLink.class, id);
		}
	}

	@Override
	public List<FriendLink> findAll(FriendLink link, FPage paging, FSysInfo session) {
		List<FriendLink> links = friendLinkDao.findAll(link, paging, session);
		return links;
	}
	

	public FriendLink getById(Long id){
		return friendLinkDao.getById(FriendLink.class, id);
	}
	
	public List<FriendLink> findAll(String customerCode){
		return friendLinkDao.findAll(customerCode);
	}
}
