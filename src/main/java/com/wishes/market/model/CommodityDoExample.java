package com.wishes.market.model;

import com.wishes.market.utils.PageDto;
import java.util.ArrayList;
import java.util.List;

public class CommodityDoExample {
    /**
     * t_business_commodity
     */
    protected String orderByClause;

    /**
     * t_business_commodity
     */
    protected boolean distinct;

    /**
     * t_business_commodity
     */
    protected List<Criteria> oredCriteria;

    /**
     * t_business_commodity
     */
    protected PageDto pageDto;

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public CommodityDoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public void setPageDto(PageDto pageDto) {
        this.pageDto=pageDto;
    }

    /**
     *
     * @mbg.generated 2019-04-01
     */
    public PageDto getPageDto() {
        return pageDto;
    }

    /**
     * t_business_commodity 2019-04-01
     */
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNull() {
            addCriterion("commodity_name is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNotNull() {
            addCriterion("commodity_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameEqualTo(String value) {
            addCriterion("commodity_name =", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotEqualTo(String value) {
            addCriterion("commodity_name <>", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThan(String value) {
            addCriterion("commodity_name >", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_name >=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThan(String value) {
            addCriterion("commodity_name <", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThanOrEqualTo(String value) {
            addCriterion("commodity_name <=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLike(String value) {
            addCriterion("commodity_name like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotLike(String value) {
            addCriterion("commodity_name not like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIn(List<String> values) {
            addCriterion("commodity_name in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotIn(List<String> values) {
            addCriterion("commodity_name not in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameBetween(String value1, String value2) {
            addCriterion("commodity_name between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotBetween(String value1, String value2) {
            addCriterion("commodity_name not between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeIsNull() {
            addCriterion("commodity_type is null");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeIsNotNull() {
            addCriterion("commodity_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeEqualTo(Integer value) {
            addCriterion("commodity_type =", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotEqualTo(Integer value) {
            addCriterion("commodity_type <>", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeGreaterThan(Integer value) {
            addCriterion("commodity_type >", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_type >=", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeLessThan(Integer value) {
            addCriterion("commodity_type <", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_type <=", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeIn(List<Integer> values) {
            addCriterion("commodity_type in", values, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotIn(List<Integer> values) {
            addCriterion("commodity_type not in", values, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeBetween(Integer value1, Integer value2) {
            addCriterion("commodity_type between", value1, value2, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_type not between", value1, value2, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNull() {
            addCriterion("commodity_price is null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNotNull() {
            addCriterion("commodity_price is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceEqualTo(Double value) {
            addCriterion("commodity_price =", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotEqualTo(Double value) {
            addCriterion("commodity_price <>", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThan(Double value) {
            addCriterion("commodity_price >", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("commodity_price >=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThan(Double value) {
            addCriterion("commodity_price <", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThanOrEqualTo(Double value) {
            addCriterion("commodity_price <=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIn(List<Double> values) {
            addCriterion("commodity_price in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotIn(List<Double> values) {
            addCriterion("commodity_price not in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceBetween(Double value1, Double value2) {
            addCriterion("commodity_price between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotBetween(Double value1, Double value2) {
            addCriterion("commodity_price not between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalIsNull() {
            addCriterion("commodity_total is null");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalIsNotNull() {
            addCriterion("commodity_total is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalEqualTo(Long value) {
            addCriterion("commodity_total =", value, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalNotEqualTo(Long value) {
            addCriterion("commodity_total <>", value, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalGreaterThan(Long value) {
            addCriterion("commodity_total >", value, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("commodity_total >=", value, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalLessThan(Long value) {
            addCriterion("commodity_total <", value, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalLessThanOrEqualTo(Long value) {
            addCriterion("commodity_total <=", value, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalIn(List<Long> values) {
            addCriterion("commodity_total in", values, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalNotIn(List<Long> values) {
            addCriterion("commodity_total not in", values, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalBetween(Long value1, Long value2) {
            addCriterion("commodity_total between", value1, value2, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalNotBetween(Long value1, Long value2) {
            addCriterion("commodity_total not between", value1, value2, "commodityTotal");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusIsNull() {
            addCriterion("commodity_surplus is null");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusIsNotNull() {
            addCriterion("commodity_surplus is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusEqualTo(Long value) {
            addCriterion("commodity_surplus =", value, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusNotEqualTo(Long value) {
            addCriterion("commodity_surplus <>", value, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusGreaterThan(Long value) {
            addCriterion("commodity_surplus >", value, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusGreaterThanOrEqualTo(Long value) {
            addCriterion("commodity_surplus >=", value, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusLessThan(Long value) {
            addCriterion("commodity_surplus <", value, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusLessThanOrEqualTo(Long value) {
            addCriterion("commodity_surplus <=", value, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusIn(List<Long> values) {
            addCriterion("commodity_surplus in", values, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusNotIn(List<Long> values) {
            addCriterion("commodity_surplus not in", values, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusBetween(Long value1, Long value2) {
            addCriterion("commodity_surplus between", value1, value2, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andCommoditySurplusNotBetween(Long value1, Long value2) {
            addCriterion("commodity_surplus not between", value1, value2, "commoditySurplus");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    /**
     * t_business_commodity
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_business_commodity 2019-04-01
     */
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