package kodlama.io.example.Kodlama.io.Devss.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.example.Kodlama.io.Devss.business.abstracts.ProgrammingLanguageService;
import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.response.FindByIdProgrammingLanguageResponse;
import kodlama.io.example.Kodlama.io.Devss.business.response.GetAllProgrammingLanguageResponse;
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
	public List<GetAllProgrammingLanguageResponse> getAll(){
		return programmingLanguageService.findAll();
	}
	
	@PostMapping("/add")
	public void add(CreatProgrammingLanguageRequest creatProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.add(creatProgrammingLanguageRequest);
	}
	

	@GetMapping("/update")
	public void update( int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception  {
		this.programmingLanguageService.update(id,updateProgrammingLanguageRequest);
	}
	
	@GetMapping("/delete")
	public void delete(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.remove(removeProgrammingLanguageRequest);
    }
	
	@GetMapping("/getById")
	public FindByIdProgrammingLanguageResponse getById(int id) throws Exception {
		return programmingLanguageService.FindById(id);
	}
}
