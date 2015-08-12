package de.mischok.exploration.springboot.application;

import org.springframework.data.repository.CrudRepository;

public interface AccessLogRepository extends CrudRepository<AccessLog, Integer> {}
