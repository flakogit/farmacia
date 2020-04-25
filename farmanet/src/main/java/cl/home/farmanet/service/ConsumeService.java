package cl.home.farmanet.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.home.farmanet.domain.Farmacia;

@Service
public class ConsumeService {
	
	Logger logger = LoggerFactory.getLogger(ConsumeService.class);

	private List<Farmacia> farmacias = null;

	/**
	 * Carga inicial del listado de farmacias.
	 */
	@PostConstruct
	private void obtieneFarmacias() {
		logger.debug("Inicia metodo obtieneFarmacias");

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);

		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);

		final RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.setMessageConverters(messageConverters);

		//Invoca servicio que obtiene listado de farmacias
		ResponseEntity<List<Farmacia>> response = restTemplate.exchange(
				"https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Farmacia>>() {
				});

		farmacias = response.getBody();
		
		logger.debug("Finaliza metodo obtieneFarmacias");
	}

	/**
	 * Obtiene listado de farmacias.
	 * 
	 * @return farmacias
	 */
	public List<Farmacia> getFarmacias() {
		return farmacias;
	}

}
