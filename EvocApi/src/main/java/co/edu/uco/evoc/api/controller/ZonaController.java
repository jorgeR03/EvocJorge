package co.edu.uco.evoc.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.evoc.dto.ZonaDTO;

@RestController
@RequestMapping("evoc/api/v1/zona")
public class Controller {
	
	@GetMapping
	public ZonaDTO test() {
		return ZonaDTO.create();
	}

}
