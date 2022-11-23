package com.leodemetrio.hrworker.repositories;

import com.leodemetrio.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends  JpaRepository<Worker, Long> {
}
