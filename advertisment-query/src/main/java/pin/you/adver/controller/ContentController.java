package pin.you.adver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pin.you.adver.service.ContentService;
import pin.you.gou.pojo.Content;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;


@RestController
@CrossOrigin
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/findByCategoryId")
	public List<Content> findByCategoryId(Long categoryId){
		return contentService.findByCategoryId(categoryId);
	}
	
	@RequestMapping("/findAllContent")
	public List<Content> findAllContent(){
		return contentService.findAllContent();
	}
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(Integer pageNum, Integer pageSize){			
		return contentService.findByPage(pageNum, pageSize);
	}
	
	@RequestMapping("/addContent")
	public Result addContent(@RequestBody Content content){
		try {
			contentService.addContent(content);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	@RequestMapping("/updateContent")
	public Result updateContent(@RequestBody Content content){
		try {
			contentService.updateContent(content);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	@RequestMapping("/findOneContent")
	public Content findOneContent(Long id){
		return contentService.findOneContent(id);		
	}
	
	@RequestMapping("/deleteContent")
	public Result deleteContent(Long [] ids){
		
			return contentService.deleteContent(ids);
		
	}
	
	@RequestMapping("/searchContent")
	public PageResult searchContent(@RequestBody Content content, Integer pageNum, Integer pageSize){
		return contentService.findByPage(content, pageNum, pageSize);		
	}
	
	
}
