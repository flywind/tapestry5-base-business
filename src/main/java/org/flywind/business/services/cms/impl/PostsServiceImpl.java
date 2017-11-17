package org.flywind.business.services.cms.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.flywind.business.common.exception.FException;
import org.flywind.business.common.exception.FExceptionKey;
import org.flywind.business.common.utils.FBaseUtil;
import org.flywind.business.common.utils.RelativeDateUtile;
import org.flywind.business.dao.cms.CategoryDao;
import org.flywind.business.dao.cms.DiscussDao;
import org.flywind.business.dao.cms.PostsDao;
import org.flywind.business.dao.cms.TagDao;
import org.flywind.business.dao.sys.UserDao;
import org.flywind.business.entities.base.FSysInfo;
import org.flywind.business.entities.cms.Category;
import org.flywind.business.entities.cms.Discuss;
import org.flywind.business.entities.cms.Posts;
import org.flywind.business.entities.cms.Tag;
import org.flywind.business.entities.sys.User;
import org.flywind.business.services.cms.PostsService;
import org.flywind.widgets.core.dao.FPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private DiscussDao discussDao;
	
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Long createPost(Posts p){
		return postsDao.save(p);
	}
	
	public void deletePosts(Posts p){
		postsDao.delete(p);
	}
	
	public void deletePostsForSupperByIds(List<String> ids) throws Exception{
		for(String id : ids){
			discussDao.deleteDiscussByPostsId(Long.parseLong(id));
			postsDao.deleteById(Posts.class, Long.parseLong(id));
		}
	}
	
	public void deletePostsByIds(String userName, List<String> ids) throws Exception{
		for(String id : ids){
			Posts p = postsDao.getById(Posts.class,Long.parseLong(id));
			String author = p.getAuthor();
			if(!userName.equals(author)){
				throw new FException(FExceptionKey.DELETE_ERROR);
			}else{
				discussDao.deleteDiscussByPostsId(Long.parseLong(id));
				postsDao.delete(p);
			}	
		}
	}
	
	public Boolean deletePostsById(Long id){
		return postsDao.deleteById(Posts.class, id);
	}
	
	public void deletePostsAndDiscuss(Posts posts,Long DiscussId){
		Discuss d = new Discuss();
		d.setPostsId(posts.getId());
		discussDao.delete(d);
		postsDao.deleteById(Posts.class, posts.getId());
	}
	
	public void updatePosts(Posts p){
		postsDao.update(p);
	}
	
	public Posts getPostsById(Long id){
		Posts p = postsDao.getById(Posts.class, id);
		List<Discuss> discusses = discussDao.getDiscussByPostsId(id);
		List<Tag> tags = tagDao.getAllTags();
		//List<Category> categorys = categoryDao.getAllCategory();
		if(p.getPicUrl() == null){
			p.setHasPic(Boolean.FALSE);
		}
		setTagName(p, tags);
		setCountDiscuss(p,discusses);
		setCountVoter(p);
		//setCategoryName(p,categorys,lang);
		
		return p;
	}
	
	public List<Posts> getAllPosts(Posts posts, FPage page, String lang){
		List<Posts> postss = postsDao.getAllPosts(posts, page);
		List<Tag> tags = tagDao.getAllTags();
		List<Category> categorys = categoryDao.getAllCategory();
		
		if(null != postss && postss.size()>0){
			for(Posts ps : postss){
				ps.setTimeAgo(RelativeDateUtile.format(ps.getCreateTime(),lang));
				List<Discuss> discusses = discussDao.getDiscussByPostsId(ps.getId());
				User user = userDao.findByUsername(ps.getAuthor());
				ps.setUser(user);
				if(ps.getPicUrl() == null){
					ps.setHasPic(Boolean.FALSE);
				}
				setCountDiscuss(ps,discusses);
				setCountVoter(ps);
				setSubContent(ps,250);
				setTagName(ps, tags);
				setCategoryName(ps,categorys,lang);
				
			}
		}
		return postss;
	}
	
	public List<Discuss> getAllDiscussByPostsId(Long postsId){
		return discussDao.getDiscussByPostsId(postsId);
	}

	public static void setCategoryName(Posts posts, List<Category> categorys, String lang){
		if(null != categorys && categorys.size() > 0){
			for(Category c : categorys){
				if(c.getId() == posts.getCategoryId()){
					if("zh-cn".equalsIgnoreCase(lang)){
						posts.setCategoryName(c.getName());
					}else {
						posts.setCategoryName(c.getNameEn());
					}
					
				}
			}
		}
	}
	
	public static void setTagName(Posts posts, List<Tag> tags){
		if(null != tags && tags.size()>0){
			for(Tag t : tags){
				if(t.getId() == posts.getTagId()){
					posts.setTagName(t.getValue());
				}
			}
		}
	}
	
	public static void setCountDiscuss(Posts posts, List<Discuss> discusses){
		if(null != discusses){
			posts.setCountDiscuss(discusses.size());
		}else{
			posts.setCountDiscuss(0);
		}
	}
	
	public static void setCountVoter(Posts posts){
		if(StringUtils.isNoneBlank(posts.getVoter())){
			String[] strs = posts.getVoter().split(",");
			posts.setCountVoter(strs.length);
		}else{
			posts.setCountVoter(0);
		}
	}
	
	public static void setSubContent(Posts posts, int count){
		if(StringUtils.isNotBlank(posts.getContent())){
			String sb = FBaseUtil.htmlTotext(posts.getContent());
			if(sb.length() > count){
				sb = sb.substring(0, count) + "...";
			}
			posts.setSubContent(sb);
		}
	}
}
