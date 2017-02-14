package org.loversAPP.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoverShipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoverShipExample() {
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

        public Criteria andLovergirlidIsNull() {
            addCriterion("loverGirlID is null");
            return (Criteria) this;
        }

        public Criteria andLovergirlidIsNotNull() {
            addCriterion("loverGirlID is not null");
            return (Criteria) this;
        }

        public Criteria andLovergirlidEqualTo(Integer value) {
            addCriterion("loverGirlID =", value, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidNotEqualTo(Integer value) {
            addCriterion("loverGirlID <>", value, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidGreaterThan(Integer value) {
            addCriterion("loverGirlID >", value, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loverGirlID >=", value, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidLessThan(Integer value) {
            addCriterion("loverGirlID <", value, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidLessThanOrEqualTo(Integer value) {
            addCriterion("loverGirlID <=", value, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidIn(List<Integer> values) {
            addCriterion("loverGirlID in", values, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidNotIn(List<Integer> values) {
            addCriterion("loverGirlID not in", values, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidBetween(Integer value1, Integer value2) {
            addCriterion("loverGirlID between", value1, value2, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLovergirlidNotBetween(Integer value1, Integer value2) {
            addCriterion("loverGirlID not between", value1, value2, "lovergirlid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidIsNull() {
            addCriterion("loverBoyID is null");
            return (Criteria) this;
        }

        public Criteria andLoverboyidIsNotNull() {
            addCriterion("loverBoyID is not null");
            return (Criteria) this;
        }

        public Criteria andLoverboyidEqualTo(Integer value) {
            addCriterion("loverBoyID =", value, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidNotEqualTo(Integer value) {
            addCriterion("loverBoyID <>", value, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidGreaterThan(Integer value) {
            addCriterion("loverBoyID >", value, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loverBoyID >=", value, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidLessThan(Integer value) {
            addCriterion("loverBoyID <", value, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidLessThanOrEqualTo(Integer value) {
            addCriterion("loverBoyID <=", value, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidIn(List<Integer> values) {
            addCriterion("loverBoyID in", values, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidNotIn(List<Integer> values) {
            addCriterion("loverBoyID not in", values, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidBetween(Integer value1, Integer value2) {
            addCriterion("loverBoyID between", value1, value2, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLoverboyidNotBetween(Integer value1, Integer value2) {
            addCriterion("loverBoyID not between", value1, value2, "loverboyid");
            return (Criteria) this;
        }

        public Criteria andLovetimeIsNull() {
            addCriterion("loveTime is null");
            return (Criteria) this;
        }

        public Criteria andLovetimeIsNotNull() {
            addCriterion("loveTime is not null");
            return (Criteria) this;
        }

        public Criteria andLovetimeEqualTo(Date value) {
            addCriterion("loveTime =", value, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeNotEqualTo(Date value) {
            addCriterion("loveTime <>", value, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeGreaterThan(Date value) {
            addCriterion("loveTime >", value, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loveTime >=", value, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeLessThan(Date value) {
            addCriterion("loveTime <", value, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeLessThanOrEqualTo(Date value) {
            addCriterion("loveTime <=", value, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeIn(List<Date> values) {
            addCriterion("loveTime in", values, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeNotIn(List<Date> values) {
            addCriterion("loveTime not in", values, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeBetween(Date value1, Date value2) {
            addCriterion("loveTime between", value1, value2, "lovetime");
            return (Criteria) this;
        }

        public Criteria andLovetimeNotBetween(Date value1, Date value2) {
            addCriterion("loveTime not between", value1, value2, "lovetime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andCheckindaysIsNull() {
            addCriterion("checkinDays is null");
            return (Criteria) this;
        }

        public Criteria andCheckindaysIsNotNull() {
            addCriterion("checkinDays is not null");
            return (Criteria) this;
        }

        public Criteria andCheckindaysEqualTo(Integer value) {
            addCriterion("checkinDays =", value, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysNotEqualTo(Integer value) {
            addCriterion("checkinDays <>", value, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysGreaterThan(Integer value) {
            addCriterion("checkinDays >", value, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkinDays >=", value, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysLessThan(Integer value) {
            addCriterion("checkinDays <", value, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysLessThanOrEqualTo(Integer value) {
            addCriterion("checkinDays <=", value, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysIn(List<Integer> values) {
            addCriterion("checkinDays in", values, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysNotIn(List<Integer> values) {
            addCriterion("checkinDays not in", values, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysBetween(Integer value1, Integer value2) {
            addCriterion("checkinDays between", value1, value2, "checkindays");
            return (Criteria) this;
        }

        public Criteria andCheckindaysNotBetween(Integer value1, Integer value2) {
            addCriterion("checkinDays not between", value1, value2, "checkindays");
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