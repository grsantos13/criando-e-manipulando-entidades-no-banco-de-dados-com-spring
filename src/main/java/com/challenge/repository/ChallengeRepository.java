package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query(" select distinct c from Challenge c" +
            " join c.accelerations a " +
            " join a.candidates cand " +
            " join cand.id.user u " +
            " where u.id = :userId and a.id = :accelerationId ")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                  @Param("userId") Long userId);
}
