package com.masai.system.DAO;

import com.masai.system.DTO.Admin;

public interface AdminDao {
	
	public void addAdmin(Admin admin);
	public Admin getAdminById(int adminId);
	public Admin getAdminByUsername(String username);
	public void updateAdmin(Admin admin);
	public void deleteAdminById(int adminId);
	
	
	

}
