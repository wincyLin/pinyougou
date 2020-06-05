package pin.you.gou.pojo;

import java.util.List;

//分页的封装类

public class PageResult {
	
	
	private List rows;//查询出来的区间集合
	
	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	private Long total;//总记录数
	
	
	
	
	

}
