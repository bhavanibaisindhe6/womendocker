package com.womenempowerment.servicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.womenempowerment.entity.Scheme;
import com.womenempowerment.exception.SchemeAlreadyExistsException;
import com.womenempowerment.exception.SchemeNotPresentException;
import com.womenempowerment.repository.SchemeRepository;
import com.womenempowerment.service.SchemeServiceImpl;

@ExtendWith(MockitoExtension.class)
class SchemeServiceTest {

	@InjectMocks
	private SchemeServiceImpl schemeServiceImpl;

	@Mock
	private SchemeRepository schemeRepository;

	/**
	 * This test case throws the exception when the same scheme is added again
	 * @throws SchemeAlreadyExistsException
	 */
	@Test
	void saveScheme_exception() throws SchemeAlreadyExistsException {

		Scheme schemes = new Scheme(3, "asdf", 2022, "bvf", "hhjh");
		when(schemeRepository.existsById((long) 3)).thenReturn(true);
		Assertions.assertThrows(SchemeAlreadyExistsException.class, () -> schemeServiceImpl.addScheme(schemes));

	}

	/**
	 * This test case saves the schemes
	 * @throws SchemeAlreadyExistsException
	 */
	@Test
	void saveScheme_success() throws SchemeAlreadyExistsException {

		Scheme schemes = new Scheme(3, "asdf", 2022, "bvf", "hhjh");
		when(schemeRepository.save(any())).thenReturn(schemes);
		Scheme saveSchemes = schemeServiceImpl.addScheme(schemes);
		Assertions.assertEquals(3, saveSchemes.getSchemeId());

	}

	/**
	 * This test case updates the existing scheme
	 * @throws SchemeNotPresentException
	 */
	@Test
	void updateScheme_success() throws SchemeNotPresentException {
		Scheme s = new Scheme(2, "yukjj", 2022, "geh", "eyuu");
		when(schemeRepository.existsById((long) 2)).thenReturn(true);
		when(schemeRepository.save(any())).thenReturn(s);
		Scheme sch = schemeServiceImpl.updateScheme(s);
		Assertions.assertEquals(2, sch.getSchemeId());
	}

	/**
	 * This test case throws the exception when we update the scheme which is not present
	 * @throws SchemeNotPresentException
	 */
	@Test
	void updateScheme_exception() throws SchemeNotPresentException {
		Scheme s = new Scheme(2, "yukjj", 2022, "geh", "eyuu");
		when(schemeRepository.existsById((long) 2)).thenReturn(false);

		Assertions.assertThrows(SchemeNotPresentException.class, () -> schemeServiceImpl.updateScheme(s));
	}
}