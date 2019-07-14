package com.eshop.common.enums.contract;

/**
 *
 */
public enum OrdOrderStateEnum {


    WAITING_FOR_BUYER_PAYMENT(0), //等待买家付款  -  已生效 - 1
    WAITING_MERCHANT_CONFIRMATION(1), //等待商家确认 - 未生效 - 0
    EXECUTION_OF(2), //执行中   - 已生效 - 1
    WAITING_FOR_DEDUCTIONS(3), //等待扣款 - 已生效 - 1
    WAITING_BUYER_CONFIRMATION(4), //等待买家确认 - 未生效 - 0
    TRADING_CLOSED(5),//交易关闭（取消） - 已取消 - 2
    DEAL(6) //交易完成 - 已终结 - 3
    ;

    private Integer value;
    OrdOrderStateEnum(Integer value){
        this.value=value;
    }

    public Integer getValue(){
        return  this.value;
    }




    /**
     *
     * @param state
     * @return
     */
    public  static OrdOrderStateEnum getState(Integer state){
        switch (state){
            case 0:
                return OrdOrderStateEnum.WAITING_FOR_BUYER_PAYMENT;
            case 1:
                return  OrdOrderStateEnum.WAITING_MERCHANT_CONFIRMATION;
            case 2:
                return  OrdOrderStateEnum.EXECUTION_OF;
            case 3:
                return  OrdOrderStateEnum.WAITING_FOR_DEDUCTIONS;
            case 4:
                return OrdOrderStateEnum.WAITING_BUYER_CONFIRMATION;
            case 5:
                return OrdOrderStateEnum.TRADING_CLOSED;
            case 6:
                return OrdOrderStateEnum.DEAL;
            default:
                return null;
        }

    }

}
