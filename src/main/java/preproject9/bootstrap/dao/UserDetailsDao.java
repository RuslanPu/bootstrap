package preproject9.bootstrap.dao;

import preproject9.bootstrap.model.User;


public interface UserDetailsDao {

    User getUserByName(String username);

}
