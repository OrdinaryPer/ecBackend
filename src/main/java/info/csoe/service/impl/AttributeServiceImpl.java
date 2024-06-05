package info.csoe.service.impl;

import info.csoe.bean.Attribute;
import info.csoe.dao.AttributeDao;
import info.csoe.service.AttributeService;
import info.csoe.utils.Utils;
import info.csoe.utils.attribute.AttrListRes;
import info.csoe.utils.attribute.AttrOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeDao attributeDao;

    @Override
    public AttrListRes getAllAttributeByCategoryId(Integer id, String sel) {
        List<Attribute> allAttribute = attributeDao.getAllAttributeByCategoryId(id, sel);
        if (allAttribute == null) {
            return Utils.buildAttrListRes(null, Utils.buildMeta(404,"无数据"));
        }
        return Utils.buildAttrListRes(allAttribute, Utils.buildMeta(200,"获取成功"));
    }

    @Override
    public AttrOneRes getAttributeById(Integer id, Integer attrId, String sel) {
        Attribute attribute = attributeDao.getAttributeById(id, attrId, sel);
        if (attribute == null) {
            return Utils.buildAttrOneRes(null, Utils.buildMeta(404,"无属性数据"));
        }
        return Utils.buildAttrOneRes(attribute, Utils.buildMeta(200,"获取成功"));
    }

    @Override
    public AttrOneRes addAttribute(Integer cid,String name,String sel,String vals) {
        Attribute attribute = new Attribute();
        attribute.setCat_id(cid);
        attribute.setAttr_name(name);
        attribute.setAttr_sel(sel);
        if (vals == null) {
            attribute.setAttr_vals("");
        } else {
            attribute.setAttr_vals(vals);
        }
        Integer result = attributeDao.addAttribute(attribute);
        if (result != 1) {
            return Utils.buildAttrOneRes(null, Utils.buildMeta(404,"添加属性失败"));
        }
        Attribute insertedResult = attributeDao
                .getAttributeById(attribute.getCat_id(), attribute.getAttr_id(), attribute.getAttr_sel());
        if (insertedResult == null) {
            return Utils.buildAttrOneRes(null, Utils.buildMeta(404,"查询添加的属性失败"));
        }
        return Utils.buildAttrOneRes(insertedResult, Utils.buildMeta(200,"创建成功"));
    }

    @Override
    public AttrOneRes deleteAttributeById(Integer cid, Integer aid) {
        Integer result = attributeDao.deleteAttributeById(cid, aid);
        if (result != 1) {
            return Utils.buildAttrOneRes(null, Utils.buildMeta(404,"删除失败"));
        }
        return Utils.buildAttrOneRes(null, Utils.buildMeta(200,"删除成功"));
    }

    @Override
    public AttrOneRes updateAttributeById(Integer cid,Integer aid,String name,String sel, String vals) {
        Attribute attr = new Attribute();
        attr.setCat_id(cid);
        attr.setAttr_id(aid);
        attr.setAttr_name(name);
        attr.setAttr_sel(sel);
        attr.setAttr_vals(vals);
        Integer result = attributeDao.updateAttributeById(attr);
        if (result != 1) {
            return Utils.buildAttrOneRes(null, Utils.buildMeta(404,"修改失败"));
        }
        Attribute updatedResult = attributeDao
                .getAttributeById(attr.getCat_id(), attr.getAttr_id(), attr.getAttr_sel());
        if (updatedResult == null) {
            return Utils.buildAttrOneRes(null, Utils.buildMeta(404,"查询修改后的值失败"));
        }
        return Utils.buildAttrOneRes(updatedResult, Utils.buildMeta(200,"更新成功"));
    }
}
