package com.table.dao.table.entity;

import java.io.Serializable;

/**
 * tb_oauth2_client
 * @author 
 */
public class TbOauth2Client implements Serializable {
    /**
     * 客户端表ID
     */
    private String tbOauth2Id;

    /**
     * 客户端名
     */
    private String tbOauth2ClientName;

    /**
     * 客户端ID
     */
    private String tbOauth2ClientId;

    /**
     * 客户端密码
     */
    private String tbOauth2ClientSecret;

    private static final long serialVersionUID = 1L;

    public String getTbOauth2Id() {
        return tbOauth2Id;
    }

    public void setTbOauth2Id(String tbOauth2Id) {
        this.tbOauth2Id = tbOauth2Id;
    }

    public String getTbOauth2ClientName() {
        return tbOauth2ClientName;
    }

    public void setTbOauth2ClientName(String tbOauth2ClientName) {
        this.tbOauth2ClientName = tbOauth2ClientName;
    }

    public String getTbOauth2ClientId() {
        return tbOauth2ClientId;
    }

    public void setTbOauth2ClientId(String tbOauth2ClientId) {
        this.tbOauth2ClientId = tbOauth2ClientId;
    }

    public String getTbOauth2ClientSecret() {
        return tbOauth2ClientSecret;
    }

    public void setTbOauth2ClientSecret(String tbOauth2ClientSecret) {
        this.tbOauth2ClientSecret = tbOauth2ClientSecret;
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
        TbOauth2Client other = (TbOauth2Client) that;
        return (this.getTbOauth2Id() == null ? other.getTbOauth2Id() == null : this.getTbOauth2Id().equals(other.getTbOauth2Id()))
            && (this.getTbOauth2ClientName() == null ? other.getTbOauth2ClientName() == null : this.getTbOauth2ClientName().equals(other.getTbOauth2ClientName()))
            && (this.getTbOauth2ClientId() == null ? other.getTbOauth2ClientId() == null : this.getTbOauth2ClientId().equals(other.getTbOauth2ClientId()))
            && (this.getTbOauth2ClientSecret() == null ? other.getTbOauth2ClientSecret() == null : this.getTbOauth2ClientSecret().equals(other.getTbOauth2ClientSecret()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTbOauth2Id() == null) ? 0 : getTbOauth2Id().hashCode());
        result = prime * result + ((getTbOauth2ClientName() == null) ? 0 : getTbOauth2ClientName().hashCode());
        result = prime * result + ((getTbOauth2ClientId() == null) ? 0 : getTbOauth2ClientId().hashCode());
        result = prime * result + ((getTbOauth2ClientSecret() == null) ? 0 : getTbOauth2ClientSecret().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tbOauth2Id=").append(tbOauth2Id);
        sb.append(", tbOauth2ClientName=").append(tbOauth2ClientName);
        sb.append(", tbOauth2ClientId=").append(tbOauth2ClientId);
        sb.append(", tbOauth2ClientSecret=").append(tbOauth2ClientSecret);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}