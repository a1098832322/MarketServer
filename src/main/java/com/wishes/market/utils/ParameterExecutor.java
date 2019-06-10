package com.wishes.market.utils;

import com.zl.utils.BaseChainExecutor;
import com.zl.utils.BaseChainOfResponsibility;
import org.apache.commons.lang3.StringUtils;

/**
 * 对需要验证的参数进行相应的处理
 *
 * @author 郑龙
 * @date 2019/5/29 9:13
 */
public class ParameterExecutor extends BaseChainExecutor {
    /**
     * 私有化构造方法，仅能使用createExecutor方法创建对象
     */
    private ParameterExecutor() {
    }

    /**
     * 创建执行器(不附带参数提示)
     *
     * @return ParameterExecutor执行器
     */
    public static ParameterExecutor createExecutor() {
        return createExecutor("");
    }

    /**
     * 创建执行器(附带参数提示)
     */
    public static ParameterExecutor createExecutor(String warningMessage) {
        ParameterExecutor executor = new ParameterExecutor();
        executor.addHandler(new DoubleHandler(warningMessage), new LongHandler(warningMessage)
                , new IntegerHandler(warningMessage), new StringHandler(warningMessage)
                , new DefaultHandler(warningMessage), new NullHandler(warningMessage));
        return executor;
    }

    /**
     * Double 类型处理器
     */
    public static class DoubleHandler extends BaseChainOfResponsibility {
        public DoubleHandler() {
        }

        public DoubleHandler(String name) {
            super(name);
        }

        /**
         * 责任划分标准
         *
         * @param obj 目标参数
         * @return true/false
         */
        @Override
        public boolean accept(Object obj) {
            return obj instanceof Double;
        }

        /**
         * 相应处理方法
         */
        @Override
        public void execute(Object obj) {
            if (obj == null || (Double) obj <= 0) {
                throw new IllegalArgumentException("参数" + this.getName() + "不能为空且不能小于等于0！");
            }
        }
    }

    /**
     * Long 类型处理器
     */
    public static class LongHandler extends BaseChainOfResponsibility {
        public LongHandler() {
        }

        public LongHandler(String name) {
            super(name);
        }

        /**
         * 责任划分标准
         *
         * @param obj 目标参数
         * @return true/false
         */
        @Override
        public boolean accept(Object obj) {
            return obj instanceof Long;
        }

        /**
         * 相应处理方法
         */
        @Override
        public void execute(Object obj) {
            if (obj == null || (Long) obj <= 0) {
                throw new IllegalArgumentException("参数" + this.getName() + "不能为空且不能小于等于0！");
            }
        }
    }

    /**
     * Integer 类型处理器
     */
    public static class IntegerHandler extends BaseChainOfResponsibility {
        public IntegerHandler() {
        }

        public IntegerHandler(String name) {
            super(name);
        }

        /**
         * 责任划分标准
         *
         * @param obj 目标参数
         * @return true/false
         */
        @Override
        public boolean accept(Object obj) {
            return obj instanceof Integer;
        }

        /**
         * 相应处理方法
         */
        @Override
        public void execute(Object obj) {
            if (obj == null || (Integer) obj <= 0) {
                throw new IllegalArgumentException("参数" + this.getName() + "不能为空且不能小于等于0！");
            }
        }
    }

    /**
     * String 类型处理器
     */
    public static class StringHandler extends BaseChainOfResponsibility {
        public StringHandler() {
        }

        public StringHandler(String name) {
            super(name);
        }

        /**
         * 责任划分标准
         *
         * @param obj 目标参数
         * @return true/false
         */
        @Override
        public boolean accept(Object obj) {
            return obj instanceof String;
        }

        /**
         * 相应处理方法
         */
        @Override
        public void execute(Object obj) {
            if (obj == null || StringUtils.isBlank(obj.toString())) {
                throw new IllegalArgumentException("参数" + this.getName() + "不能为空！");
            }
        }
    }

    /**
     * 其他类型处理器
     */
    public static class DefaultHandler extends BaseChainOfResponsibility {
        public DefaultHandler() {
        }

        public DefaultHandler(String name) {
            super(name);
        }

        /**
         * 责任划分标准
         *
         * @param obj 目标参数
         * @return true/false
         */
        @Override
        public boolean accept(Object obj) {
            return !(obj instanceof String) &&
                    !(obj instanceof Double) &&
                    !(obj instanceof Long) &&
                    !(obj instanceof Integer);
        }

        /**
         * 相应处理方法
         */
        @Override
        public void execute(Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("参数" + this.getName() + "不能为空！");
            }
        }
    }
}
