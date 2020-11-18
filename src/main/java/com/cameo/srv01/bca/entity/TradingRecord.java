package com.cameo.srv01.bca.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 买卖记录 买卖记录
 * </p>
 *
 * @author jobob
 * @since 2020-11-18
 */
@Data
@Slf4j
public class TradingRecord  {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 币种
     */
    @TableField("COIN_CODE")
    private String coinCode;

    /**
     * 数量
     */
    @TableField("QUANTITY")
    private BigDecimal quantity;

    /**
     * 交易类型 1买入,2卖出
     */
    @TableField("TRADING_TYPE")
    private String tradingType;

    /**
     * 交易总价
     */
    @TableField("MONEY")
    private BigDecimal money;

    /**
     * 交易单位 CNY,BTC,USD等
     */
    @TableField("UNIT")
    private String unit;

    /**
     * 价格类型 1总价,2单价
     */
    @TableField("PRICE_TYPE")
    private String priceType;

    /**
     * 交易日期
     */
    @TableField("BOOKED_DATE")
    private LocalDate bookedDate;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 乐观锁
     */
    @TableField("REVISION")
    private Integer revision;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private LocalDateTime updatedTime;


}
