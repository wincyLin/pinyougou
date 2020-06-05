package pin.you.adver.service;

import java.util.List;

import pin.you.gou.pojo.Category;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;

public interface CategoryService {
	
	public List<Category> findAllCategory();
	
	//public PageResult findByCatePage(Integer pageNum,Integer pageSize);
	
	public void addCate(Category category);
	
	public void updateCate(Category category);
	
	public Category findOneCategory(Long id);
	
	public Result deleteCate(Long[] ids);
	
//	public PageResult findByCatePage(Category category,int pageNum,int pageSize);
		

}
