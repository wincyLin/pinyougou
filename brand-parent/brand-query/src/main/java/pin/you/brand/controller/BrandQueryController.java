package pin.you.brand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pin.you.brand.service.BrandQueryService;
import pin.you.gou.pojo.Brand;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;

@RestController
@CrossOrigin
public class BrandQueryController {
	
	
	@Autowired
	private BrandQueryService brandQueryService;
	
	
	@RequestMapping("/findAllBrand")
	public List<Brand> findAllBrand(){
		return brandQueryService.findAllBrand();
	}
	
	@RequestMapping("/findOneBrand/{id}")
	public Brand findOneBrand(@PathVariable long id) {
		return brandQueryService.findOneBrand(id);
	}
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(int pageNo,int pageSize) {
		return brandQueryService.findByPage(pageNo, pageSize);
		
	}
	
	@RequestMapping(value="/addBrand",method=RequestMethod.POST)
	public Result addBrand(@RequestBody Brand brand) {
		
		System.out.println(brand.getName());
		System.out.println(brand.getFirstChar());
		
		Result result = new Result();
		try {
			brandQueryService.addBrand(brand);
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
		}
		return result;
		
	}
	
	@RequestMapping(value="/updateBrand",method=RequestMethod.POST)
	  //对象前面加requestbody 有对象进来都用post
		public Result updateBrand(@RequestBody Brand brand) {
			
			System.out.println(brand.getFirstChar());
			System.out.println(brand.getName());
			
			Result result = new Result();
			
			try {
				brandQueryService.updateBrand(brand);
				result.setSuccess(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result.setSuccess(false);
				e.printStackTrace();
			}
			return result;
			
		}
	
	@RequestMapping(value="/deleteBrand",method=RequestMethod.GET)
	//对象前面加requestbody 有对象进来都用post
		public Result deleteBrand(Long[] ids) {
			
			
			System.out.println(ids[0]);
			
			Result result = new Result();
			
			try {
				brandQueryService.deleteBrand(ids);
				result.setSuccess(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result.setSuccess(false);
				e.printStackTrace();
			}
			return result;
			
		}
	
	
	
	
	

}
