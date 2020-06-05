package pin.you.adver.service;

import java.util.List;


import pin.you.gou.pojo.Content;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;

public interface ContentService {
	
	public List<Content> findAllContent();
	
	public PageResult findByPage(Integer pageNum,Integer pageSize);
	
	public void addContent(Content content);
	
	public void updateContent(Content content);
	
	public Content findOneContent(Long id);
	
	public Result deleteContent(Long[] ids);
	
	public PageResult findByPage(Content content,int pageNum,int pageSize);
	
	public List<Content> findByCategoryId(Long categoryId);
	

	
}
