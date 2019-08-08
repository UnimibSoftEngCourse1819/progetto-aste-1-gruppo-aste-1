package com.project.aste.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="Auctions")
public class Auction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAuction")
	private int idAuction;
	
	@NotNull
	@Column(name = "state")
	private boolean state;
	
	@NotNull(message = "error.auction.numTimeSlot.null")
	@Column(name = "numTimeSlot")
	private int numTimeSlot;
	
	@NotNull
	@Column(name = "terminationType")
	private boolean terminationType;
	
	@NotNull
	@Column(name = "cancellationPenalty")
	private boolean cancellationPenalty;
	
	@NotNull(message = "error.auction.timeSlotDuration.null")
	@Column(name = "timeSlotDuration")
	private LocalDateTime timeSlotDuration;
	
	@NotNull(message = "error.auction.startTimeSlot.null")
	@Column(name = "startTimeSlot")
	private LocalDateTime startTimeSlot;
	
	@NotNull(message = "error.auction.endTimeSlot.null")
	@Column(name = "endTimeSlot")
	private LocalDateTime endTimeSlot;
	
	@NotNull
	@Column(name = "closedEnvelop")
	private boolean closedEnvelop;
	
	
	@NotNull(message = "error.auction.idObjSer.null")
	@Column(name = "idObjSer")
	private int idObjSer;
	

	@Column(name = "winner")
	private String winner ;
	
	
	@Column(name = "decline")
	private boolean decline;
	
	
	public int getIdAuction() {
		return idAuction;
	}
	public void setIdAuction(int idAuction) {
		this.idAuction = idAuction;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public int getNumTimeSlot() {
		return numTimeSlot;
	}
	public void setNumTimeSlot(int numTimeSlot) {
		this.numTimeSlot = numTimeSlot;
	}
	public boolean isTerminationType() {
		return terminationType;
	}
	public void setTerminationType(boolean terminationType) {
		this.terminationType = terminationType;
	}
	public boolean isCancellationPenalty() {
		return cancellationPenalty;
	}
	public void setCancellationPenalty(boolean cancellationPenalty) {
		this.cancellationPenalty = cancellationPenalty;
	}
	public LocalDateTime getTimeSlotDuration() {
		return timeSlotDuration;
	}
	public void setTimeSlotDuration(LocalDateTime timeSlotDuration) {
		this.timeSlotDuration = timeSlotDuration;
	}
	public LocalDateTime getStartTimeSlot() {
		return startTimeSlot;
	}
	public void setStartTimeSlot(LocalDateTime startTimeSlot) {
		this.startTimeSlot = startTimeSlot;
	}
	public LocalDateTime getEndTimeSlot() {
		return endTimeSlot;
	}
	public void setEndTimeSlot(LocalDateTime endTimeSlot) {
		this.endTimeSlot = endTimeSlot;
	}
	public boolean isClosedEnvelop() {
		return closedEnvelop;
	}
	public void setClosedEnvelop(boolean closed) {
		this.closedEnvelop = closed;
	}
	
	public int getIdObjSer() {
		return idObjSer;
	}
	public void setIdObjSer(int idObjSer) {
		this.idObjSer = idObjSer;
	}
	public boolean isDecline() {
		return decline;
	}
	public void setDecline(boolean decline) {
		this.decline = decline;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	
	
	
}
