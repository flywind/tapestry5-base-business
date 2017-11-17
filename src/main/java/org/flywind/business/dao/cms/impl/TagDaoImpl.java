package org.flywind.business.dao.cms.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flywind.business.common.constants.FBaseConstants;
import org.flywind.business.dao.base.AbstractFBaseDao;
import org.flywind.business.dao.cms.TagDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Tag;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl extends AbstractFBaseDao<Tag> implements TagDao {

	public List<Tag> getAllTags(){
		StringBuilder hql = new StringBuilder("FROM Tag WHERE isShow = 1 ORDER BY seqNum ASC");
		return super.query(hql.toString());
	}
}
