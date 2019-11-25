package sb.security.jwtsecurity.dao;

import org.springframework.data.repository.CrudRepository;

import sb.security.jwtsecurity.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUserName(String Username);
}
