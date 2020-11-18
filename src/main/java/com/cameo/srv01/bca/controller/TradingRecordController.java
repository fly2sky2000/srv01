package com.cameo.srv01.bca.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cameo.srv01.bca.entity.TradingRecord;
import com.cameo.srv01.bca.service.ITradingRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 买卖记录 买卖记录 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/bca/trading-record")
public class TradingRecordController  extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ITradingRecordService service;

    @GetMapping("/")
    public R getAll() {
        return success(this.service.list());
    }

    @GetMapping("{id}")
    public R getById(@PathVariable String id) {
        return success(this.service.getById(id));
    }
    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param domain 查询实体
     * @return 所有数据
     */
    @GetMapping("page")
    public R selectAll(Page<TradingRecord> page, TradingRecord domain) {
        return success(this.service.page(page, new QueryWrapper<>(domain)));
    }
    @PostMapping("insert")
    public R insert(@RequestBody TradingRecord domain) {
        return success(this.service.save(domain));
    }

    @PostMapping("update")
    public R update(@RequestBody TradingRecord domain) {
        return success(this.service.updateById(domain));
    }

    @PostMapping("delete")
    public R delete(@RequestParam("ids") List<String> ids) {
        return success(this.service.removeByIds(ids));
    }

}
