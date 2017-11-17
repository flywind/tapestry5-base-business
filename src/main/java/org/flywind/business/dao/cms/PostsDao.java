package org.flywind.business.dao.cms;

import java.util.List;

import org.flywind.business.dao.base.FBaseDao;
import org.flywind.business.entities.cms.Posts;
import org.flywind.widgets.core.dao.FPage;

public interface PostsDao extends FBaseDao<Posts> {

	public List<Posts> getAllPosts(Posts posts, FPage page);
}
