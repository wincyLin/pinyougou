package pin.you.specifi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


import pin.you.gou.mapper.OptionMapper;
import pin.you.gou.mapper.SpecifiMapper;
import pin.you.gou.pojo.Option;
import pin.you.gou.pojo.OptionExample;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;
import pin.you.gou.pojo.Specifi;
import pin.you.gou.pojo.SpecifiExample;
import pin.you.gou.pojo.SpecifiExample.Criteria;
import pin.you.gou.pojo.group.Specification;
import pin.you.specifi.service.SpecifiQueryService;


@Service
public class SpecifiQueryServiceImpl implements SpecifiQueryService {

	
	@Autowired
	private SpecifiMapper specificationMapper;
	
	@Autowired
	private OptionMapper optionMapper;
	

	@Override
	public List<Specifi> findAllSpecification() {
		return specificationMapper.selectByExample(null);
	}

	@Override
	public Specification findOneSpecification(Long id) {
		
		Specification specification = new Specification();
		// 根据规格ID查询规格对象
		Specifi Specifi = specificationMapper.selectByPrimaryKey(id);
		specification.setSpecification(Specifi);
		
		// 根据规格的ID查询规格选项
		OptionExample example = new OptionExample();
		OptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<Option> list = optionMapper.selectByExample(example);
		specification.setSpecificationOptionList(list);
		
		return specification;
		
	}

	@Override
	public PageResult findByPage(int pageNo, int pageSize) {

		PageHelper.startPage(pageNo, pageSize);		
		Page<Specifi> page=   (Page<Specifi>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
		
	}


	@Override
	public void add(Specification specification) {
		// 保存规格
		specificationMapper.insert(specification.getSpecification());
		//保存规格选项
		for(Option option:specification.getSpecificationOptionList()) {
			//设置规格ID
			option.setSpecId(specification.getSpecification().getId());
			optionMapper.insert(option);
		}
		
		
	}

	@Override
	public void update(Specification specification) {
		//修改规格
		specificationMapper.updateByPrimaryKey(specification.getSpecification());
		//先删除规格选项，再添加规格玄选项
		OptionExample example = new OptionExample();
		OptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specification.getSpecification().getId());
		optionMapper.deleteByExample(example);
		
		//保存规格选项
		for(Option option: specification.getSpecificationOptionList()) {
			//设置规格的ID
			option.setSpecId(specification.getSpecification().getId());
			optionMapper.insert(option);
		}
		
		
		
	}

	
	
	@Override
	public PageResult findByPage(Specifi specifi, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SpecifiExample example = new SpecifiExample();
		Criteria criteria=example.createCriteria();
		
		if(specifi!=null) {
			if(specifi.getSpecName()!=null && specifi.getSpecName().length()>0) {
				criteria.andSpecNameLike("%"+specifi.getSpecName()+"%");
			}
		}
		Page<Specifi> page= (Page<Specifi>)specificationMapper.selectByExample(example);
		
		return new PageResult(page.getTotal(),page.getResult());
		
		
	}
	

	@Override
	public List<Map> selectOptionList() {
		return specificationMapper.selectOptionList();
	}

	@Override
	public Result delete(Long[] ids) {
		Result result = null;
		
		try {
			for (int x = 0;x < ids.length; x++) {
				//删除规格选项
				OptionExample example = new OptionExample();
				OptionExample.Criteria criteria = example.createCriteria();
				criteria.andSpecIdEqualTo(ids[x]);
				optionMapper.deleteByExample(example);
				//删除规格
				specificationMapper.deleteByPrimaryKey(ids[x]);

			} 
			result = new Result(true , "删除成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(false  ,  "删除记录失败！");
		}
		return result;
		
	}






}
