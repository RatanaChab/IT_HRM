package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Location;
import com.example.IT_HRM.Repository.LocationRep;
import com.example.IT_HRM.Service.LocationService;
import com.example.IT_HRM.Utils.ExcelHelper;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Data
public class LocationServiceImpl implements LocationService {

    private final LocationRep locationRep;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Location> locations = ExcelHelper.excelToLocations(file.getInputStream());
            locationRep.saveAll(locations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
