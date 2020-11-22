package com.travelsafeapp.org.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.travelsafeapp.org.dao.LBORepo;
import com.travelsafeapp.org.dao.OFRepo;
import com.travelsafeapp.org.model.LocationBasedOffers;
import com.travelsafeapp.org.model.OffersClaimed;


@RestController
public class Controller {

	@Autowired
	private  LBORepo repo;
	@Autowired
	private  OFRepo repo1;

	@PersistenceContext
	EntityManager em;
	@GetMapping("/offers/{cusid}")
	public List<LocationBasedOffers> getOffers(@PathVariable String cusid) {
		Query query = em.createQuery("SELECT l FROM LocationBasedOffers l WHERE  l.serialNum in (select serialNum from OffersClaimed where customerId like '"+cusid+"')");
		List<LocationBasedOffers> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		em.close();
		return resultList;
	}
	@GetMapping("/offers/{category}/{country}")
	public List<LocationBasedOffers> getOffers(@PathVariable String category,@PathVariable String country) {
		if(category.equals("all")) {
			return repo.findByCountryCode(country);
		}

		return repo.findByOfferCategoryAndCountryCode(category,country);
	}


	@GetMapping("offers/claim/{customerId}/{serialNum}")
	public void saveClaimedOffers(@PathVariable String customerId,@PathVariable int serialNum) 
	{
		repo1.save(new OffersClaimed(customerId,serialNum));
	}
//	@GetMapping("/")
//	public   void  saveee()
//	{repo.save(new LocationBasedOffers("","","","hi this is 1 ","","","","","",""));
//	repo.save(new LocationBasedOffers("","","","hi this is 2 ","","","","","",""));
//	repo.save(new LocationBasedOffers("","","","hi this is 3 ","","","","","",""));
//	repo1.save(new OffersClaimed("cus1",1));
//	repo1.save(new OffersClaimed("cus4",1));
//		repo1.save(new OffersClaimed("cus1",2));
//		repo1.save(new OffersClaimed("cus2",3));
//		System.out.println("asdf");
//	}
		

}









