package pin.you.adver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pin.you.adver.service.CategoryService;
import pin.you.gou.pojo.Category;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;

@RestController
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/findAllCategory")
	public List<Category> findAllCatagory(){			
		return categoryService.findAllCategory();
	}
	
	/*
	@RequestMapping("/findByCatePage")
	
	public PageResult findByCatePage(Integer pageNo,Integer pageSize){	
		//int a=page.intValue();
		//int b=rows.intValue();
		return categoryService.findByCatePage(pageNo,pageSize);
	}

*/
	@RequestMapping("/addCate")
	public Result addCate(@RequestBody Category category){
		try {
			categoryService.addCate(category);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	@RequestMapping("/updateCate")
	public Result updateCate(@RequestBody Category category){
		try {
			categoryService.updateCate(category);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	@RequestMapping("/findOneCategory")
	public Category findOneCategory(Long id){
		return categoryService.findOneCategory(id);		
	}
	
	@RequestMapping("/deleteCate")
	public Result deleteCate(Long[] ids){
		return categoryService.deleteCate(ids);
	}
	
	/*
	@RequestMapping("/searchCate")
	public PageResult searchCate(@RequestBody Category category, int page,int rows){

		return categoryService.findByCatePage(category, page, rows);		
	}
	*/
}
