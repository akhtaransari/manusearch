package com.makersharks.ManuSearch;

import com.makersharks.ManuSearch.entity.Supplier;
import com.makersharks.ManuSearch.enums.ManufacturingProcess;
import com.makersharks.ManuSearch.enums.NatureOfBusiness;
import com.makersharks.ManuSearch.repository.SupplierRepository;
import com.makersharks.ManuSearch.service.SupplierServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test class for the SupplierServiceImpl service layer.
 * It verifies the behavior of the querySuppliers method in the SupplierServiceImpl class.
 */
@SpringBootTest
class ManuSearchApplicationTests {

	@InjectMocks
	private SupplierServiceImpl supplierService; // Service to be tested, with dependencies injected by Mockito

	@Mock
	private SupplierRepository supplierRepository; // Mocked repository to simulate data access

	/**
	 * Sets up the test environment.
	 * Initializes mocks and prepares the test context before each test method.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mock annotations
	}

	/**
	 * Tests the querySuppliers method of the SupplierServiceImpl class.
	 * It verifies that the method correctly retrieves and returns a page of suppliers based on the specified criteria.
	 */
	@Test
	public void testQuerySuppliers() {
		// Arrange
		Supplier supplier = new Supplier();
		supplier.setSupplierId(1L); // Set a unique identifier for the supplier
		supplier.setCompanyName("Test Supplier"); // Set the company name
		supplier.setLocation("Test Location"); // Set the supplier's location
		supplier.setNatureOfBusiness(NatureOfBusiness.SMALL_SCALE); // Set the nature of the business
		supplier.setManufacturingProcesses(Collections.singletonList(ManufacturingProcess.MOULDING)); // Set the manufacturing processes

		// Create a Page object containing the supplier
		Page<Supplier> page = new PageImpl<>(Collections.singletonList(supplier), PageRequest.of(0, 10), 1);

		// Mock the repository method to return the page of suppliers when called with specific parameters
		when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContains(
				"Test Location", NatureOfBusiness.SMALL_SCALE, ManufacturingProcess.MOULDING, PageRequest.of(0, 10)))
				.thenReturn(page);

		// Act
		// Call the querySuppliers method of the service to get the result
		Page<Supplier> result = supplierService.querySuppliers(
				"Test Location", NatureOfBusiness.SMALL_SCALE, ManufacturingProcess.MOULDING, 0, 10);

		// Assert
		// Verify that the result contains the expected number of elements
		assertEquals(1, result.getTotalElements(), "The result should contain exactly one supplier");
		// Verify that the company's name in the result matches the expected value
		assertEquals("Test Supplier", result.getContent().get(0).getCompanyName(), "The company name should match the expected value");
	}
}
