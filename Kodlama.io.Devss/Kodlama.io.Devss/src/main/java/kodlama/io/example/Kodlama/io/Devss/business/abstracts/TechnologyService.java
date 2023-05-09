package kodlama.io.example.Kodlama.io.Devss.business.abstracts;

import java.util.List;

import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatProgrammingLanguageRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.CreatTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.RemoveTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.requests.UpdateTechnologyRequest;
import kodlama.io.example.Kodlama.io.Devss.business.response.GetAllTechnologyResponse;


public interface TechnologyService {

	void add(CreatTechnologyRequest creatTechnologyRequest) throws Exception;
	void update(int id,UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	void delete(RemoveTechnologyRequest removeTechnologyRequest) throws Exception;
	List<GetAllTechnologyResponse> FindAll();
	
}
