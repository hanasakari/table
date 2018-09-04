package com.table.dao.table.entity;

import java.util.ArrayList;
import java.util.List;

public class TbOauth2ClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TbOauth2ClientExample() {
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

        public Criteria andTbOauth2IdIsNull() {
            addCriterion("tb_oauth2_id is null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdIsNotNull() {
            addCriterion("tb_oauth2_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdEqualTo(String value) {
            addCriterion("tb_oauth2_id =", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdNotEqualTo(String value) {
            addCriterion("tb_oauth2_id <>", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdGreaterThan(String value) {
            addCriterion("tb_oauth2_id >", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdGreaterThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_id >=", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdLessThan(String value) {
            addCriterion("tb_oauth2_id <", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdLessThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_id <=", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdLike(String value) {
            addCriterion("tb_oauth2_id like", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdNotLike(String value) {
            addCriterion("tb_oauth2_id not like", value, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdIn(List<String> values) {
            addCriterion("tb_oauth2_id in", values, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdNotIn(List<String> values) {
            addCriterion("tb_oauth2_id not in", values, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdBetween(String value1, String value2) {
            addCriterion("tb_oauth2_id between", value1, value2, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2IdNotBetween(String value1, String value2) {
            addCriterion("tb_oauth2_id not between", value1, value2, "tbOauth2Id");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameIsNull() {
            addCriterion("tb_oauth2_client_name is null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameIsNotNull() {
            addCriterion("tb_oauth2_client_name is not null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameEqualTo(String value) {
            addCriterion("tb_oauth2_client_name =", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameNotEqualTo(String value) {
            addCriterion("tb_oauth2_client_name <>", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameGreaterThan(String value) {
            addCriterion("tb_oauth2_client_name >", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_client_name >=", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameLessThan(String value) {
            addCriterion("tb_oauth2_client_name <", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameLessThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_client_name <=", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameLike(String value) {
            addCriterion("tb_oauth2_client_name like", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameNotLike(String value) {
            addCriterion("tb_oauth2_client_name not like", value, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameIn(List<String> values) {
            addCriterion("tb_oauth2_client_name in", values, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameNotIn(List<String> values) {
            addCriterion("tb_oauth2_client_name not in", values, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameBetween(String value1, String value2) {
            addCriterion("tb_oauth2_client_name between", value1, value2, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientNameNotBetween(String value1, String value2) {
            addCriterion("tb_oauth2_client_name not between", value1, value2, "tbOauth2ClientName");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdIsNull() {
            addCriterion("tb_oauth2_client_id is null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdIsNotNull() {
            addCriterion("tb_oauth2_client_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdEqualTo(String value) {
            addCriterion("tb_oauth2_client_id =", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdNotEqualTo(String value) {
            addCriterion("tb_oauth2_client_id <>", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdGreaterThan(String value) {
            addCriterion("tb_oauth2_client_id >", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_client_id >=", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdLessThan(String value) {
            addCriterion("tb_oauth2_client_id <", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdLessThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_client_id <=", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdLike(String value) {
            addCriterion("tb_oauth2_client_id like", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdNotLike(String value) {
            addCriterion("tb_oauth2_client_id not like", value, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdIn(List<String> values) {
            addCriterion("tb_oauth2_client_id in", values, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdNotIn(List<String> values) {
            addCriterion("tb_oauth2_client_id not in", values, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdBetween(String value1, String value2) {
            addCriterion("tb_oauth2_client_id between", value1, value2, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientIdNotBetween(String value1, String value2) {
            addCriterion("tb_oauth2_client_id not between", value1, value2, "tbOauth2ClientId");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretIsNull() {
            addCriterion("tb_oauth2_client_secret is null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretIsNotNull() {
            addCriterion("tb_oauth2_client_secret is not null");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretEqualTo(String value) {
            addCriterion("tb_oauth2_client_secret =", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretNotEqualTo(String value) {
            addCriterion("tb_oauth2_client_secret <>", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretGreaterThan(String value) {
            addCriterion("tb_oauth2_client_secret >", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretGreaterThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_client_secret >=", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretLessThan(String value) {
            addCriterion("tb_oauth2_client_secret <", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretLessThanOrEqualTo(String value) {
            addCriterion("tb_oauth2_client_secret <=", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretLike(String value) {
            addCriterion("tb_oauth2_client_secret like", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretNotLike(String value) {
            addCriterion("tb_oauth2_client_secret not like", value, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretIn(List<String> values) {
            addCriterion("tb_oauth2_client_secret in", values, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretNotIn(List<String> values) {
            addCriterion("tb_oauth2_client_secret not in", values, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretBetween(String value1, String value2) {
            addCriterion("tb_oauth2_client_secret between", value1, value2, "tbOauth2ClientSecret");
            return (Criteria) this;
        }

        public Criteria andTbOauth2ClientSecretNotBetween(String value1, String value2) {
            addCriterion("tb_oauth2_client_secret not between", value1, value2, "tbOauth2ClientSecret");
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