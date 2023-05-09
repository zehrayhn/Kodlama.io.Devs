package kodlama.io.example.Kodlama.io.Devss.business.abstracts;

import java.util.List;

import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.response.FindByIdProgrammingLanguageResponse;
import kodlama.io.example.Kodlama.io.Devss.business.response.GetAllProgrammingLanguageResponse;


public interface ProgrammingLanguageService {

	List<GetAllProgrammingLanguageResponse> findAll();
	void add(CreatProgrammingLanguageRequest creatProgrammingLanguageRequest) throws Exception;
//	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	void remove(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest) throws Exception;
    FindByIdProgrammingLanguageResponse FindById(int id) throws Exception;
}
