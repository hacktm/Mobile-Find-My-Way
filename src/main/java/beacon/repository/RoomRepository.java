/*
 * Copyright (c) 2014 MicroPact, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of MicroPact, Inc.
 * Use is subject to license terms.
 */

package beacon.repository;

import beacon.entity.Beacon;
import beacon.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for ExportDetails.
 *
 * @author MicroPact, Inc.
 */
public interface RoomRepository
        extends CrudRepository<Room, Long> {
    Page<Room> findAll(Pageable pageable);
}
