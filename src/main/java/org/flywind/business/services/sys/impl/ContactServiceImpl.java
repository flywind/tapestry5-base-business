package org.flywind.business.services.sys.impl;

import java.util.List;

import org.flywind.business.common.utils.FBaseUtil;
import org.flywind.business.dao.sys.ContactDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.sys.Contact;
import org.flywind.business.services.sys.ContactService;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public Long create(Contact c) {
		return contactDao.save(c);
	}

	@Override
	public void update(Contact c) {
		contactDao.update(c);
	}

	@Override
	public void delete(Long id) {
		contactDao.deleteById(Contact.class, id);
	}
	
	@Override
	public void deleteByIds(String ids){
		List<Long> list = FBaseUtil.idsToList(ids);
		for(Long id : list){
			contactDao.deleteById(Contact.class, id);
		}
	}

	@Override
	public List<Contact> findAll(Contact c, FPage paging, FSysInfo session) {
		return contactDao.findAll(c, paging, session);
	}

	@Override
	public Contact getById(Long id) {
		return contactDao.getById(Contact.class, id);
	}

}
