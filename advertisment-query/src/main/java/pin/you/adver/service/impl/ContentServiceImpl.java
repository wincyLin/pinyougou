package pin.you.adver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


import pin.you.adver.service.ContentService;
import pin.you.gou.mapper.ContentMapper;
import pin.you.gou.pojo.Content;
import pin.you.gou.pojo.ContentExample;
import pin.you.gou.pojo.ContentExample.Criteria;
import pin.you.gou.pojo.PageResult;
import pin.you.gou.pojo.Result;


@Service
public class ContentServiceImpl implements ContentService {
	
	
	@Autowired
	private ContentMapper contentMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;

	

	@Override
	public List<Content> findAllContent() {
		
		return contentMapper.selectByExample(null);
	}

	@Override
	public PageResult findByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Content> page=   (Page<Content>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	
	}

	@Override
	public void addContent(Content content) {
		contentMapper.insert(content);
		redisTemplate.boundHashOps("content").delete(content.getCategoryId());

	}

	@Override
	public void updateContent(Content content) {
		Content oldContent= contentMapper.selectByPrimaryKey(content.getId());
		redisTemplate.boundHashOps("content").delete(oldContent.getCategoryId());
		contentMapper.updateByPrimaryKey(content);
		if(content.getCategoryId() !=oldContent.getCategoryId()) {
			redisTemplate.boundHashOps("content").delete(content.getCategoryId());
		}
		
	}
	
	
	@Override
	public Content findOneContent(Long id) {
		// TODO Auto-generated method stub
		return contentMapper.selectByPrimaryKey(id);
	}

	@Override
	public Result deleteContent(Long[] ids) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			for (int i=0;i<ids.length;i++){
			Content content = contentMapper.selectByPrimaryKey(ids[i]);
			redisTemplate.boundHashOps("content").delete(content.getCategoryId());
			contentMapper.deleteByPrimaryKey(ids[i]);
			result = new Result(true , "删除成功！");
		}
	} catch (Exception e) {
		e.printStackTrace();
		result = new Result(false,"删除失败！");
	}
	return result;

	}
	
	

	@Override
	public PageResult findByPage(Content content, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		ContentExample example= new ContentExample();
		Criteria criteria = example.createCriteria();
		
		if(content!=null) {
			if(content.getTitle()!=null && content.getTitle().length()>0) {
				criteria.andTitleLike("%"+content.getTitle()+"%");
			}
			if(content.getUrl()!=null && content.getUrl().length()>0) {
				criteria.andUrlLike("%"+content.getTitle()+"%");
			}
			if(content.getPic()!=null && content.getPic().length()>0) {
				criteria.andPicLike("%"+content.getTitle()+"%");
				
			}
			if(content.getStatus()!=null &&  content.getStatus().length()>0) {
				criteria.andStatusLike("%"+content.getTitle()+"%");
			}
		}
		
		Page<Content> page=   (Page<Content>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Content> findByCategoryId(Long categoryId) {
		//加入缓存的代码
		
		List<Content> list = (List<Content>) redisTemplate.boundHashOps("content").get(categoryId);
		
		if(list==null) {
			System.out.println("查询数据库============================");
			ContentExample example = new ContentExample();
			Criteria criteria = example.createCriteria();
			//有效广告
			criteria .andStatusEqualTo("1");
			criteria.andCategoryIdEqualTo(categoryId);
			//排序
			example.setOrderByClause("sort_order");
			list = contentMapper.selectByExample(example);
			redisTemplate.boundHashOps("content").put(categoryId, list);
			
			
		}else {
			System.out.println("从缓存中获取===============================");
		}
		return list;
	}


}
