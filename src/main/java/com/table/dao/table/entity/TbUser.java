package com.table.dao.table.entity;

import java.io.Serializable;

/**
 * tb_user
 * @author 
 */
public class TbUser implements Serializable {
    /**
     * 用户UUID
     */
    private String tbUserId;

    /**
     * 用户登陆名
     */
    private String tbUserLoginName;

    /**
     * 用户昵称
     */
    private String tbUserNickName;

    /**
     * 用户密码盐
     */
    private String tbUserPasswordSalt;

    /**
     * 用户密码(为了保证Hash最长32位)
     */
    private String tbUserPassword;

    /**
     * 用户权限 0系统管理员 1后端管理 2数据管理
     */
    private Byte tbUserRole;

    private static final long serialVersionUID = 1L;

    public String getTbUserId() {
        return tbUserId;
    }

    public void setTbUserId(String tbUserId) {
        this.tbUserId = tbUserId;
    }

    public String getTbUserLoginName() {
        return tbUserLoginName;
    }

    public void setTbUserLoginName(String tbUserLoginName) {
        this.tbUserLoginName = tbUserLoginName;
    }

    public String getTbUserNickName() {
        return tbUserNickName;
    }

    public void setTbUserNickName(String tbUserNickName) {
        this.tbUserNickName = tbUserNickName;
    }

    public String getTbUserPasswordSalt() {
        return tbUserPasswordSalt;
    }

    public void setTbUserPasswordSalt(String tbUserPasswordSalt) {
        this.tbUserPasswordSalt = tbUserPasswordSalt;
    }

    public String getTbUserPassword() {
        return tbUserPassword;
    }

    public void setTbUserPassword(String tbUserPassword) {
        this.tbUserPassword = tbUserPassword;
    }

    public Byte getTbUserRole() {
        return tbUserRole;
    }

    public void setTbUserRole(Byte tbUserRole) {
        this.tbUserRole = tbUserRole;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbUser other = (TbUser) that;
        return (this.getTbUserId() == null ? other.getTbUserId() == null : this.getTbUserId().equals(other.getTbUserId()))
            && (this.getTbUserLoginName() == null ? other.getTbUserLoginName() == null : this.getTbUserLoginName().equals(other.getTbUserLoginName()))
            && (this.getTbUserNickName() == null ? other.getTbUserNickName() == null : this.getTbUserNickName().equals(other.getTbUserNickName()))
            && (this.getTbUserPasswordSalt() == null ? other.getTbUserPasswordSalt() == null : this.getTbUserPasswordSalt().equals(other.getTbUserPasswordSalt()))
            && (this.getTbUserPassword() == null ? other.getTbUserPassword() == null : this.getTbUserPassword().equals(other.getTbUserPassword()))
            && (this.getTbUserRole() == null ? other.getTbUserRole() == null : this.getTbUserRole().equals(other.getTbUserRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTbUserId() == null) ? 0 : getTbUserId().hashCode());
        result = prime * result + ((getTbUserLoginName() == null) ? 0 : getTbUserLoginName().hashCode());
        result = prime * result + ((getTbUserNickName() == null) ? 0 : getTbUserNickName().hashCode());
        result = prime * result + ((getTbUserPasswordSalt() == null) ? 0 : getTbUserPasswordSalt().hashCode());
        result = prime * result + ((getTbUserPassword() == null) ? 0 : getTbUserPassword().hashCode());
        result = prime * result + ((getTbUserRole() == null) ? 0 : getTbUserRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tbUserId=").append(tbUserId);
        sb.append(", tbUserLoginName=").append(tbUserLoginName);
        sb.append(", tbUserNickName=").append(tbUserNickName);
        sb.append(", tbUserPasswordSalt=").append(tbUserPasswordSalt);
        sb.append(", tbUserPassword=").append(tbUserPassword);
        sb.append(", tbUserRole=").append(tbUserRole);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}