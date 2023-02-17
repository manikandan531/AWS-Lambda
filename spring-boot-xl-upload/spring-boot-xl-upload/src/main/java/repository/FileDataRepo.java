package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.FileData;
import entity.XlData;
public interface FileDataRepo extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);
}
