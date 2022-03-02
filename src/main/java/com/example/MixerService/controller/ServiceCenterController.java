package com.example.MixerService.controller;


import com.example.MixerService.helper.FileUploadHelper;
import com.example.MixerService.model.ServiceCenterModel;

import com.example.MixerService.service.ServiceCenterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.String;
@RestController
@CrossOrigin("*")
public class ServiceCenterController{

    @Autowired
    private ServiceCenterService serviceCenterService;
    @Autowired
    private FileUploadHelper fileUploadHelper;
    
    
    @GetMapping("/admin/getServiceCenter")
    public ResponseEntity<?> viewServiceCenter()
    {
    	return ResponseEntity.ok(serviceCenterService.viewServiceCenter());
	}
    

    @PostMapping("/admin/addServiceCenter")
    public ResponseEntity<?> addServiceCenter(ServiceCenterModel serviceCenterModel,
                                              @RequestParam("file") MultipartFile file)
    {


        try {

            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            boolean f = fileUploadHelper.uploadFile(file);
            System.out.println(f);
            if(f){
               // return ResponseEntity.ok("uploaded success");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        return ResponseEntity.ok(serviceCenterService.addServiceCenter(serviceCenterModel, file));
//        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().
//                path("/image/").path(file.getOriginalFilename()).toUriString());
    }
    
  
    
    @DeleteMapping("/admin/deleteServiceCenter/{serviceCenterID}")
    public ResponseEntity<?> deleteServiceCenter(@PathVariable String serviceCenterID)
    {
    	System.out.println(serviceCenterID);
    	return ResponseEntity.ok(serviceCenterService.deleteServiceCenter(serviceCenterID));
    }
    
    @PutMapping("/admin/editServiceCenter")
    public ResponseEntity<?> updateServiceCenter(ServiceCenterModel serviceCenterModel ,
                                               @RequestParam("file") MultipartFile file){
        try {

            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            boolean f = fileUploadHelper.uploadFile(file);
            System.out.println(f);
            if(f){
                // return ResponseEntity.ok("uploaded success");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(serviceCenterService.updateServiceCenter( serviceCenterModel,file));
    }

   
    
}
