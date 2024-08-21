package com.makersharks.ManuSearch.controller;

import com.makersharks.ManuSearch.entity.Supplier;
import com.makersharks.ManuSearch.enums.ManufacturingProcess;
import com.makersharks.ManuSearch.enums.NatureOfBusiness;
import com.makersharks.ManuSearch.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling supplier-related API requests.
 */
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * Handles the request to query suppliers based on location, nature of business, and manufacturing process.
     *
     * @param location             the location of the supplier
     * @param natureOfBusiness     the nature of the business
     * @param manufacturingProcess the manufacturing process used by the supplier
     * @param page                 the page number for pagination (default is 0)
     * @param size                 the number of suppliers per page (default is 10)
     * @return a ResponseEntity containing a page of suppliers and HTTP status
     */
    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam ManufacturingProcess manufacturingProcess,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Supplier> suppliers = supplierService.querySuppliers(location, natureOfBusiness, manufacturingProcess, page, size);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }
}
