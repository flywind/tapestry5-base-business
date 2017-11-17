package org.flywind.business.services.cms;

import java.util.List;

import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Posts;
import org.flywind.widgets.core.dao.FPage;

public interface PostsService {

	public Long createPost(Posts p);
	
	public void deletePosts(Posts p);
	
	public void deletePostsForSupperByIds(List<String> ids) throws Exception;
	
	public void deletePostsByIds(String userName, List<String> ids) throws Exception;
	
	public void updatePosts(Posts p);
	
	public Posts getPostsById(Long id);
	
	public List<Posts> getAllPosts(Posts posts, FPage page, String lang);
}
