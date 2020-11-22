package com.travelsafeapp.org.dao;

import java.util.List;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.example.demo.model.Location_Based_Offers;

import com.travelsafeapp.org.model.LocationBasedOffers;
@Repository
public interface LBORepo extends JpaRepository<LocationBasedOffers,Integer>{
	
	
	@Query("FROM lbo4 WHERE offer_category = ?1 && country_code  = ?2")
	List<LocationBasedOffers> findByOfferCategoryAndCountryCode( String offerCategory, String countryCode);
	
	
	@Query("FROM lbo4 WHERE country_code  = ?1")
	List<LocationBasedOffers> findByCountryCode(String countryCode);

	

	
	
	


}
