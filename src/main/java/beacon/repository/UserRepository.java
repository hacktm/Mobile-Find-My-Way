/*
 * Copyright (c) 2014 MicroPact, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of MicroPact, Inc.
 * Use is subject to license terms.
 */

package beacon.repository;

import beacon.entity.ImportExport;
import beacon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Repository for ExportDetails.
 *
 * @author MicroPact, Inc.
 */
public interface UserRepository
        extends CrudRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
}
