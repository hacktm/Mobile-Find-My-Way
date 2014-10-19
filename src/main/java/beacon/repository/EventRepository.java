/*
 * Copyright (c) 2014 MicroPact, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of MicroPact, Inc.
 * Use is subject to license terms.
 */

package beacon.repository;

import beacon.entity.Event;
import beacon.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Repository for ExportDetails.
 *
 * @author MicroPact, Inc.
 */
public interface EventRepository
        extends CrudRepository<Event, Long> {
    Page<Event> findAll(Pageable pageable);

    @Query("select e from Event e where e.roomid = (:roomid)")
    public Set<Event> findEventsByRoomid(
            @Param("roomid") Long roomid);

}
