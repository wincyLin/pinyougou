package pin.you.specifi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;
import pin.you.gou.pojo.Specifi;
import pin.you.gou.pojo.group.Specification;
import pin.you.specifi.service.SpecifiQueryService;




@RestController
@CrossOrigin
public class SpecifiQueryController {
	

	@Autowired
	private SpecifiQueryService specifiQueryService;
	
	
	@RequestMapping("/findAll")
	public List<Specifi> findAllSpecification(){
		return specifiQueryService.findAll();
	}
	
	@RequestMapping("/findOne")
	public Specification findOneSpecification(long id) {
		return specifiQueryService.findOne(id);
		
	}

	@RequestMapping("/add")
	public Result add(@RequestBody Specification specification) {
		try {
		specifiQueryService.add(specification);
		return new Result(true,"增加成功");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(int pageNo,int pageSize) {
		return specifiQueryService.findByPage(pageNo, pageSize);
		
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody Specification specification){
		try {
		specifiQueryService.update(specification);
		return new Result(true,"增加成功");
	}catch(Exception e) {
		e.printStackTrace();
		return new Result(false, "修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			specifiQueryService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	
	//查询+分页
	//brand、page、rows
	@RequestMapping("/search")
		public PageResult search(@RequestBody Specifi specifi,int page,int rows) {
			System.out.println("###############################################");
			System.out.println("##"+page+"##");
			System.out.println("##"+specifi+"##");
			System.out.println("#############################################");
			return specifiQueryService.findByPage(specifi, page, rows);		
		}
	

	
	@RequestMapping("/selectOptionList")
		public List<Map> selectOptionList(){
			return specifiQueryService.selectOptionList();
		}
	
	
	

}
