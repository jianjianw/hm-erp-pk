package com.qiein.erp.pk.constant;

/**
 * 常用String常量
 */
public class CommonConstant {

    /**
     * 默认企业ID
     */
    public final static int DEFAULT_COMPID = 0;

    /**
     * 参数代表-是
     */
    public final static String FLAG_YES = "1";

    /**
     * 空字符串
     */
    public final static String NULL_STR = "";

    /**
     * 用户验证码
     */
    public final static String USER_VERIFY_CODE = "userVerifyCode";

    /**
     * 用户登录错误次数
     */
    public final static String USER_LOGIN_ERR_NUM = "userLoginErrNum";

    /**
     * 当前登录用户
     */
    public final static String CURRENT_LOGIN_STAFF = "currentLoginStaff";

    /**
     * jwt body
     */
    public final static String JWT_BODY = "jwtBody";

    /**
     * 测试环境
     */
    public final static String TEST = "test";

    /**
     * 开发环境
     */
    public final static String DEV = "dev";

    /**
     * 生产环境
     */
    public final static String PRO = "pro";

    /**
     * 验证参数。包含token uid cid
     */
    public final static String VERIFY_PARAM = "verifyParam";

    /**
     * token
     */
    public final static String TOKEN = "token";

    /**
     * uid
     */
    public final static String UID = "uid";

    /**
     * cid
     */
    public final static String CID = "cid";

    /**
     * 文件分隔符
     */
    public static final String FILE_SEPARATOR = "/";
    /**
     *
     */
    public static final String ADD_TO = "-->";

    /**
     * 多个参数字符串分隔符
     */
    public static final String STR_SEPARATOR = ",";

    /**
     * 横杠分割
     */
    public static final String ROD_SEPARATOR = "-";

    /*-- 编码方式 --*/
    public static final String ENCODING_GBK = "GBK";
    public static final String ENCODING_UTF8 = "UTF-8";
    public static final String ENCODING_ISO88591 = "ISO-8859-1";
    public static final String CHARSETNAME_DEFAULT = ENCODING_UTF8;

    /**
     * Excel导入默认备注
     */
    public static final String EXCEL_DEFAULT_REMARK = "<p>通过excel导入客资</p>";

    /**
     * 富文本前缀
     */
    public static final String RICH_TEXT_PREFIX = "<p>";

    /**
     * 富文本后缀
     */
    public static final String RICH_TEXT_SUFFIX = "</p>";

    /**
     * Excel导入默认拍摄类型
     */
    public static final String EXCEL_DEFAULT_PHOTO_TYPE_NAME = "婚纱照";

    /**
     * 默认领取客资超时时间
     */
    public static final int DEFAULT_OVERTIME = 120 * 60;

    /**
     * 默认客服领取客资时间间隔
     */
    public static final int DEFAULT_INTERVAL = 180 * 60;

    /**
     * 分配客资时依据历史分配情况的时间范围-秒
     */
    public static final int ALLOT_RANGE_DEFAULT = 60 * 60;

    /**
     * 非全量分配情况时对应的时间扩展增额-秒
     */
    public static final int ALLOT_RANGE_INTERVAL = 120 * 60;

    /**
     * 分配客资检索时的最大时间范围-秒
     */
    public static final int ALLOT_RANGE_MAX = 540 * 60;

    /**
     * 默认0
     */
    public final static int DEFAULT_ZERO = 0;
    /**
     * 默认字符串0
     */
    public final static String DEFAULT_STRING_ZERO = "0";
    /**
     * 默认成功返回值
     */
    public final static int DEFAULT_SUCCESS_CODE = 100000;

    /**
     * 默认错误返回值
     */
    public final static int DEFAULT_ERROR_CODE = 999999;
    /**
     * 登录错误时，增加
     */
    public final static int LOGIN_ERROR_ADD_NUM = 1;
    /**
     * 用户登录错误多少次出现验证码
     */
    public final static int ALLOW_USER_LOGIN_ERR_NUM = 3;

    /**
     * 用户登录错误次数过期时间，1小时
     */
    public final static int LOGIN_ERROR_NUM_EXPIRE_TIME = 1;

    /**
     * token过期时间，12小时
     */
    public final static int DEFAULT_EXPIRE_TIME = 12;

    /**
     * 在线时差查过120秒，默认当第一次上线
     */
    public final static int DEFAULT_ONLINE_TIME = 120;

    /**
     * 分页最大条数
     */
    public final static int MAX_PAGE_SIZE = 500;

    /**
     * 小组ID长度
     */
    public final static int GROUP_ID_LENGTH = 3;

    /**
     * 默认1
     */
    public final static int DEFAULT_ONE = 1;

    /**
     * request信息
     */
    public final static String REQUEST_INFO = "requestInfo";

    public final static int SYSTEM_OPERA_ID = 0;
    public final static String SYSTEM_OPERA_NAME = "草莓卷机器人";
    /**
     * 发送短信类型（预约进店）
     */
    public final static String YYJD = "yyjd";
    /**
     * 发送短信时判断使用门店电话还是客服电话
     */
    public final static String SELF = "self";
    /**
     * 转介绍以及电商待定自定义时的空数据处理
     */
    public final static String zdy = " ,,/,/,/,/,/,/,";

    /**
     * 合计
     */
    public final static String totalAll = "合计";
    /**
     * 电商渠道
     */
    public final static String DsSrc = "1,2";
    /**
     * 转介绍渠道
     */
    public final static String ZjsSrc = "3,4,5";
    /**
     * 草莓卷图标48px
     */
    public static final String CMJ_LOGO_IMG48 = "https://crm-jupiter.oss-cn-hangzhou.aliyuncs.com/img%2Flogo48.png";

    /**
     * 收款类型：2：尾款
     */
    public static final int CASH_TYPE_TAIL = 2;

    /**
     * 二维码
     */
    public static final String WECHAT_QRCODE = "二维码";
    /**
     * 三年的时间戳
     */
    public static final Integer THERE_YEAR_TIME=94608000;
    /**
     * 星期一到星期日全选
     */
    public static final String WEEK="1,2,3,4,5,6,7";

}