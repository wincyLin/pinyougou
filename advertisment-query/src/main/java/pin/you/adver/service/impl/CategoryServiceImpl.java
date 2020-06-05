package pin.you.adver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import pin.you.adver.service.CategoryService;
import pin.you.gou.mapper.CategoryMapper;
import pin.you.gou.pojo.Category;
import pin.you.gou.pojo.CategoryExample;
import pin.you.gou.pojo.CategoryExample.Criteria;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.selectByExample(null);
	}
/*
	@Override
	public PageResult findByCatePage(Integer pageNo, Integer pageSize) {
		PageResult pageResult = new PageResult();
		PageHelper.startPage(pageNo, pageSize);		
		Page<Category> page=   (Page<Category>) categoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}
*/	

	@Override
	public void addCate(Category category) {
		categoryMapper.insert(category);

	}

	@Override
	public void updateCate(Category category) {
		categoryMapper.updateByPrimaryKey(category);

	}

	@Override
	public Category findOneCategory(Long id) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(id);
	}


	/*

	@Override
	public PageResult findByCatePage(Category category, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		CategoryExample example=new CategoryExample();
		Criteria criteria = example.createCriteria();
		
		if(category!=null){			
						if(category.getName()!=null && category.getName().length()>0){
				criteria.andNameLike("%"+category.getName()+"%");
			}
	
		}
		Page<Category> page=   (Page<Category>) categoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());

	
	}
	*/

	@Override
	public Result deleteCate(Long[] ids) {
		Result result = null;
		try {
			for(int j=0;j<ids.length;j++) {
				categoryMapper.deleteByPrimaryKey(ids[j]);
				
			}
			result = new Result(true , "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result = new Result(false , "删除失败！");
		}
		return result;
			
	}

}
