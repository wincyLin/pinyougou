package pin.you.gou.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pin.you.gou.pojo.Option;
import pin.you.gou.pojo.OptionExample;

public interface OptionMapper {
    int countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Option record);

    int insertSelective(Option record);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}