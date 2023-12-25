/**
 * Postgreden --> Mongoya
 * JpaRepository<T, ID> -> MongoRepository<T, ID>
 */

package com.ba.boost.repository;

import com.ba.boost.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends MongoRepository<UserProfile, String> {

    Optional<UserProfile> findOptionalByAuthId(Long autId);
}
