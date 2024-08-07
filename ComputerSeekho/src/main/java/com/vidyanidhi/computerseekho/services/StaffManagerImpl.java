package com.vidyanidhi.computerseekho.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidyanidhi.computerseekho.entities.Enquiry;
import com.vidyanidhi.computerseekho.entities.Staff;
import com.vidyanidhi.computerseekho.repositories.StaffRepository;
@Service 
public class StaffManagerImpl implements StaffManager {

	@Autowired
	StaffRepository  repository;
	
	
	@Override
	public void addStaff(Staff s) {
		repository.save(s);
		
	}

	@Override
	public List<Staff> getStaff() {
		
		 return repository.findAll();
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void updateStaffData(Staff s, int id) {
		// TODO Auto-generated method stub
		repository.updateStaff(s.getStaff_name(), s.getPhoto_url(), s.getStaff_mobile(), s.getStaff_email(),
				s.getStaff_username(), s.getStaff_password(), s.getStaff_role(), id);
	}

	@Override
	public Optional<Staff> getStaff(int id) {
		
		return repository.findById(id);
	}

	@Override
	public Staff stafflogin(String name) {
		
		return repository.findByUsername(name);
	}
	@Override
	public List<Enquiry> getAllEnquiriesForStaff(int id) {
		Optional<Staff> staffOptional = repository.findById(id);
		if (staffOptional.isPresent()) {
			Staff staff = staffOptional.get();
			//return staff.getEnquiries();
			return null;
		}
		return new ArrayList<>();// Return an empty list if staff not found
	}

}
