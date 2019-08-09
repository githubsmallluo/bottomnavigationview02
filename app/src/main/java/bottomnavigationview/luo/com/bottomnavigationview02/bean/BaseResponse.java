package bottomnavigationview.luo.com.bottomnavigationview02.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/7/12.
 */

public class BaseResponse {
    /**
     * errno : 0
     * errmsg : 正常
     * consume : 25
     * total : 204
     * data : ***
     */

    private String errno;
    private String errmsg;
    private String consume;
    private String total;
    private List<DataBean> data;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pid : 286730
         * cid : 1
         * dl_cnt : 0
         * c_t : 2014-11-28 01:00:01
         * imgcut : 0
         * url : http://p3.qhimg.com/bdr/__85/d/_sjzs/didaxianshi141120/141101022926.jpg
         * tempdata :
         * fav_total : 8670
         */

        private String pid;
        private String cid;
        private String dl_cnt;
        private String c_t;
        private String imgcut;
        private String url;
        private String tempdata;
        private String fav_total;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getDl_cnt() {
            return dl_cnt;
        }

        public void setDl_cnt(String dl_cnt) {
            this.dl_cnt = dl_cnt;
        }

        public String getC_t() {
            return c_t;
        }

        public void setC_t(String c_t) {
            this.c_t = c_t;
        }

        public String getImgcut() {
            return imgcut;
        }

        public void setImgcut(String imgcut) {
            this.imgcut = imgcut;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTempdata() {
            return tempdata;
        }

        public void setTempdata(String tempdata) {
            this.tempdata = tempdata;
        }

        public String getFav_total() {
            return fav_total;
        }

        public void setFav_total(String fav_total) {
            this.fav_total = fav_total;
        }
    }
}
