package org.loversAPP.model;

import java.util.ArrayList;
import java.util.List;

public class ActivityrecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityrecordsExample() {
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

        public Criteria andLoveridIsNull() {
            addCriterion("loverID is null");
            return (Criteria) this;
        }

        public Criteria andLoveridIsNotNull() {
            addCriterion("loverID is not null");
            return (Criteria) this;
        }

        public Criteria andLoveridEqualTo(String value) {
            addCriterion("loverID =", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridNotEqualTo(String value) {
            addCriterion("loverID <>", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridGreaterThan(String value) {
            addCriterion("loverID >", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridGreaterThanOrEqualTo(String value) {
            addCriterion("loverID >=", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridLessThan(String value) {
            addCriterion("loverID <", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridLessThanOrEqualTo(String value) {
            addCriterion("loverID <=", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridLike(String value) {
            addCriterion("loverID like", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridNotLike(String value) {
            addCriterion("loverID not like", value, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridIn(List<String> values) {
            addCriterion("loverID in", values, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridNotIn(List<String> values) {
            addCriterion("loverID not in", values, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridBetween(String value1, String value2) {
            addCriterion("loverID between", value1, value2, "loverid");
            return (Criteria) this;
        }

        public Criteria andLoveridNotBetween(String value1, String value2) {
            addCriterion("loverID not between", value1, value2, "loverid");
            return (Criteria) this;
        }

        public Criteria andTotalstepsIsNull() {
            addCriterion("totalSteps is null");
            return (Criteria) this;
        }

        public Criteria andTotalstepsIsNotNull() {
            addCriterion("totalSteps is not null");
            return (Criteria) this;
        }

        public Criteria andTotalstepsEqualTo(Integer value) {
            addCriterion("totalSteps =", value, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsNotEqualTo(Integer value) {
            addCriterion("totalSteps <>", value, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsGreaterThan(Integer value) {
            addCriterion("totalSteps >", value, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalSteps >=", value, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsLessThan(Integer value) {
            addCriterion("totalSteps <", value, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsLessThanOrEqualTo(Integer value) {
            addCriterion("totalSteps <=", value, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsIn(List<Integer> values) {
            addCriterion("totalSteps in", values, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsNotIn(List<Integer> values) {
            addCriterion("totalSteps not in", values, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsBetween(Integer value1, Integer value2) {
            addCriterion("totalSteps between", value1, value2, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andTotalstepsNotBetween(Integer value1, Integer value2) {
            addCriterion("totalSteps not between", value1, value2, "totalsteps");
            return (Criteria) this;
        }

        public Criteria andRadiusIsNull() {
            addCriterion("radius is null");
            return (Criteria) this;
        }

        public Criteria andRadiusIsNotNull() {
            addCriterion("radius is not null");
            return (Criteria) this;
        }

        public Criteria andRadiusEqualTo(Integer value) {
            addCriterion("radius =", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotEqualTo(Integer value) {
            addCriterion("radius <>", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusGreaterThan(Integer value) {
            addCriterion("radius >", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusGreaterThanOrEqualTo(Integer value) {
            addCriterion("radius >=", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLessThan(Integer value) {
            addCriterion("radius <", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLessThanOrEqualTo(Integer value) {
            addCriterion("radius <=", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusIn(List<Integer> values) {
            addCriterion("radius in", values, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotIn(List<Integer> values) {
            addCriterion("radius not in", values, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusBetween(Integer value1, Integer value2) {
            addCriterion("radius between", value1, value2, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotBetween(Integer value1, Integer value2) {
            addCriterion("radius not between", value1, value2, "radius");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIsNull() {
            addCriterion("longtitude is null");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIsNotNull() {
            addCriterion("longtitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongtitudeEqualTo(String value) {
            addCriterion("longtitude =", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotEqualTo(String value) {
            addCriterion("longtitude <>", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeGreaterThan(String value) {
            addCriterion("longtitude >", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longtitude >=", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLessThan(String value) {
            addCriterion("longtitude <", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLessThanOrEqualTo(String value) {
            addCriterion("longtitude <=", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLike(String value) {
            addCriterion("longtitude like", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotLike(String value) {
            addCriterion("longtitude not like", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIn(List<String> values) {
            addCriterion("longtitude in", values, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotIn(List<String> values) {
            addCriterion("longtitude not in", values, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeBetween(String value1, String value2) {
            addCriterion("longtitude between", value1, value2, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotBetween(String value1, String value2) {
            addCriterion("longtitude not between", value1, value2, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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