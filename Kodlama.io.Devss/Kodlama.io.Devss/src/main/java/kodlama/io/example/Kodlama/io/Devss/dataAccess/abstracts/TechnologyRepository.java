package kodlama.io.example.Kodlama.io.Devss.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.example.Kodlama.io.Devss.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

	
}
