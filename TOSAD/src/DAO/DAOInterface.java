package DAO;

public interface DAOInterface {
	
	boolean createTable();

	boolean dropTable();

	boolean insert(String waarde);

	boolean deleteByPK(String selectPK);

	boolean updateByPK(String selectPK, String waarde);

}
