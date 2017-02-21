package org.loversAPP.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("msgType is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("msgType is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("msgType =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("msgType <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("msgType >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("msgType >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("msgType <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("msgType <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("msgType like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("msgType not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("msgType in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("msgType not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("msgType between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("msgType not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgdateIsNull() {
            addCriterion("msgDate is null");
            return (Criteria) this;
        }

        public Criteria andMsgdateIsNotNull() {
            addCriterion("msgDate is not null");
            return (Criteria) this;
        }

        public Criteria andMsgdateEqualTo(Date value) {
            addCriterion("msgDate =", value, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateNotEqualTo(Date value) {
            addCriterion("msgDate <>", value, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateGreaterThan(Date value) {
            addCriterion("msgDate >", value, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateGreaterThanOrEqualTo(Date value) {
            addCriterion("msgDate >=", value, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateLessThan(Date value) {
            addCriterion("msgDate <", value, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateLessThanOrEqualTo(Date value) {
            addCriterion("msgDate <=", value, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateIn(List<Date> values) {
            addCriterion("msgDate in", values, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateNotIn(List<Date> values) {
            addCriterion("msgDate not in", values, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateBetween(Date value1, Date value2) {
            addCriterion("msgDate between", value1, value2, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgdateNotBetween(Date value1, Date value2) {
            addCriterion("msgDate not between", value1, value2, "msgdate");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIsNull() {
            addCriterion("msgContent is null");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIsNotNull() {
            addCriterion("msgContent is not null");
            return (Criteria) this;
        }

        public Criteria andMsgcontentEqualTo(String value) {
            addCriterion("msgContent =", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotEqualTo(String value) {
            addCriterion("msgContent <>", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentGreaterThan(String value) {
            addCriterion("msgContent >", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentGreaterThanOrEqualTo(String value) {
            addCriterion("msgContent >=", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLessThan(String value) {
            addCriterion("msgContent <", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLessThanOrEqualTo(String value) {
            addCriterion("msgContent <=", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLike(String value) {
            addCriterion("msgContent like", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotLike(String value) {
            addCriterion("msgContent not like", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIn(List<String> values) {
            addCriterion("msgContent in", values, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotIn(List<String> values) {
            addCriterion("msgContent not in", values, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentBetween(String value1, String value2) {
            addCriterion("msgContent between", value1, value2, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotBetween(String value1, String value2) {
            addCriterion("msgContent not between", value1, value2, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNull() {
            addCriterion("receiverID is null");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNotNull() {
            addCriterion("receiverID is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveridEqualTo(Integer value) {
            addCriterion("receiverID =", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotEqualTo(Integer value) {
            addCriterion("receiverID <>", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThan(Integer value) {
            addCriterion("receiverID >", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiverID >=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThan(Integer value) {
            addCriterion("receiverID <", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThanOrEqualTo(Integer value) {
            addCriterion("receiverID <=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIn(List<Integer> values) {
            addCriterion("receiverID in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotIn(List<Integer> values) {
            addCriterion("receiverID not in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridBetween(Integer value1, Integer value2) {
            addCriterion("receiverID between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotBetween(Integer value1, Integer value2) {
            addCriterion("receiverID not between", value1, value2, "receiverid");
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