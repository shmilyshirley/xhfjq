package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.API.EventsDao;
import com.hlframe.xhjq.domain.API.Event;
import com.hlframe.xhjq.domain.API.Locations;
import com.hlframe.xhjq.domain.API.TblDepthHis;
import com.hlframe.xhjq.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-21 23:47
 */
@Service("getLocations")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventsDao eventsDao;

    @Override
    public List<Locations> getLocations(int group) {
        return eventsDao.getLocations(group);
    }

    @Override
    public List<Event> getEvent() {
        return eventsDao.getEvent();
    }

    @Override
    public Integer insertTblDepthHis(List tblDepthHisList) {
        return eventsDao.insertTblDepthHis(tblDepthHisList);
    }

    @Override
    public List<TblDepthHis> getLixianDepthHis() {
        return eventsDao.getLixianDepthHis();
    }

}
