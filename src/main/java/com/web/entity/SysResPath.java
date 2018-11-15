package com.web.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_res_path")
public class SysResPath implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "res_name")
    private String resName;

    @Column(name = "res_path")
    private String resPath;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return res_name
     */
    public String getResName() {
        return resName;
    }

    /**
     * @param resName
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     * @return res_path
     */
    public String getResPath() {
        return resPath;
    }

    /**
     * @param resPath
     */
    public void setResPath(String resPath) {
        this.resPath = resPath == null ? null : resPath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resName=").append(resName);
        sb.append(", resPath=").append(resPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}