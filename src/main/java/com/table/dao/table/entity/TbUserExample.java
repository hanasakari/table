package com.table.dao.table.entity;

import java.util.ArrayList;
import java.util.List;

public class TbUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public TbUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTbUserIdIsNull() {
            addCriterion("tb_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTbUserIdIsNotNull() {
            addCriterion("tb_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserIdEqualTo(String value) {
            addCriterion("tb_user_id =", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotEqualTo(String value) {
            addCriterion("tb_user_id <>", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdGreaterThan(String value) {
            addCriterion("tb_user_id >", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("tb_user_id >=", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdLessThan(String value) {
            addCriterion("tb_user_id <", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdLessThanOrEqualTo(String value) {
            addCriterion("tb_user_id <=", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdLike(String value) {
            addCriterion("tb_user_id like", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotLike(String value) {
            addCriterion("tb_user_id not like", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdIn(List<String> values) {
            addCriterion("tb_user_id in", values, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotIn(List<String> values) {
            addCriterion("tb_user_id not in", values, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdBetween(String value1, String value2) {
            addCriterion("tb_user_id between", value1, value2, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotBetween(String value1, String value2) {
            addCriterion("tb_user_id not between", value1, value2, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameIsNull() {
            addCriterion("tb_user_login_name is null");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameIsNotNull() {
            addCriterion("tb_user_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameEqualTo(String value) {
            addCriterion("tb_user_login_name =", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameNotEqualTo(String value) {
            addCriterion("tb_user_login_name <>", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameGreaterThan(String value) {
            addCriterion("tb_user_login_name >", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("tb_user_login_name >=", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameLessThan(String value) {
            addCriterion("tb_user_login_name <", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameLessThanOrEqualTo(String value) {
            addCriterion("tb_user_login_name <=", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameLike(String value) {
            addCriterion("tb_user_login_name like", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameNotLike(String value) {
            addCriterion("tb_user_login_name not like", value, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameIn(List<String> values) {
            addCriterion("tb_user_login_name in", values, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameNotIn(List<String> values) {
            addCriterion("tb_user_login_name not in", values, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameBetween(String value1, String value2) {
            addCriterion("tb_user_login_name between", value1, value2, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserLoginNameNotBetween(String value1, String value2) {
            addCriterion("tb_user_login_name not between", value1, value2, "tbUserLoginName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameIsNull() {
            addCriterion("tb_user_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameIsNotNull() {
            addCriterion("tb_user_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameEqualTo(String value) {
            addCriterion("tb_user_nick_name =", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameNotEqualTo(String value) {
            addCriterion("tb_user_nick_name <>", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameGreaterThan(String value) {
            addCriterion("tb_user_nick_name >", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("tb_user_nick_name >=", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameLessThan(String value) {
            addCriterion("tb_user_nick_name <", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("tb_user_nick_name <=", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameLike(String value) {
            addCriterion("tb_user_nick_name like", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameNotLike(String value) {
            addCriterion("tb_user_nick_name not like", value, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameIn(List<String> values) {
            addCriterion("tb_user_nick_name in", values, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameNotIn(List<String> values) {
            addCriterion("tb_user_nick_name not in", values, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameBetween(String value1, String value2) {
            addCriterion("tb_user_nick_name between", value1, value2, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserNickNameNotBetween(String value1, String value2) {
            addCriterion("tb_user_nick_name not between", value1, value2, "tbUserNickName");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltIsNull() {
            addCriterion("tb_user_password_salt is null");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltIsNotNull() {
            addCriterion("tb_user_password_salt is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltEqualTo(String value) {
            addCriterion("tb_user_password_salt =", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltNotEqualTo(String value) {
            addCriterion("tb_user_password_salt <>", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltGreaterThan(String value) {
            addCriterion("tb_user_password_salt >", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltGreaterThanOrEqualTo(String value) {
            addCriterion("tb_user_password_salt >=", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltLessThan(String value) {
            addCriterion("tb_user_password_salt <", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltLessThanOrEqualTo(String value) {
            addCriterion("tb_user_password_salt <=", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltLike(String value) {
            addCriterion("tb_user_password_salt like", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltNotLike(String value) {
            addCriterion("tb_user_password_salt not like", value, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltIn(List<String> values) {
            addCriterion("tb_user_password_salt in", values, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltNotIn(List<String> values) {
            addCriterion("tb_user_password_salt not in", values, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltBetween(String value1, String value2) {
            addCriterion("tb_user_password_salt between", value1, value2, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordSaltNotBetween(String value1, String value2) {
            addCriterion("tb_user_password_salt not between", value1, value2, "tbUserPasswordSalt");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordIsNull() {
            addCriterion("tb_user_password is null");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordIsNotNull() {
            addCriterion("tb_user_password is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordEqualTo(String value) {
            addCriterion("tb_user_password =", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordNotEqualTo(String value) {
            addCriterion("tb_user_password <>", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordGreaterThan(String value) {
            addCriterion("tb_user_password >", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("tb_user_password >=", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordLessThan(String value) {
            addCriterion("tb_user_password <", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("tb_user_password <=", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordLike(String value) {
            addCriterion("tb_user_password like", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordNotLike(String value) {
            addCriterion("tb_user_password not like", value, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordIn(List<String> values) {
            addCriterion("tb_user_password in", values, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordNotIn(List<String> values) {
            addCriterion("tb_user_password not in", values, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordBetween(String value1, String value2) {
            addCriterion("tb_user_password between", value1, value2, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserPasswordNotBetween(String value1, String value2) {
            addCriterion("tb_user_password not between", value1, value2, "tbUserPassword");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleIsNull() {
            addCriterion("tb_user_role is null");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleIsNotNull() {
            addCriterion("tb_user_role is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleEqualTo(Byte value) {
            addCriterion("tb_user_role =", value, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleNotEqualTo(Byte value) {
            addCriterion("tb_user_role <>", value, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleGreaterThan(Byte value) {
            addCriterion("tb_user_role >", value, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("tb_user_role >=", value, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleLessThan(Byte value) {
            addCriterion("tb_user_role <", value, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleLessThanOrEqualTo(Byte value) {
            addCriterion("tb_user_role <=", value, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleIn(List<Byte> values) {
            addCriterion("tb_user_role in", values, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleNotIn(List<Byte> values) {
            addCriterion("tb_user_role not in", values, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleBetween(Byte value1, Byte value2) {
            addCriterion("tb_user_role between", value1, value2, "tbUserRole");
            return (Criteria) this;
        }

        public Criteria andTbUserRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("tb_user_role not between", value1, value2, "tbUserRole");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}