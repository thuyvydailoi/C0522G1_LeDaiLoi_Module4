package com.codegym.model.facility;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityId;

    private int are;

    private Double cost;

    private int maxPeople;

    private String standardRoom;

    private String descriptionOtherConvernience;

    private Double poolArea;

    private int numberOfFloors;

    private String facilityFree;

    private String isDelete;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contractSet;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "facilityTypeId")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "rentId")
    private RentType rentType;

    public Facility() {
    }

    public Facility(int facilityId, int are, Double cost, int maxPeople, String standardRoom,
                    String descriptionOtherConvernience, Double poolArea, int numberOfFloors,
                    String facilityFree, String isDelete, Set<Contract> contractSet, FacilityType facilityType,
                    RentType rentType) {
        this.facilityId = facilityId;
        this.are = are;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvernience = descriptionOtherConvernience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.isDelete = isDelete;
        this.contractSet = contractSet;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getAre() {
        return are;
    }

    public void setAre(int are) {
        this.are = are;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvernience() {
        return descriptionOtherConvernience;
    }

    public void setDescriptionOtherConvernience(String descriptionOtherConvernience) {
        this.descriptionOtherConvernience = descriptionOtherConvernience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
