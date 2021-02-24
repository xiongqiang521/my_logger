package com.xq.logest.annotation;

/**
 *
 * @author XQ
 * @version v1.0
 * 2020/9/26 13:49
 */
public enum MethodTime {
    /**
     * 进入方法前
     */
    BEFORE((byte) 0),
    /**
     * 出方法后
     */
    AFTER((byte) 1),
    /**
     * 方法执行异常时
     */
    EXEC((byte) 2);

    private byte type;

    MethodTime(byte type) {
        this.type = type;
    }


    public byte getType() {
        return this.type;
    }

}
