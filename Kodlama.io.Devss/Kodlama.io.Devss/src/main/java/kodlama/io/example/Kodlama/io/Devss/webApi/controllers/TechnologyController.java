package kodlama.io.example.Kodlama.io.Devss.webApi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.example.Kodlama.io.Devss.business.abstracts.TechnologyService;
import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.RemoveTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.UpdateTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.response.GetAllTechnologyResponse;
@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public void add(CreatTechnologyRequest creatTechnologyRequest) throws Exception {
		this.technologyService.add(creatTechnologyRequest);
	}
	
	@GetMapping("/update")
	public void update(int id,UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		this.technologyService.update(id,updateTechnologyRequest);
	}
	
	@GetMapping("/delete")
	public void delete(RemoveTechnologyRequest removeTechnologyRequest) throws Exception {
		this.technologyService.delete(removeTechnologyRequest);
	}
	
	@GetMapping("/getAll")
	public List<GetAllTechnologyResponse> getAll() throws Exception {
		return technologyService.FindAll();
	}
	
}
