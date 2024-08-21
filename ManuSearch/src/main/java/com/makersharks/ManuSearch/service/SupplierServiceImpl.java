package com.makersharks.ManuSearch.service;

import com.makersharks.ManuSearch.entity.Supplier;
import com.makersharks.ManuSearch.enums.ManufacturingProcess;
import com.makersharks.ManuSearch.enums.NatureOfBusiness;
import com.makersharks.ManuSearch.exception.ManuSearchException;
import com.makersharks.ManuSearch.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link SupplierService} interface.
 * Provides methods to query {@link Supplier} entities from the repository.
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    /**
     * Queries suppliers based on location, nature of business, and manufacturing process.
     *
     * @param location             the location of the supplier
     * @param natureOfBusiness     the nature of business of the supplier
     * @param manufacturingProcess the manufacturing process used by the supplier
     * @param page                 the page number for pagination
     * @param size                 the number of items per page for pagination
     * @return a {@link Page} of {@link Supplier} entities matching the criteria
     * @throws ManuSearchException if no suppliers are found matching the criteria
     */
    @Override
    public Page<Supplier> querySuppliers(String location, NatureOfBusiness natureOfBusiness,
                                         ManufacturingProcess manufacturingProcess, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContains(
                location, natureOfBusiness, manufacturingProcess, pageable);

        if (suppliers.isEmpty()) {
            throw new ManuSearchException("No suppliers found matching the provided criteria.");
        }

        return suppliers;
    }
}
