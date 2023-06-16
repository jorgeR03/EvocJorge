package co.edu.uco.evoc.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uco.evoc.api.controller.response.Response;
import co.edu.uco.evoc.api.validator.zona.RegistrarCandidatoValidation;
import co.edu.uco.evoc.business.facade.CandidatoFacade;
import co.edu.uco.evoc.business.facade.impl.CandidatoFacadeImpl;
import co.edu.uco.evoc.crosscutting.exception.EvocException;
import co.edu.uco.evoc.dto.CandidatoDTO;
import co.edu.uco.evoc.dto.PersonaDTO;

@RestController
@RequestMapping("evoc/api/v1/Candidato")
public final class CandidatoController {
	
	private Logger log = LoggerFactory.getLogger(CandidatoController.class);
	
	private CandidatoFacade facade;
	
	@GetMapping("/dummy")
	public CandidatoDTO dummy() {
		return CandidatoDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<List<CandidatoDTO>>> list(){
		List<CandidatoDTO> list = new ArrayList<>();
		List<String> messages = new ArrayList<>();
		messages.add("Candidatos consultados exitosamente");
		Response<List<CandidatoDTO>> response = new Response<>(list, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDTO> listById(@PathVariable UUID id){
		CandidatoDTO candidatoDTO = CandidatoDTO.create().setIdentificador(id);
		return new ResponseEntity<>(candidatoDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Response<CandidatoDTO>> create(@RequestBody CandidatoDTO dto) {
		HttpStatus statusCode = HttpStatus.OK;
		Response<CandidatoDTO> response = new Response<>();
		
		try {
			var result = RegistrarCandidatoValidation.validate(dto);
			
			if (result.getMessages().isEmpty()) {
				facade = new CandidatoFacadeImpl();
				facade.register(dto);
				response.getMessages().add("El nuevo Candidato se ha registrado de forma satisfactoria");
			} else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
			
		} catch(EvocException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()), exception);
		} catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado, por favor intente de nuevo. Si el problema persiste, contacte al administrador de la aplicación");
			log.error("Se ha presentado un problema inesperado. Por favor, validar la consola de errores...", exception);
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response, statusCode);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CandidatoDTO> update(@PathVariable UUID id, @RequestBody CandidatoDTO dto) {
		CandidatoDTO updatedCandidatoDTO = dto.setIdentificador(id);
		return new ResponseEntity<>(updatedCandidatoDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonaDTO> delete(@PathVariable UUID id) {
		PersonaDTO personaDTO = CandidatoDTO.create().setIdentificador(id);
		return new ResponseEntity<>(personaDTO, HttpStatus.OK);
	}
}
