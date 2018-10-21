package ljx.com.weatherapp.model;

import java.io.Serializable;

public class Now implements Serializable {
    private int cloud;
    private int cond_code;
    private String cond_txt;
    private String cond_status;
    private int fl;
    private int tmp;
    private int tmp_min;
    private int tmp_max;
    private int hum;
    private double pcpn;
    private int pres;
    private int vis;
    private int wind_deg;
    private String wind_dir;
    private int wind_sc;
    private int wind_spd;
    private String updateTime;
    private int PM25;

    public Now() {
    }

    public int getPM25() {
        return PM25;
    }

    public void setPM25(int PM25) {
        this.PM25 = PM25;
    }

    public String getCond_status() {
        return cond_status;
    }

    public void setCond_status(String cond_status) {
        this.cond_status = cond_status;
    }

    public int getTmp_min() {
        return tmp_min;
    }

    public void setTmp_min(int tmp_min) {
        this.tmp_min = tmp_min;
    }

    public int getTmp_max() {
        return tmp_max;
    }

    public void setTmp_max(int tmp_max) {
        this.tmp_max = tmp_max;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public int getCond_code() {
        return cond_code;
    }

    public void setCond_code(int cond_code) {
        this.cond_code = cond_code;
    }

    public String getCond_txt() {
        return cond_txt;
    }

    public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }

    public int getFl() {
        return fl;
    }

    public void setFl(int fl) {
        this.fl = fl;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public double getPcpn() {
        return pcpn;
    }

    public void setPcpn(double pcpn) {
        this.pcpn = pcpn;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public int getVis() {
        return vis;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public int getWind_sc() {
        return wind_sc;
    }

    public void setWind_sc(int wind_sc) {
        this.wind_sc = wind_sc;
    }

    public int getWind_spd() {
        return wind_spd;
    }

    public void setWind_spd(int wind_spd) {
        this.wind_spd = wind_spd;
    }

    @Override
    public String toString() {
        return "Now{" +
                "cloud=" + cloud +
                ", cond_code=" + cond_code +
                ", cond_txt='" + cond_txt + '\'' +
                ", cond_status='" + cond_status + '\'' +
                ", fl=" + fl +
                ", tmp=" + tmp +
                ", tmp_min=" + tmp_min +
                ", tmp_max=" + tmp_max +
                ", hum=" + hum +
                ", pcpn=" + pcpn +
                ", pres=" + pres +
                ", vis=" + vis +
                ", wind_deg=" + wind_deg +
                ", wind_dir='" + wind_dir + '\'' +
                ", wind_sc=" + wind_sc +
                ", wind_spd=" + wind_spd +
                ", updateTime='" + updateTime + '\'' +
                ", PM25=" + PM25 +
                '}';
    }
}
