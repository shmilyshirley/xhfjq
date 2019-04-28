package com.hlframe.xhjq.dao.API;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-21 23:39
 */

import com.hlframe.xhjq.domain.API.Event;
import com.hlframe.xhjq.domain.API.Locations;
import com.hlframe.xhjq.domain.API.TblDepthHis;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsDao {
    List<Locations> getLocations(int group);

    List<Event> getEvent();

    Integer insertTblDepthHis(List tblDepthHisList);

    List<TblDepthHis> getLixianDepthHis();

}
