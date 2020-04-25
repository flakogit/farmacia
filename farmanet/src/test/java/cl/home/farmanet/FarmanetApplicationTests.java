package cl.home.farmanet;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.home.farmanet.domain.Farmacia;
import cl.home.farmanet.service.ConsumeService;

@SpringBootTest
class FarmanetApplicationTests {

	@Autowired
	ConsumeService service;

	@Test
	public void getFamacias() throws Exception {
		List<Farmacia> farmacias = service.getFarmacias();
		assertTrue(farmacias != null && !farmacias.isEmpty());
	}

}
