package com.mtopgul.server.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author muhammed-topgul
 * @since 09/11/2023 11:21
 */
@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

    UserModel findByUsername(String username);
}
