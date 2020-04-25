package cl.home.farmanet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.home.farmanet.domain.Farmacia;
import cl.home.farmanet.service.ConsumeService;

/**
 * Clase que contiene la llamada al servicio de consulta.
 * 
 * @author Rodrigo Sepúlveda
 *
 */
@RestController
public class FarmaciaController {
	
	Logger logger = LoggerFactory.getLogger(FarmaciaController.class);

	@Autowired
	ConsumeService service;

	/**
	 * Obtiene listado farmacias para comuna requerida.
	 * 
	 * @param comuna
	 * @return farmscias
	 */
	@GetMapping("/farmacia")
	public List<Farmacia> getFarmaciaPorComuna(@RequestParam(value = "comuna") String comuna) {
		logger.debug("Inicia metodo obtieneFarmacias");

		return service.getFarmacias().stream().filter(farmacia -> farmacia.getComuna_nombre().equalsIgnoreCase(comuna))
				.collect(Collectors.toList());

	}

}
