package com.cameo.srv01.bca.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cameo.srv01.bca.entity.TradingRecord;
import com.cameo.srv01.bca.mapper.TradingRecordMapper;
import com.cameo.srv01.bca.service.ITradingRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 买卖记录 买卖记录 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-18
 */
@Service
public class TradingRecordServiceImpl extends ServiceImpl<TradingRecordMapper, TradingRecord> implements ITradingRecordService {

}
