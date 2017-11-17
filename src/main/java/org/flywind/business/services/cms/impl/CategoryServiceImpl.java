package org.flywind.business.services.cms.impl;

import java.util.List;

import org.flywind.business.dao.cms.CategoryDao;
import org.flywind.business.entities.cms.Category;
import org.flywind.business.services.cms.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public Long createCategory(Category c){
		return categoryDao.save(c);
	}
	
	public void updateCategory(Category c){
		categoryDao.update(c);
	}
	
	public void deleteCategory(Category c){
		categoryDao.delete(c);
	}
	
	public Boolean deleteCategoryById(Long id){
		return categoryDao.deleteById(Category.class, id);
	}
	
	public List<Category> getAllCategory(){
		return categoryDao.getAllCategory();
	}
}
