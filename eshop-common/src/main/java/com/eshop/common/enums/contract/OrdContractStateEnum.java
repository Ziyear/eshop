package com.eshop.common.enums.contract;

/**
 *
 */
public enum OrdContractStateEnum {


    NOT_TAKE_EFFECT(0), // 未生效
    HAS_TAKE_EFFECT(1),//已生效
    HAS_CANCELLED(2),// 已取消
    HAVE_PUT_END(3) // 已终结
    ;


    private Integer value;
    OrdContractStateEnum(Integer value){
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
    public  static OrdContractStateEnum getState(Integer state){
          switch (state){
              case 0:
                  return OrdContractStateEnum.NOT_TAKE_EFFECT;
              case 1:
                  return  OrdContractStateEnum.HAS_TAKE_EFFECT;
              case 2:
                  return  OrdContractStateEnum.HAS_CANCELLED;
              case 3:
                  return  OrdContractStateEnum.HAVE_PUT_END;
                  default:
                      return null;
          }

    }


}
