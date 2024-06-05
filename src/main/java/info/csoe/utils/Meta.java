package info.csoe.utils;

public class Meta {
    private String msg;
    private Integer status;

    @Override
    public String toString() {
        return "Meta{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }

    public Meta() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Meta(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }
}
