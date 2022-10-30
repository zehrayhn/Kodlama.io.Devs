package kodlama.io.example.Kodlama.io.Devss.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;
@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	
	public InMemoryProgrammingLanguageRepository() {
	
		programmingLanguages=new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
	
		return programmingLanguages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
	
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage programmingLanguage2 : programmingLanguages) {
			if(programmingLanguage2.getId()==programmingLanguage.getId()) {
				programmingLanguage2.setName(programmingLanguage.getName());
			}
		}
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.remove(getById(programmingLanguage.getId()));
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		for (ProgrammingLanguage programmingLanguage2 : programmingLanguages) {
			if(programmingLanguage2.getId()==id) {
				return programmingLanguage2;
			}
			
		}
		return null;
	}

}
