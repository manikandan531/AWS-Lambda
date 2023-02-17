package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.XlData;

public interface StorageRepo extends JpaRepository<XlData,Long> {


    Optional<XlData> findByName(String fileName);
}
