package com.example.MixerService.service;

import antlr.StringUtils;
import com.example.MixerService.model.ServiceCenterModel;



import com.example.MixerService.model.ResponseModel;

import com.example.MixerService.repository.ServiceCenterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.lang.String;

@Service
public class ServiceCenterService {


    @Autowired
    private ServiceCenterRepository serviceCenterRepository;
    
    public List<ServiceCenterModel> viewServiceCenter()
    {
    	return serviceCenterRepository.findAll();
	}

        
    public ResponseModel addServiceCenter(ServiceCenterModel serviceCenterModel, MultipartFile multipartFile)
    {
        String fileName = ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/image/").path(multipartFile.getOriginalFilename()).toUriString();
        serviceCenterModel.setServiceCenterImageUrl(fileName);
        serviceCenterRepository.save(serviceCenterModel);
    	return new ResponseModel("new user "+serviceCenterModel.getServiceCenterName()+" added successfully!!!");
    }
    	
    public ResponseModel updateUser(ServiceCenterModel serviceCenterModel)
    {
    	serviceCenterRepository.save(serviceCenterModel);
    	return new ResponseModel("user "+serviceCenterModel.getServiceCenterName()+" details updated successfully!!!");
	}
    
    public ResponseModel deleteServiceCenter(String serviceCenterID)
    {
        serviceCenterRepository.deleteById(serviceCenterID);
    	return new ResponseModel("user details deleted successfully :(");	
    }
    
   public ResponseModel editServiceCenter(String serviceCenterID , ServiceCenterModel serviceCenterModelModel) {
       serviceCenterRepository.save(serviceCenterModelModel);
	return new ResponseModel("User Updated Successfully");
   }
    
}
