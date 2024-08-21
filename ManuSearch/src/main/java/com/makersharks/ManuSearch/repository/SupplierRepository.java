package com.makersharks.ManuSearch.repository;

import com.makersharks.ManuSearch.entity.Supplier;
import com.makersharks.ManuSearch.enums.ManufacturingProcess;
import com.makersharks.ManuSearch.enums.NatureOfBusiness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and manipulating {@link Supplier} entities.
 * Extends {@link JpaRepository} to provide standard CRUD operations and pagination support.
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    /**
     * Finds suppliers based on location, nature of business, and manufacturing processes.
     *
     * @param location             the location of the supplier
     * @param natureOfBusiness     the nature of business of the supplier
     * @param manufacturingProcess the manufacturing process used by the supplier
     * @param pageable             pagination information for the query
     * @return a {@link Page} of {@link Supplier} entities matching the criteria
     */
    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContains(
            String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcess, Pageable pageable);
}
