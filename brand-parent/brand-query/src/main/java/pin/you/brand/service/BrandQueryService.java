package pin.you.brand.service;

import java.util.List;

import pin.you.gou.pojo.Brand;
import pin.you.gou.pojo.PageResult;

public interface BrandQueryService {
	
	public List<Brand> findAllBrand();
	
	public Brand findOneBrand(Long id);
	
	public PageResult findByPage(int pageNo,int pageSize);
	
	public void addBrand(Brand brand);
	
	public void updateBrand(Brand brand);

	public void deleteBrand(Long[] ids);

}
