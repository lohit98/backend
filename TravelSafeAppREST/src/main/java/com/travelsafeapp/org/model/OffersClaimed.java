package com.travelsafeapp.org.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="offersclaimed")
public class OffersClaimed {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="offer_seq")
	@SequenceGenerator(name = "offer_seq", sequenceName = "offer_seq", initialValue = 1, allocationSize=1)
	private int no;
		private String customerId;
		private int serialNum;
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public int getSerialNum() {
			return serialNum;
		}
		public void setSerialNum(int serialNum) {
			this.serialNum = serialNum;
		}
		public OffersClaimed( String customerId, int serialNum) {
			super();
			this.customerId = customerId;
			this.serialNum = serialNum;
		}
		public OffersClaimed() {
			super();
		}
		@Override
		public String toString() {
			return "OffersClaimed [no=" + no + ", customerId=" + customerId + ", serialNum=" + serialNum + "]";
		}
		
		

}
