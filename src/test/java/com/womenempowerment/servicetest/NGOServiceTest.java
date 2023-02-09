package com.womenempowerment.servicetest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.womenempowerment.entity.NGO;
import com.womenempowerment.exception.NGOAlreadyExistsException;
import com.womenempowerment.exception.NGONotPresentException;
import com.womenempowerment.repository.NGORepository;
import com.womenempowerment.service.NGOServiceImpl;

@ExtendWith(MockitoExtension.class)
class NGOServiceTest {

	@InjectMocks
	private NGOServiceImpl ngoServiceImpl;

	@Mock
	private NGORepository ngoRepository;

	/**
	 * In this test case we are saving the ngo
	 * @throws NGOAlreadyExistsException
	 */
	@Test
	void createNGO() throws NGOAlreadyExistsException {
		NGO ngo = new NGO(2, "ABC", "hhjdd", "proddatur", "9876543214", "abc@gmail.com", "www.abc.com");
		when(ngoRepository.save(ngo)).thenReturn(ngo);
		NGO originalNGO = ngoServiceImpl.addNGO(ngo);
		Assertions.assertEquals(ngo.getId(), originalNGO.getId());

	}

	/**
	 * Updating the NGO which is already present 
	 * @throws NGONotPresentException
	 */
	@Test
	void updateNGO() throws NGONotPresentException {

		NGO ngo = new NGO(2, "anusha", "test", "kamalapuram", "8967542316", "anusha@gmail.com", "www.anusha.com");
		when(ngoRepository.existsById((long) 2)).thenReturn(true);
		NGO upNgo = ngoServiceImpl.updateNGO(ngo);
		Assertions.assertEquals(2, ngo.getId());

	}

	/**
	 * Throwing exception when updating a NGO which is not present
	 * @throws NGONotPresentException
	 */

	@Test
	void updateNGO_exception() throws NGONotPresentException {

		NGO ngo = new NGO(2, "anusha", "test", "kamalapuram", "8967542316", "anusha@gmail.com", "www.anusha.com");
		when(ngoRepository.existsById((long) 2)).thenReturn(false);
		Assertions.assertThrows(NGONotPresentException.class, () -> ngoServiceImpl.updateNGO(ngo));

	}
}