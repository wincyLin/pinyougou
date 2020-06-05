package pin.you.specifi.service;

import java.util.List;

import pin.you.gou.pojo.Option;
import pin.you.gou.pojo.PageResult;

public interface OptionService {
	
	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Option> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findByPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Option option);
	
	
	/**
	 * 修改
	 */
	public void update(Option option);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Option findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findByPage(Option option, int pageNum,int pageSize);
	
}



