package com.makersharks.ManuSearch.service;

import com.makersharks.ManuSearch.entity.Supplier;
import com.makersharks.ManuSearch.enums.ManufacturingProcess;
import com.makersharks.ManuSearch.enums.NatureOfBusiness;
import org.springframework.data.domain.Page;

/**
 * Service interface for handling operations related to {@link Supplier} entities.
 * Provides methods for querying suppliers based on various criteria.
 */
public interface SupplierService {

    /**
     * Queries suppliers based on location, nature of business, and manufacturing process.
     *
     * @param location             the location of the supplier
     * @param natureOfBusiness     the nature of business of the supplier
     * @param manufacturingProcess the manufacturing process used by the supplier
     * @param page                 the page number for pagination
     * @param size                 the number of items per page for pagination
     * @return a {@link Page} of {@link Supplier} entities matching the criteria
     */
    Page<Supplier> querySuppliers(String location, NatureOfBusiness natureOfBusiness,
                                  ManufacturingProcess manufacturingProcess, int page, int size);
}
