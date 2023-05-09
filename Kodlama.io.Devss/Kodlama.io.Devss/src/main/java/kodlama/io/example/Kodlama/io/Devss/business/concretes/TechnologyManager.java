package kodlama.io.example.Kodlama.io.Devss.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.example.Kodlama.io.Devss.business.abstracts.TechnologyService;
import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.RemoveTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.UpdateTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.response.GetAllTechnologyResponse;
import kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;
import kodlama.io.example.Kodlama.io.Devss.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;


	public TechnologyManager(TechnologyRepository technologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
	
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreatTechnologyRequest creatTechnologyRequest ) throws Exception {
		
		if(isNameExist(creatTechnologyRequest.getName())) {
			throw new Exception("isim sistemde zaten kayıtlı");
		}
		
		
		
		Technology technology=new Technology();
		ProgrammingLanguage programmingLanguage=programmingLanguageRepository.findById(creatTechnologyRequest.getId()).get();
		technology.setName(creatTechnologyRequest.getName());
		technology.setProgrammingLanguage(null);
		technologyRepository.save(technology);	
		
	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		if(!isIdExist(id))
		{
			throw new Exception("Id bulunamadı");
		}
		
		if(isNameExist(updateTechnologyRequest.getName()))
		{
			throw new Exception("Sistemde kayıtlı olan teknoloji girdiniz");
		}
		
		
		Technology technology=new Technology();
		technology.setName(updateTechnologyRequest.getName());
		technologyRepository.save(technology);
	}

	@Override
	public void delete(RemoveTechnologyRequest removeTechnologyRequest) throws Exception {
		if(!isNameExist(removeTechnologyRequest.getName())) {
			throw new Exception("isim sistemde yok");
		}
	
	List<Technology> technologies=technologyRepository.findAll();
		
	for(Technology technology:technologies) {
		if(technology.getName().equalsIgnoreCase(removeTechnologyRequest.getName())) {
		   this.technologyRepository.deleteById(technology.getId());	         
		}

	}
		
		
	}


	@Override
	public List<GetAllTechnologyResponse> FindAll() {
		List<Technology> technologies=technologyRepository.findAll();
		
		List<GetAllTechnologyResponse> getAllTechnologyResponses =new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology technology2: technologies) {
			GetAllTechnologyResponse responseItem=new GetAllTechnologyResponse();
			responseItem.setId(technology2.getId());
			responseItem.setName(technology2.getName());
			getAllTechnologyResponses.add(responseItem);					
		}
		
		return getAllTechnologyResponses;
	}



	public boolean isNameExist(String name)  {
	for(Technology technology2:technologyRepository.findAll()) {
		if(technology2.getName().equalsIgnoreCase(name)) {
			return true;
		}
	}
	 return false;
	}
	
   public boolean isIdExist(int id) {
		for(Technology technology2:technologyRepository.findAll()) {
			if(technology2.getId()==id)
			{
				return true;
			}
		}
	   return false;
	}
	
	
}
