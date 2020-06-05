package pin.you.gou.pojo.group;

import java.io.Serializable;
import java.util.List;

import pin.you.gou.pojo.Option;
import pin.you.gou.pojo.Specifi;

public class Specification implements Serializable {
	
	private Specifi specification;
	
	private List<Option> specificationOptionList;
	
	public Specifi getSpecification() {
		return specification;
	}
	
	public void setSpecification(Specifi specification) {
		this.specification = specification;
	}
	
	public List<Option> getSpecificationOptionList(){
		return specificationOptionList;
	}
	
	public void setSpecificationOptionList(List<Option> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}
}
