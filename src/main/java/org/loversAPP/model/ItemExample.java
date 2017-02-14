package org.loversAPP.model;

import java.util.ArrayList;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
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

        public Criteria andItemnameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemnameEqualTo(String value) {
            addCriterion("itemName =", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThan(String value) {
            addCriterion("itemName <", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLike(String value) {
            addCriterion("itemName like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotLike(String value) {
            addCriterion("itemName not like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameIn(List<String> values) {
            addCriterion("itemName in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemfunctionIsNull() {
            addCriterion("itemFunction is null");
            return (Criteria) this;
        }

        public Criteria andItemfunctionIsNotNull() {
            addCriterion("itemFunction is not null");
            return (Criteria) this;
        }

        public Criteria andItemfunctionEqualTo(String value) {
            addCriterion("itemFunction =", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionNotEqualTo(String value) {
            addCriterion("itemFunction <>", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionGreaterThan(String value) {
            addCriterion("itemFunction >", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionGreaterThanOrEqualTo(String value) {
            addCriterion("itemFunction >=", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionLessThan(String value) {
            addCriterion("itemFunction <", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionLessThanOrEqualTo(String value) {
            addCriterion("itemFunction <=", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionLike(String value) {
            addCriterion("itemFunction like", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionNotLike(String value) {
            addCriterion("itemFunction not like", value, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionIn(List<String> values) {
            addCriterion("itemFunction in", values, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionNotIn(List<String> values) {
            addCriterion("itemFunction not in", values, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionBetween(String value1, String value2) {
            addCriterion("itemFunction between", value1, value2, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andItemfunctionNotBetween(String value1, String value2) {
            addCriterion("itemFunction not between", value1, value2, "itemfunction");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andItemimageIsNull() {
            addCriterion("itemImage is null");
            return (Criteria) this;
        }

        public Criteria andItemimageIsNotNull() {
            addCriterion("itemImage is not null");
            return (Criteria) this;
        }

        public Criteria andItemimageEqualTo(String value) {
            addCriterion("itemImage =", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageNotEqualTo(String value) {
            addCriterion("itemImage <>", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageGreaterThan(String value) {
            addCriterion("itemImage >", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageGreaterThanOrEqualTo(String value) {
            addCriterion("itemImage >=", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageLessThan(String value) {
            addCriterion("itemImage <", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageLessThanOrEqualTo(String value) {
            addCriterion("itemImage <=", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageLike(String value) {
            addCriterion("itemImage like", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageNotLike(String value) {
            addCriterion("itemImage not like", value, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageIn(List<String> values) {
            addCriterion("itemImage in", values, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageNotIn(List<String> values) {
            addCriterion("itemImage not in", values, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageBetween(String value1, String value2) {
            addCriterion("itemImage between", value1, value2, "itemimage");
            return (Criteria) this;
        }

        public Criteria andItemimageNotBetween(String value1, String value2) {
            addCriterion("itemImage not between", value1, value2, "itemimage");
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