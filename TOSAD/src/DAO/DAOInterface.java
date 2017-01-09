package DAO;

public interface DAOInterface {
	
	void createTable();

	void dropTable();

	void insert(String waarde);

	void deleteByPK(String selectPK);

	void updateByPK(String selectPK, String waarde);

}
