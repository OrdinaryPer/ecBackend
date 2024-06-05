package info.csoe.service;

import info.csoe.utils.attribute.AttrListRes;
import info.csoe.utils.attribute.AttrOneRes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface AttributeService {
    AttrListRes getAllAttributeByCategoryId(Integer id, String sel);

    AttrOneRes getAttributeById(Integer id, Integer attrId, String sel);

    AttrOneRes addAttribute(Integer cid,String name,String sel,String vals);

    AttrOneRes deleteAttributeById(Integer cid, Integer aid);

    AttrOneRes updateAttributeById(Integer cid,Integer aid,String name,String sel,String vals);
}
