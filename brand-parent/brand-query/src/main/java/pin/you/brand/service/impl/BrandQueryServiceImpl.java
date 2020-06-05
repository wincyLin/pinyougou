package pin.you.brand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import pin.you.brand.service.BrandQueryService;
import pin.you.gou.mapper.BrandMapper;
import pin.you.gou.pojo.Brand;
import pin.you.gou.pojo.PageResult;



@Service
public class BrandQueryServiceImpl implements BrandQueryService {

	
	@Autowired
	private BrandMapper brandMapper;
	
	
	@Override
	public List<Brand> findAllBrand() {
		List<Brand> list = brandMapper.selectByExample(null);
		return list;
	}

	@Override
	public Brand findOneBrand(Long id) {
		Brand brand = brandMapper.selectByPrimaryKey(id);
		return brand;
	}

	@Override
	public PageResult findByPage(int pageNo, int pageSize) {
		
		
		PageResult pageResult = new PageResult();
		//分页第一步骤：设置mybatis分页的拦截，然后重构sql分页语句
		PageHelper.startPage(pageNo, pageSize);

		List<Brand> list = brandMapper.selectByExample(null);
		
		
		//分页的第二个步骤：获取分页bean，里面提供分页所需的参数
		PageInfo pageInfo = new PageInfo<>(list);
		//pageInfo.getPageNum();
		//pageInfo.getTotal();		
		pageResult.setRows(list);
		pageResult.setTotal(pageInfo.getTotal());
		
		return pageResult;
	}

	@Override
	public void addBrand(Brand brand) {
		// TODO Auto-generated method stub
		brandMapper.insert(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		brandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public void deleteBrand(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}

	}

}
