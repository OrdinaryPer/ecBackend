package info.csoe.dao;

import info.csoe.bean.Attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeDao {

    List<Attribute> getAllAttributeByCategoryId(@Param("id") Integer id,
                                                @Param("sel") String sel);

    // cid 表示分类 id，aid 表示属性 id
    Attribute getAttributeById(@Param("cid") Integer id,
                               @Param("aid") Integer attrId,
                               @Param("sel") String sel);



    Integer addAttribute(Attribute attribute);

    Integer deleteAttributeById(@Param("cid") Integer cid,
                                @Param("aid") Integer aid);

    Integer updateAttributeById(Attribute attribute);
}
