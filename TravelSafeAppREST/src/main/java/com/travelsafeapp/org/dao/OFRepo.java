package com.travelsafeapp.org.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.demo.model.Location_Based_Offers;

import com.travelsafeapp.org.model.LocationBasedOffers;
import com.travelsafeapp.org.model.OffersClaimed;
@Repository
public interface OFRepo extends JpaRepository<OffersClaimed,Integer>{


}
