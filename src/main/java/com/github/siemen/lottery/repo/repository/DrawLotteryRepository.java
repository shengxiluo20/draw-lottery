/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.github.siemen.lottery.repo.repository;

import com.github.siemen.lottery.domain.aggregate.DrawLottery;
import com.github.siemen.lottery.repo.cache.DrawLotteryCacheAccessObj;
import com.github.siemen.lottery.repo.dao.AwardDao;
import com.github.siemen.lottery.repo.dao.AwardPoolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <b>描述：抽奖资源库</b> <br/>
 * 对外提供统一的资源方案，聚合资源库信息 承担存储逻辑
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-04-27<br/>
 *
 */
@Repository
public class DrawLotteryRepository {

    @Autowired
    private AwardDao awardDao;
    @Autowired
    private AwardPoolDao awardPoolDao;
    @Autowired
    private DrawLotteryCacheAccessObj drawLotteryCacheAccessObj;

    public DrawLottery getDrawLotteryById(Integer lotteryId) {
        DrawLottery drawLottery = drawLotteryCacheAccessObj.get(lotteryId);
        if (drawLottery != null) {
            return drawLottery;
        }
        drawLottery = getDrawLotteryFromDB(lotteryId);
        drawLotteryCacheAccessObj.add(lotteryId, drawLottery);
        return drawLottery;
    }

    private DrawLottery getDrawLotteryFromDB(Integer lotteryId) {
        return null;
    }

}