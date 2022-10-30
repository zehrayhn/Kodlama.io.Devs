package kodlama.io.example.Kodlama.io.Devss.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.example.Kodlama.io.Devss.business.abstracts.ProgrammingLanguageService;

import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguage")
public class ProgrammingLanguageController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
	
		this.programmingLanguageService = programmingLanguageService;
	}


	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}
	
	@GetMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(programmingLanguage);
	}
	
	@GetMapping("/delete")
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.delete(programmingLanguage);
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getById(id);
	}
}
