package pin.you.gou.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import pin.you.gou.pojo.Specifi;
import pin.you.gou.pojo.SpecifiExample;

public interface SpecifiMapper {
    int countByExample(SpecifiExample example);

    int deleteByExample(SpecifiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Specifi record);

    int insertSelective(Specifi record);

    List<Specifi> selectByExample(SpecifiExample example);

    Specifi selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Specifi record, @Param("example") SpecifiExample example);

    int updateByExample(@Param("record") Specifi record, @Param("example") SpecifiExample example);

    int updateByPrimaryKeySelective(Specifi record);

    int updateByPrimaryKey(Specifi record);

	List<Map> selectOptionList();
}