package kodlama.io.example.Kodlama.io.Devss.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.example.Kodlama.io.Devss.business.abstracts.ProgrammingLanguageService;
import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.response.FindByIdProgrammingLanguageResponse;
import kodlama.io.example.Kodlama.io.Devss.business.response.GetAllProgrammingLanguageResponse;
import kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {

		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> findAll() {
		
		List<ProgrammingLanguage> programmingLanguages=programmingLanguageRepository.findAll();
		
		List<GetAllProgrammingLanguageResponse> getAllProgrammingLanguageResponses=new ArrayList<GetAllProgrammingLanguageResponse>();
		
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
		    GetAllProgrammingLanguageResponse ResponseItem=new GetAllProgrammingLanguageResponse();
		    ResponseItem.setId(programmingLanguage.getId());
		    ResponseItem.setName(programmingLanguage.getName());
		    getAllProgrammingLanguageResponses.add(ResponseItem);
		}
		
		
		return getAllProgrammingLanguageResponses;
	}

	@Override
	public void add(CreatProgrammingLanguageRequest creatProgrammingLanguageRequest) throws Exception {
		if(isNameExist(creatProgrammingLanguageRequest.getName())) {
			throw new Exception("isim sistemde zaten kayıtlı");
		}
		ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
	    programmingLanguage.setName(creatProgrammingLanguageRequest.getName());	
		this.programmingLanguageRepository.save(programmingLanguage);
	}
	
	@Override
	public void remove(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest ) throws Exception{
		if(!isNameExist(removeProgrammingLanguageRequest.getName())) {
			throw new Exception("isim sistemde yok");
		}
	
	List<ProgrammingLanguage> programmingLanguages =programmingLanguageRepository.findAll();
		
	for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
		if(programmingLanguage.getName().equalsIgnoreCase(removeProgrammingLanguageRequest.getName())) {
		   this.programmingLanguageRepository.deleteById(programmingLanguage.getId());
	         
		}

	}
	
	}
	

	@Override
	public void update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception  {
		if(!isIdExist(id)) {
			throw new Exception("Id bulunamadı");
		}

		if(updateProgrammingLanguageRequest.getName().isEmpty())
		{
			throw new Exception("hata");
		}
		if(isNameExist(updateProgrammingLanguageRequest.getName())) {
			throw new Exception("Programlama dili daha önce girilmiş");
		}
		ProgrammingLanguage programmingLanguage=programmingLanguageRepository.findById(id).get();
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);
		
	}

	
	
	@Override
	public FindByIdProgrammingLanguageResponse FindById(
			int id) throws Exception {
		
		List<ProgrammingLanguage> programmingLanguages=programmingLanguageRepository.findAll();
		
		FindByIdProgrammingLanguageResponse responseItem=null;
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			
			if(programmingLanguage.getId()==id) {
				responseItem=new FindByIdProgrammingLanguageResponse();//burada new lememizin nedeni döngünün her adımında bellekte boş yere yer açmamak. Sadece kuralı sağladığında yeni alan açılmış olur.
			    responseItem.setName(programmingLanguage.getName());
			    responseItem.setId(programmingLanguage.getId());

                }
			if(responseItem==null) throw new Exception("Id bulunamamıştır.");
		}
		
		return responseItem;
		
			
	}

	
	public boolean isNameExist(String name) {
		for(ProgrammingLanguage programmingLanguage2: programmingLanguageRepository.findAll()) {
			if(programmingLanguage2.getName().equalsIgnoreCase(name) || name.isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isIdExist(int id) {
		for(ProgrammingLanguage programmingLanguage2: programmingLanguageRepository.findAll()) {
			if(programmingLanguage2.getId()==id)
			{
				return true;
			}
		}
		return false;
	}




	
}
