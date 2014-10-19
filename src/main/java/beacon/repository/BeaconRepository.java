/*
 * Copyright (c) 2014 MicroPact, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of MicroPact, Inc.
 * Use is subject to license terms.
 */

package beacon.repository;

import beacon.entity.Beacon;
import beacon.entity.ImportExport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository for ExportDetails.
 *
 * @author MicroPact, Inc.
 */
public interface BeaconRepository
        extends CrudRepository<Beacon, Long> {
    Page<Beacon> findAll(Pageable pageable);
}
