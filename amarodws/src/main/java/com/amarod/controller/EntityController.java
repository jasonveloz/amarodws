package com.amarod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarod.dto.EntitiesDTO;
import com.amarod.model.Entities;
import com.amarod.services.EntitiesService;

@CrossOrigin
@RestController
public class EntityController {

	@Autowired
	private EntitiesService entitiesService;

	@GetMapping(value = "/entities")
	public List<Entities> getEntity() {
		List<Entities> list = entitiesService.findAll();
		return list;
	}

	@GetMapping(value = "/entities/{id}")
	public Entities getEntity(@PathVariable int id) {
		return entitiesService.findById(id);
	}

	@PostMapping(value = "/entities")
	public ResponseEntity<String> save(@RequestBody EntitiesDTO entitiesDTO) {
		Entities newEntity = new Entities();
		newEntity.setEntity(entitiesDTO.getEntity());
		newEntity.setEntityDescription(entitiesDTO.getEntityDescription());
		newEntity.setEntityNote(entitiesDTO.getEntityNote());
		newEntity.setLang(entitiesDTO.getLang());
		newEntity.setImg(entitiesDTO.getImg());
		newEntity.setOrderNo(entitiesDTO.getOrderNo());
		entitiesService.save(newEntity);
		return new ResponseEntity<>("ENTITY_CREATED", HttpStatus.CREATED);
	}

	@PutMapping(value = "/entities/{entityId}")
	public ResponseEntity<String> update(@RequestBody EntitiesDTO entitiesDTO, @PathVariable int entityId) {
		System.out.println("Update Entity");
		Entities foundEntity = entitiesService.findById(entityId);

		if (foundEntity == null) {
			return new ResponseEntity<>("ENTITY_NOT_FOUND", HttpStatus.OK);
		}

		foundEntity.setEntity(entitiesDTO.getEntity());
		foundEntity.setEntityDescription(entitiesDTO.getEntityDescription());
		foundEntity.setEntityNote(entitiesDTO.getEntityNote());
		foundEntity.setLang(entitiesDTO.getLang());
		foundEntity.setImg(entitiesDTO.getImg());
		foundEntity.setOrderNo(entitiesDTO.getOrderNo());
		entitiesService.save(foundEntity);
		return new ResponseEntity<>("ENTITY_UPDATED", HttpStatus.CREATED);
	}

}
