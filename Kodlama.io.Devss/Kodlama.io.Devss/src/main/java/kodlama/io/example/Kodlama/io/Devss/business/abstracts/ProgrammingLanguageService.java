package kodlama.io.example.Kodlama.io.Devss.business.abstracts;

import java.util.List;

import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(ProgrammingLanguage programmingLanguage) throws Exception;
	ProgrammingLanguage getById(int id);
}
