package dao;

import java.util.List;

public interface AdminDAO {
	public void insertAdmin(Admin admin); //C
	public Admin selectAdmin(int adminId);//R
	public List<Admin> selectAdmin(); //RA
	public void updateAdmin(Admin admin); //U
	public void deleteAdmin(int adminId);  //D
}