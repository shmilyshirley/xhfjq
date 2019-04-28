package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.API.Event;
import com.hlframe.xhjq.domain.API.Locations;
import com.hlframe.xhjq.domain.API.TblDepthHis;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-21 23:46
 */

public interface EventService {
    List<Locations> getLocations(int group);

    List<Event> getEvent();

    Integer insertTblDepthHis(List tblDepthHisList );

    List<TblDepthHis> getLixianDepthHis();
}
