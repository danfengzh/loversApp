package org.loversAPP.model;

import java.util.ArrayList;
import java.util.List;

public class LoverSigninExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoverSigninExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHalfidIsNull() {
            addCriterion("halfID is null");
            return (Criteria) this;
        }

        public Criteria andHalfidIsNotNull() {
            addCriterion("halfID is not null");
            return (Criteria) this;
        }

        public Criteria andHalfidEqualTo(Integer value) {
            addCriterion("halfID =", value, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidNotEqualTo(Integer value) {
            addCriterion("halfID <>", value, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidGreaterThan(Integer value) {
            addCriterion("halfID >", value, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidGreaterThanOrEqualTo(Integer value) {
            addCriterion("halfID >=", value, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidLessThan(Integer value) {
            addCriterion("halfID <", value, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidLessThanOrEqualTo(Integer value) {
            addCriterion("halfID <=", value, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidIn(List<Integer> values) {
            addCriterion("halfID in", values, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidNotIn(List<Integer> values) {
            addCriterion("halfID not in", values, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidBetween(Integer value1, Integer value2) {
            addCriterion("halfID between", value1, value2, "halfid");
            return (Criteria) this;
        }

        public Criteria andHalfidNotBetween(Integer value1, Integer value2) {
            addCriterion("halfID not between", value1, value2, "halfid");
            return (Criteria) this;
        }

        public Criteria andSignintimeIsNull() {
            addCriterion("signinTime is null");
            return (Criteria) this;
        }

        public Criteria andSignintimeIsNotNull() {
            addCriterion("signinTime is not null");
            return (Criteria) this;
        }

        public Criteria andSignintimeEqualTo(String value) {
            addCriterion("signinTime =", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotEqualTo(String value) {
            addCriterion("signinTime <>", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeGreaterThan(String value) {
            addCriterion("signinTime >", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeGreaterThanOrEqualTo(String value) {
            addCriterion("signinTime >=", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLessThan(String value) {
            addCriterion("signinTime <", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLessThanOrEqualTo(String value) {
            addCriterion("signinTime <=", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLike(String value) {
            addCriterion("signinTime like", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotLike(String value) {
            addCriterion("signinTime not like", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeIn(List<String> values) {
            addCriterion("signinTime in", values, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotIn(List<String> values) {
            addCriterion("signinTime not in", values, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeBetween(String value1, String value2) {
            addCriterion("signinTime between", value1, value2, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotBetween(String value1, String value2) {
            addCriterion("signinTime not between", value1, value2, "signintime");
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