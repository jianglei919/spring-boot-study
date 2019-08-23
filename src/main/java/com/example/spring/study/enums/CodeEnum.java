package com.houbank.paydayloan.api.enums;

public enum CodeEnum {

    /**
     * 00    系统通用
     */
    SUCCESS("操作成功", "000000"),
    FAILED("操作失败", "100001"),
    Param("参数不正确", "100002"),
    InternetFail("网络异常", "100003"),
    MAXCOUNT("达到最大次数", "100004"),
    REPEAT("请不要重复操作", "100005"),
    URL_FAIL("无访问权限", "100006"),
    NOT_DATA("没有查到需要的数据", "100007"),

    /**
     *  01	实名认证
     */
    INFO_CHECK_IDCARD_REPEAT("身份证信息已认证，请勿重复认证！", "101001"),
    INFO_CHECK_IDCARD_PRIORITY("请先完成身份证信息认证！", "101002"),
    INFO_CHECK_IDCARD_IMAGE("很抱歉，您今天的认证次数过多，请明天再来试试吧!", "101003"),
    INFO_CHECK_IDCARD_IMAGE_FAIL("身份证图片识别失败！", "101004"),
    INFO_CHECK_IDCARD_ERROR("身份证号不合法！", "101005"),
    INFO_CHECK_IDCARD_EXITS("身份证号已绑定其他客户！", "101006"),
    INFO_CHECK_IDCARD_FAIL("身份认证失败！", "101007"),


    /**
     *  02	活体检测
     */
    INFO_CHECK_FACE_INFO_REPEAT("人脸识别已认证，请勿重复认证！", "102001"),
    INFO_CHECK_FACE_INFO_PRIORITY("请先完成人脸识别认证！", "102002"),
    INFO_CHECK_FACE_INFO_FAIL("人脸识别认证失败！", "102003"),
    INFO_CHECK_FACE_INFO_FAIL_COUNT("很抱歉，您今天的认证次数过多，请明天再来试试吧!", "102004"),

    /**
     *  03	运营商认证
     */

    /**
     *  04	芝麻信用
     */

    /**
     *  05    绑卡
     */
    INFO_CHECK_BANK_CARD_REPEAT("已完成绑卡，请勿重复认证！", "105001"),
    INFO_CHECK_BANK_CARD_NAME("卡号和姓名不一致！", "105002"),
    INFO_CHECK_BANK_CARD_SUPPORT("目前只支持如下银行卡：中国工商银行、中国建设银行、中国银行、交通银行、招商银行、中信银行、" +
            "中国民生银行、兴业银行、浦发银行、中国邮政储蓄银行、中国光大银行、平安银行、华夏银行、北京银行、广发银行", "105003"),
    INFO_CHECK_BANK_CARD_FORMAT("银行卡号格式错误！", "105004"),
    INFO_CHECK_BANK_CARD_NOT_CREDIT("请更换成储蓄卡，暂不支持信用卡等非储蓄卡！", "105004"),
    INFO_CHECK_BANK_CARD_SUPPORT2("暂不支持信用卡号等非储蓄卡号；目前只支持如下银行的储蓄卡：中国工商银行、中国建设银行、中国银行、交通银行、招商银行、中信银行、中国民生银行、兴业银行、浦发银行、中国邮政储蓄银行、中国光大银行、平安银行、华夏银行、北京银行、广发银行", "105004"),

    /**
     *  06	个人信息
     */
    INFO_CHECK_PERSONINFO_REPEAT("个人信息已认证，请勿重复认证！", "106001"),
    INFO_CHECK_PERSONINFO_PRIORITY("请先完成个人信息认证！", "106002"),

    /**
     *  07	联系人信息
     */
    INFO_CHECK_CONTACT_MOBILENUMBER("联络人手机号不能相同", "107001"),
    INFO_CHECK_CONTACT_MOBILENUMBER1("联络人手机号格式不对", "107002"),
    INFO_CHECK_CONTACT_REPEAT("联络人信息已认证，请勿重复认证！", "107003"),
    INFO_CHECK_CONTACT_PEIOU("联络人关系不能同时是配偶！", "107004"),
    INFO_CHECK_CONTACT_MOBILENUMBER2("对应的号段号码，请选择其他号段的手机号！", "107005"),

    /**
     *  08	注册登录
     */
    SESSION_EXPIRED("您的账号已退出，请重新登录", "108001"),
    REPEATREGIST("该手机号码已经注册，请填写正确手机号码", "108002"),
    ACCOUNTNOTEXIST("该号码不存在", "108003"),
    PASSWORDINCORRECT("账号或密码错误，请重新登录。", "108004"),
    SMSCODENOTCORRECT("短信验证码校验错误，请填写正确验证码", "108005"),
    MOBILENOTREGIST("该账号尚未注册，请先注册", "108006"),
    CANNOT_REPEAT_VERIFY("请勿重新验证", "108007"),
    PLEASE_USE_REG_MOBILE("请使用注册手机号认证", "108008"),
    PLEASE_USE_CORRECT_MOBILE("请输入正确的手机号", "108009"),
    PLEASE_TYPE_MOBILE("请输入手机号", "108010"),
    CODE_INVALID("验证码已过期，请重新发送", "108011"),
    PASSWORD_FORMAT_NOT_CORRECT("登录密码设置不符合规则，请重新设置", "108012"),
    SMSCODE_GET_COUNT_TOO_MUCH("短信验证码错误次数过多，请24小时后再次尝试", "108013"),
    INFO_CHECK_INCORRECT("信息验证错误，请重新验证。", "108014"),
    FORGETPWDTEMPTOKEN_INCORRECT("找回密码token不正确", "108015"),
    OLDPWD_NOT_FIT("旧密码错误，请重新设置密码。", "108016"),
    SESSION_SAFE("该账号在其他设备上登录，请注意账号安全。", "108017"),

    /**
     *  09	标的
     */
    LOAN_AMOUNT_NULL_ERROR("借款金额不能为空", "109001"),
    LOAN_PERIOD_NULL_ERROR("借款期限不能为空", "109002"),
    LOAN_AMOUNT_RANGE_ERROR("申请金额只能在{min}-{max}之间", "109003"),
    LOAN_AMOUNT_VALUE_ERROR("申请金额必须为{value}的整数倍", "109004"),
    LOAN_PERIOD_VALUE_ILLEGAL("申请期限非法", "109005"),
    LOAN_DATA_INVALID("您再次可申请借款日期为****-**-**", "109006"),
    LOAN_CREDIT_ON_THE_WAY("您有借款额度申请在途", "109007"),
    LOAN_IDNETITY_REJECT("**未通过", "109008"),// 认证不通过
    LOAN_NO_CREDIT_AMOUNT("查询不到借款额度", "109009"),
    LOAN_ON_THE_WAY("您有借款申请在途", "109010"),
    LOAN_FREQUENTLY("您在近期内申请借款过于频繁，请在2天后再次申请。", "109101"),
    LOAN_AMOUNT_TOO_MORE("您本次最多可用申请%s元，请修改申请金额。", "109102"),
    LOAN_ERROR("网络错误, 请稍后再试!", "109103"),
    LOAN_FAIL("资料不符, 借款申请失败!", "109104"),
    LOAN_NO_DATA("借款信息不存在!", "109105"),
    LOAN_NO_SIGN_STATUS("非待签约状态!", "109106"),
    LOAN_BLACKLIST("暂不支持放款，请您稍后尝试", "109107"),
    LOAN_LIMIT("今日额度已用完，请明日再来", "109109"),

    /**
     *  10	签约
     */

    /**
     *  11	确认借款
     */

    /**
     *  12	放款、还款、提前结清
     */

    /**
     *  13	消息
     */

    /**
     *  14	版本管理
     */

    /**
     *  15	存管
     */

    ;




    private String msg;
    private String code;

    private CodeEnum(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
