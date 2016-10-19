package com.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
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

        public Criteria andDepIdIsNull() {
            addCriterion("dep_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("dep_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(Integer value) {
            addCriterion("dep_ID =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(Integer value) {
            addCriterion("dep_ID <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(Integer value) {
            addCriterion("dep_ID >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dep_ID >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(Integer value) {
            addCriterion("dep_ID <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(Integer value) {
            addCriterion("dep_ID <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<Integer> values) {
            addCriterion("dep_ID in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<Integer> values) {
            addCriterion("dep_ID not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(Integer value1, Integer value2) {
            addCriterion("dep_ID between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dep_ID not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("dep_name is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("dep_name =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("dep_name <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("dep_name >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("dep_name >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("dep_name <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("dep_name <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("dep_name like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("dep_name not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("dep_name in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("dep_name not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("dep_name between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("dep_name not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepDdIdIsNull() {
            addCriterion("dep_dd_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepDdIdIsNotNull() {
            addCriterion("dep_dd_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepDdIdEqualTo(String value) {
            addCriterion("dep_dd_ID =", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdNotEqualTo(String value) {
            addCriterion("dep_dd_ID <>", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdGreaterThan(String value) {
            addCriterion("dep_dd_ID >", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdGreaterThanOrEqualTo(String value) {
            addCriterion("dep_dd_ID >=", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdLessThan(String value) {
            addCriterion("dep_dd_ID <", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdLessThanOrEqualTo(String value) {
            addCriterion("dep_dd_ID <=", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdLike(String value) {
            addCriterion("dep_dd_ID like", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdNotLike(String value) {
            addCriterion("dep_dd_ID not like", value, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdIn(List<String> values) {
            addCriterion("dep_dd_ID in", values, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdNotIn(List<String> values) {
            addCriterion("dep_dd_ID not in", values, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdBetween(String value1, String value2) {
            addCriterion("dep_dd_ID between", value1, value2, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepDdIdNotBetween(String value1, String value2) {
            addCriterion("dep_dd_ID not between", value1, value2, "depDdId");
            return (Criteria) this;
        }

        public Criteria andDepParentidIsNull() {
            addCriterion("dep_parentid is null");
            return (Criteria) this;
        }

        public Criteria andDepParentidIsNotNull() {
            addCriterion("dep_parentid is not null");
            return (Criteria) this;
        }

        public Criteria andDepParentidEqualTo(String value) {
            addCriterion("dep_parentid =", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidNotEqualTo(String value) {
            addCriterion("dep_parentid <>", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidGreaterThan(String value) {
            addCriterion("dep_parentid >", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidGreaterThanOrEqualTo(String value) {
            addCriterion("dep_parentid >=", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidLessThan(String value) {
            addCriterion("dep_parentid <", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidLessThanOrEqualTo(String value) {
            addCriterion("dep_parentid <=", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidLike(String value) {
            addCriterion("dep_parentid like", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidNotLike(String value) {
            addCriterion("dep_parentid not like", value, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidIn(List<String> values) {
            addCriterion("dep_parentid in", values, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidNotIn(List<String> values) {
            addCriterion("dep_parentid not in", values, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidBetween(String value1, String value2) {
            addCriterion("dep_parentid between", value1, value2, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepParentidNotBetween(String value1, String value2) {
            addCriterion("dep_parentid not between", value1, value2, "depParentid");
            return (Criteria) this;
        }

        public Criteria andDepStateIsNull() {
            addCriterion("dep_state is null");
            return (Criteria) this;
        }

        public Criteria andDepStateIsNotNull() {
            addCriterion("dep_state is not null");
            return (Criteria) this;
        }

        public Criteria andDepStateEqualTo(String value) {
            addCriterion("dep_state =", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotEqualTo(String value) {
            addCriterion("dep_state <>", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateGreaterThan(String value) {
            addCriterion("dep_state >", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateGreaterThanOrEqualTo(String value) {
            addCriterion("dep_state >=", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateLessThan(String value) {
            addCriterion("dep_state <", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateLessThanOrEqualTo(String value) {
            addCriterion("dep_state <=", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateLike(String value) {
            addCriterion("dep_state like", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotLike(String value) {
            addCriterion("dep_state not like", value, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateIn(List<String> values) {
            addCriterion("dep_state in", values, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotIn(List<String> values) {
            addCriterion("dep_state not in", values, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateBetween(String value1, String value2) {
            addCriterion("dep_state between", value1, value2, "depState");
            return (Criteria) this;
        }

        public Criteria andDepStateNotBetween(String value1, String value2) {
            addCriterion("dep_state not between", value1, value2, "depState");
            return (Criteria) this;
        }
    }

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