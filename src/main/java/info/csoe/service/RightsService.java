package info.csoe.service;

import info.csoe.bean.Rights;
import info.csoe.utils.rights.RightsRes;

import java.util.List;

public interface RightsService {
    RightsRes getAllRights(String type);
    RightsRes getMenus();
}
