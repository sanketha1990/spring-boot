package com.load.tracker.dataloadreport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.load.tracker.dataloadreport.dto.ProcessTracker;

@Repository("dataloadRepository")
public interface DataloadRepository extends CrudRepository<ProcessTracker, Long> {
}
