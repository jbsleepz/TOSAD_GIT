package DAO;

public interface DAOInterface {
	
	void createTable();


	void insert(String waarde);


	void updateByPK(String selectPK, String waarde);

}
