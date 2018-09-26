package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService {
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}
	
	@Override
	public List<PilotModel> getPilotList() {
		return archivePilot;
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		List<PilotModel> ListPilot = getPilotList();
		Iterator<PilotModel> iterPilot = ListPilot.iterator();
		
		PilotModel pilotTerkait;
		while (iterPilot.hasNext()) {
			pilotTerkait = iterPilot.next();
			String nomorLisensi = pilotTerkait.getLicenseNumber();
			if (nomorLisensi.equals(licenseNumber)) {
				return pilotTerkait;
			} 
		}
		
		return null;
	}

	@Override
	public PilotModel getPilotDetailById(String id) {
		List<PilotModel> ListPilot = getPilotList();
		Iterator<PilotModel> iterPilot = ListPilot.iterator();
		
		PilotModel pilotTerkait;
		while (iterPilot.hasNext()) {
			pilotTerkait = iterPilot.next();
			String idPilot = pilotTerkait.getId();
			if (idPilot.equals(id)) {
				return pilotTerkait;
			} 
		}
		
		return null;
	}
	
	

}
