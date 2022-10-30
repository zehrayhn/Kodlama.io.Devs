package kodlama.io.example.Kodlama.io.Devss.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.example.Kodlama.io.Devss.business.abstracts.ProgrammingLanguageService;
import kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {

		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
	   if(isIdExist(programmingLanguage.getId())){
		   throw new Exception("Girilen id kayıtlı");
	   }
	   if(isNameExist(programmingLanguage)) {
		   throw new Exception("Geçersiz değer girildi.");
	   }
	   programmingLanguageRepository.add(programmingLanguage);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
//		if(isIdExist(programmingLanguage.getId())){
//			   throw new Exception("Girilen id kayıtlı");
//		   }
//		   if(isNameExist(programmingLanguage)) {
//			   throw new Exception("Geçersiz değer girildi.");
//		   }
		   programmingLanguageRepository.update(programmingLanguage);
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception {
		if (!isIdExist(programmingLanguage.getId())) {
			throw new Exception("Geçersiz id");
		}
		programmingLanguageRepository.delete(programmingLanguage);
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return programmingLanguageRepository.getById(id);
	}
	
	public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage programmingLanguage2:getAll()) {
			if(programmingLanguage2.getName().equalsIgnoreCase(programmingLanguage.getName()) || programmingLanguage.getName().isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isIdExist(int id) {
		for(ProgrammingLanguage programmingLanguage2: getAll()) {
			if(programmingLanguage2.getId()==id)
			{
				return true;
			}
		}
		return false;
	}

	
}
