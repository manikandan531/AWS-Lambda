package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import entity.FileData;
import entity.XlData;
import repository.FileDataRepo;
import repository.StorageRepo;
import utils.XlUtils;

@Service
public class StorageService {

    @Autowired
    private StorageRepo repository;

    @Autowired
    private FileDataRepo fileDataRepository;

    private final String FOLDER_PATH="C://Users//HUBINO//Desktop";

    public String uploadImage(MultipartFile file) throws IOException {
        XlData imageData = repository.save(XlData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(XlUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }



    public byte[] downloadImage(String fileName) {
        Optional<XlData> dbImageData = repository.findByName(fileName);
        byte[] images = XlUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
