package info.csoe.utils.manager;

import info.csoe.bean.Manager;

import java.util.List;

public class ManagerList {
    private Integer totalpage;
    private Integer pagenum;
    private List<Manager> users;

    public ManagerList(Integer totalpage, Integer pagenum, List<Manager> users) {
        this.totalpage = totalpage;
        this.pagenum = pagenum;
        this.users = users;
    }

    public ManagerList(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public List<Manager> getUsers() {
        return users;
    }

    public void setUsers(List<Manager> users) {
        this.users = users;
    }
}
