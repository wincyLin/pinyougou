package pin.you.specifi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import pin.you.gou.mapper.OptionMapper;
import pin.you.gou.pojo.Option;
import pin.you.gou.pojo.OptionExample;
import pin.you.gou.pojo.OptionExample.Criteria;
import pin.you.gou.pojo.PageResult;
import pin.you.specifi.service.OptionService;


@Service
public class OptionServiceImpl implements OptionService {


	@Autowired
	private OptionMapper optionMapper;
	
	
	
	
	@Override
	public List<Option> findAll() {
		
		return optionMapper.selectByExample(null);
	}
	
	

	@Override
	public PageResult findByPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum,pageSize);
		Page<Option> page =(Page<Option>) optionMapper.selectByExample(null);
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public void add(Option option) {
		// TODO Auto-generated method stub
		optionMapper.insert(option);

	}

	@Override
	public void update(Option option) {
		// TODO Auto-generated method stub
		optionMapper.updateByPrimaryKey(option);
	}

	@Override
	public Option findOne(Long id) {
		// TODO Auto-generated method stub
		return optionMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id:ids) {
			optionMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public PageResult findByPage(Option option, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		OptionExample example=new OptionExample();
		Criteria criteria = example.createCriteria();
		if(option!=null) {
			if(option.getOptionName()!=null&&option.getOptionName().length()>0) {
				criteria.andOptionNameLike("%"+option.getOptionName()+"%");
			}
		}
		return null;
	}

}
