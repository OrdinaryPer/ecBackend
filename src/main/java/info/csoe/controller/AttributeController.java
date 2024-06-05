package info.csoe.controller;

import info.csoe.bean.Attribute;
import info.csoe.service.AttributeService;
import info.csoe.utils.attribute.AttrListRes;
import info.csoe.utils.attribute.AttrOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    // 参数列表
    @GetMapping("/{id}/attributes")
    public AttrListRes getAllAttributeByCategoryId(@PathVariable("id") Integer id,
                                                   @RequestParam("sel") String sel) {
        return attributeService.getAllAttributeByCategoryId(id, sel);
    }

    // 根据 ID 查询参数
    @GetMapping("/{id}/attributes/{attrId}")
    public AttrOneRes getAttributeById(@PathVariable("id") Integer cid,
                                       @PathVariable("attrId") Integer aid,
                                       @RequestParam("attr_sel") String sel) {
//        System.out.println(cid + " " + aid + " " + sel);
        return attributeService.getAttributeById(cid, aid, sel);
    }

    // 添加动态参数或者静态属性
    @PostMapping("/{id}/attributes")
    public AttrOneRes addAttribute(@PathVariable("id") Integer cid,
                                   @RequestBody Attribute attribute) {
        return attributeService.addAttribute(cid, attribute.getAttr_name(), attribute.getAttr_sel(), attribute.getAttr_vals());
    }

    // 删除参数
    @DeleteMapping("/{id}/attributes/{attrid}")
    public AttrOneRes deleteAttributeById(@PathVariable("id") Integer cid,
                               @PathVariable("attrid") Integer aid) {
        return attributeService.deleteAttributeById(cid, aid);
    }

    // 编辑提交参数
    @PutMapping("/{id}/attributes/{attrId}")
    public AttrOneRes updateAttributeById(@PathVariable("id") Integer cid,
                                          @PathVariable("attrId") Integer aid,
                                          @RequestBody Attribute attribute) {

        return attributeService.updateAttributeById(cid, aid, attribute.getAttr_name(),
                attribute.getAttr_sel(), attribute.getAttr_vals());
    }
}
