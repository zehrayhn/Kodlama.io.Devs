package kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts;

import java.util.List;

import kodlama.io.example.Kodlama.io.Devss.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage programmingLanguage);
	void update(ProgrammingLanguage programmingLanguage);
	void delete(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage getById(int id);
}
