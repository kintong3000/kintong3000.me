package com.kintong.blogserver.commons.consts;

/**
 * @Author kintong
 */
public final class Const {
    //JWT令牌
    public final static String JWT_BLACK_LIST = "jwt:blacklist:";
    public final static String JWT_FREQUENCY = "jwt:frequency:";
    //请求频率限制
    public final static String FLOW_LIMIT_COUNTER = "flow:counter:";
    public final static String FLOW_LIMIT_BLOCK = "flow:block:";
    //邮件验证码
    public final static String VERIFY_EMAIL_LIMIT = "verify:email:limit:";
    public final static String VERIFY_EMAIL_DATA = "verify:email:data:";
    //过滤器优先级
    public final static int ORDER_FLOW_LIMIT = -101;
    public final static int ORDER_CORS = -102;
    //请求自定义属性
    public final static String ATTR_USER_ID = "userId";
    //消息队列
    public final static String MQ_MAIL = "mail";
    //用户角色
    public final static String ROLE_DEFAULT = "user";


    public final static String REQUEST_PARAM_BODY_STRING = "REQUEST_PARAM_BODY_STRING";
    public final static String PACKAGE_NAME = "com.bihell.dice";

    /**
     * 默认页码为1
     */
    public final static Integer DEFAULT_PAGE_INDEX = 1;

    /**
     * 默认页大小为10
     */
    public final static Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 分页总行数名称
     */
    public final static String PAGE_TOTAL_NAME = "total";

    /**
     * 分页数据列表名称
     */
    public final static String PAGE_RECORDS_NAME = "items";

    /**
     * 分页当前页码名称
     */
    public final static String PAGE_INDEX_NAME = "page";

    /**
     * 分页当前页大小名称
     */
    public final static String PAGE_SIZE_NAME = "pageSize";

    /**
     * 验证码token
     */
    public final static String VERIFY_TOKEN = "verifyToken";

    /**
     * 图片
     */
    public final static String IMAGE = "image";

    /**
     * JPEG
     */
    public final static String JPEG = "JPEG";

    /**
     * base64前缀
     */
    public final static String BASE64_PREFIX = "data:image/png;base64,";

    /**
     * ..
     */
    public final static String SPOT_SPOT = "..";

    /**
     * ../
     */
    public final static String SPOT_SPOT_BACKSLASH = "../";

    public final static String COMMA = ",";

    /**
     * 日志链路ID
     */
    public final static String TRACE_ID = "traceId";

    /**
     * 1000
     */
    public final static int ONE_THOUSAND = 1000;


}
