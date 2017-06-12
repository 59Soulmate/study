package com.sd.entity;

/**
 * Created by sd-kf on 2017/6/10.
 */
public class Menu {
    private Integer m_id;
    private String m_name;
    private Integer m_fid;
    private String m_fun;
    private String m_describe;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public Integer getM_fid() {
        return m_fid;
    }

    public void setM_fid(Integer m_fid) {
        this.m_fid = m_fid;
    }

    public String getM_fun() {
        return m_fun;
    }

    public void setM_fun(String m_fun) {
        this.m_fun = m_fun;
    }

    public String getM_describe() {
        return m_describe;
    }

    public void setM_describe(String m_describe) {
        this.m_describe = m_describe;
    }
}
