package com.tdi.taekwondo.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.File;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface FileRepository extends JpaRepository<File, String> {

}
