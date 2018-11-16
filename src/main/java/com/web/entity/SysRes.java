package com.web.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_res")
public class SysRes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "res_name")
    private String resName;

    @Column(name = "img_path_id")
    private Integer imgPathId;

    @Column(name = "res_path_id")
    private Integer resPathId;

    /**
     * 1 word 2 ppt 3 video 
     */
    @Column(name = "res_type")
    private String resType;

    @Column(name = "security_level")
    private String securityLevel;

    @Column(name = "autor_name")
    private String autorName;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 是否审核通过 0未通过 1通过
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 是否可用
     */
    @Column(name = "is_del")
    private String isDel;

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
     * @return img_path_id
     */
    public Integer getImgPathId() {
        return imgPathId;
    }

    /**
     * @param imgPathId
     */
    public void setImgPathId(Integer imgPathId) {
        this.imgPathId = imgPathId;
    }

    /**
     * @return res_path_id
     */
    public Integer getResPathId() {
        return resPathId;
    }

    /**
     * @param resPathId
     */
    public void setResPathId(Integer resPathId) {
        this.resPathId = resPathId;
    }

    /**
     * 获取1 word 2 ppt 3 video 
     *
     * @return res_type - 1 word 2 ppt 3 video 
     */
    public String getResType() {
        return resType;
    }

    /**
     * 设置1 word 2 ppt 3 video 
     *
     * @param resType 1 word 2 ppt 3 video 
     */
    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    /**
     * @return security_level
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * @param securityLevel
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel == null ? null : securityLevel.trim();
    }

    /**
     * @return autor_name
     */
    public String getAutorName() {
        return autorName;
    }

    /**
     * @param autorName
     */
    public void setAutorName(String autorName) {
        this.autorName = autorName == null ? null : autorName.trim();
    }

    /**
     * @return expiry_date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }

    /**
     * @return creator_id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取是否审核通过 0未通过 1通过
     *
     * @return audit_status - 是否审核通过 0未通过 1通过
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置是否审核通过 0未通过 1通过
     *
     * @param auditStatus 是否审核通过 0未通过 1通过
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 获取是否可用
     *
     * @return is_del - 是否可用
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 设置是否可用
     *
     * @param isDel 是否可用
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resName=").append(resName);
        sb.append(", imgPathId=").append(imgPathId);
        sb.append(", resPathId=").append(resPathId);
        sb.append(", resType=").append(resType);
        sb.append(", securityLevel=").append(securityLevel);
        sb.append(", autorName=").append(autorName);
        sb.append(", expiryDate=").append(expiryDate);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}