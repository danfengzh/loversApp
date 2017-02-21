package org.loversAPP.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MomentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MomentExample() {
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

        public Criteria andMomenttypeIsNull() {
            addCriterion("momentType is null");
            return (Criteria) this;
        }

        public Criteria andMomenttypeIsNotNull() {
            addCriterion("momentType is not null");
            return (Criteria) this;
        }

        public Criteria andMomenttypeEqualTo(Integer value) {
            addCriterion("momentType =", value, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeNotEqualTo(Integer value) {
            addCriterion("momentType <>", value, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeGreaterThan(Integer value) {
            addCriterion("momentType >", value, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("momentType >=", value, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeLessThan(Integer value) {
            addCriterion("momentType <", value, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeLessThanOrEqualTo(Integer value) {
            addCriterion("momentType <=", value, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeIn(List<Integer> values) {
            addCriterion("momentType in", values, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeNotIn(List<Integer> values) {
            addCriterion("momentType not in", values, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeBetween(Integer value1, Integer value2) {
            addCriterion("momentType between", value1, value2, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomenttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("momentType not between", value1, value2, "momenttype");
            return (Criteria) this;
        }

        public Criteria andMomentcontentIsNull() {
            addCriterion("momentContent is null");
            return (Criteria) this;
        }

        public Criteria andMomentcontentIsNotNull() {
            addCriterion("momentContent is not null");
            return (Criteria) this;
        }

        public Criteria andMomentcontentEqualTo(String value) {
            addCriterion("momentContent =", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentNotEqualTo(String value) {
            addCriterion("momentContent <>", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentGreaterThan(String value) {
            addCriterion("momentContent >", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentGreaterThanOrEqualTo(String value) {
            addCriterion("momentContent >=", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentLessThan(String value) {
            addCriterion("momentContent <", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentLessThanOrEqualTo(String value) {
            addCriterion("momentContent <=", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentLike(String value) {
            addCriterion("momentContent like", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentNotLike(String value) {
            addCriterion("momentContent not like", value, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentIn(List<String> values) {
            addCriterion("momentContent in", values, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentNotIn(List<String> values) {
            addCriterion("momentContent not in", values, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentBetween(String value1, String value2) {
            addCriterion("momentContent between", value1, value2, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentcontentNotBetween(String value1, String value2) {
            addCriterion("momentContent not between", value1, value2, "momentcontent");
            return (Criteria) this;
        }

        public Criteria andMomentimageIsNull() {
            addCriterion("momentImage is null");
            return (Criteria) this;
        }

        public Criteria andMomentimageIsNotNull() {
            addCriterion("momentImage is not null");
            return (Criteria) this;
        }

        public Criteria andMomentimageEqualTo(String value) {
            addCriterion("momentImage =", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageNotEqualTo(String value) {
            addCriterion("momentImage <>", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageGreaterThan(String value) {
            addCriterion("momentImage >", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageGreaterThanOrEqualTo(String value) {
            addCriterion("momentImage >=", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageLessThan(String value) {
            addCriterion("momentImage <", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageLessThanOrEqualTo(String value) {
            addCriterion("momentImage <=", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageLike(String value) {
            addCriterion("momentImage like", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageNotLike(String value) {
            addCriterion("momentImage not like", value, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageIn(List<String> values) {
            addCriterion("momentImage in", values, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageNotIn(List<String> values) {
            addCriterion("momentImage not in", values, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageBetween(String value1, String value2) {
            addCriterion("momentImage between", value1, value2, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentimageNotBetween(String value1, String value2) {
            addCriterion("momentImage not between", value1, value2, "momentimage");
            return (Criteria) this;
        }

        public Criteria andMomentdateIsNull() {
            addCriterion("momentDate is null");
            return (Criteria) this;
        }

        public Criteria andMomentdateIsNotNull() {
            addCriterion("momentDate is not null");
            return (Criteria) this;
        }

        public Criteria andMomentdateEqualTo(Date value) {
            addCriterion("momentDate =", value, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateNotEqualTo(Date value) {
            addCriterion("momentDate <>", value, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateGreaterThan(Date value) {
            addCriterion("momentDate >", value, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateGreaterThanOrEqualTo(Date value) {
            addCriterion("momentDate >=", value, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateLessThan(Date value) {
            addCriterion("momentDate <", value, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateLessThanOrEqualTo(Date value) {
            addCriterion("momentDate <=", value, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateIn(List<Date> values) {
            addCriterion("momentDate in", values, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateNotIn(List<Date> values) {
            addCriterion("momentDate not in", values, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateBetween(Date value1, Date value2) {
            addCriterion("momentDate between", value1, value2, "momentdate");
            return (Criteria) this;
        }

        public Criteria andMomentdateNotBetween(Date value1, Date value2) {
            addCriterion("momentDate not between", value1, value2, "momentdate");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNull() {
            addCriterion("commentID is null");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNotNull() {
            addCriterion("commentID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentidEqualTo(Integer value) {
            addCriterion("commentID =", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotEqualTo(Integer value) {
            addCriterion("commentID <>", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThan(Integer value) {
            addCriterion("commentID >", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentID >=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThan(Integer value) {
            addCriterion("commentID <", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThanOrEqualTo(Integer value) {
            addCriterion("commentID <=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidIn(List<Integer> values) {
            addCriterion("commentID in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotIn(List<Integer> values) {
            addCriterion("commentID not in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidBetween(Integer value1, Integer value2) {
            addCriterion("commentID between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotBetween(Integer value1, Integer value2) {
            addCriterion("commentID not between", value1, value2, "commentid");
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