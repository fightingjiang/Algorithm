package basic.Enum;

public enum WechatSignBillType {

    RESERVAION(1,"预约单"),

    PURCHASE(2,"采购单"),

    WAYBILL(3, "运单");

    private Integer index;

    private String desc;

    public Integer getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    WechatSignBillType(Integer index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(WechatSignBillType.RESERVAION.index);
    }
}
