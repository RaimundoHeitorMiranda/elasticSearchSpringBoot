package com.rhm.estagio.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhm.estagio.exceptions.ResourceNotFound;
import com.rhm.estagio.exceptions.SocialNetworkNameAlreadyExists;
import com.rhm.estagio.models.SocialNetwork;
import com.rhm.estagio.repositories.SocialNetworkRepository;
import com.rhm.estagio.services.SocialNetworkService;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService {

	
	@Autowired
	private SocialNetworkRepository networkRepository;

	@Override
	public SocialNetwork register(SocialNetwork social) {
		
		social.setId(UUID.randomUUID().toString());
		
		if(existsByName(social.getName())) {
			throw new SocialNetworkNameAlreadyExists("The Name of SocialNetWork Already exists");
		}
		return this.networkRepository.save(social);
	}

	@Override
	public SocialNetwork getById(String id) {		
		return this.networkRepository.findById(id).get();
	}

	@Override
	public SocialNetwork getByName(String name) {
		
		if(! existsByName(name)) {
			throw new ResourceNotFound("The social NetWork with name: " + name + " not found");
		}
		
		return this.networkRepository.findByName(name).get();
	}

	@Override
	public List<SocialNetwork> getAll() {
		Iterable<SocialNetwork> iterator = this.networkRepository.findAll();
		List<SocialNetwork> list = new ArrayList<SocialNetwork>();
		
		iterator.forEach(social -> list.add(social));
		
		return list;
	}

	@Override
	public SocialNetwork update(SocialNetwork updateSocial, String name) {
		Optional<SocialNetwork> social = this.networkRepository.findByName(name);
		
		if(! social.isPresent()) {
			throw new ResourceNotFound("The social NetWork with name: " + name + " not found");
		}
		
		Optional<SocialNetwork> socialVerific = this.networkRepository.findByName(updateSocial.getName());
		
		if(socialVerific.isPresent()) {
			throw new ResourceNotFound("The social NetWork with name: " + updateSocial.getName()+ " Already exists");
		}
		
		updateSocial.setId(social.get().getId());
		return this.networkRepository.save(updateSocial);
		
	}

	@Override
	public void delete(String name) {
				
		if(! existsByName(name)) {
			throw new ResourceNotFound("The social NetWork with name: " + name + " not found");
		}
		
		this.networkRepository.deleteByName(name);		
	}

	@Override
	public Boolean existsByName(String name) {
		return this.networkRepository.findByName(name).isPresent();
	}

}
