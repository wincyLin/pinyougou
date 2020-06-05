package pin.you.specifi.service;

import java.util.List;
import java.util.Map;

import pin.you.gou.pojo.Option;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;
import pin.you.gou.pojo.Specifi;
import pin.you.gou.pojo.group.Specification;

public interface SpecifiQueryService {
	
	
	public List<Specifi> findAllSpecification();
	
	public Specification findOneSpecification(Long id);
	
	public PageResult findByPage(int pageNo,int pageSize);
	
	public void add(Specification specification);
	
	public void update(Specification specifition);
	
	public Result delete(Long[] ids);
	
	public PageResult findByPage(Specifi specifi,int pageNum,int pageSize);

	List<Map> selectOptionList();

	
}
