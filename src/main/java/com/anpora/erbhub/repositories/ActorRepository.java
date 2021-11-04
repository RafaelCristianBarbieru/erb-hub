package com.anpora.erbhub.repositories;

import com.anpora.erbhub.dao.relational.ActorRelDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Rafael Barbieru, Popular Belbase, Anton Kamenov
 */
public interface ActorRepository extends JpaRepository<ActorRelDAO, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM actors A " +
            "JOIN actors_characters AC ON A.id = AC.actor_id " +
            "JOIN characters C on C.id = AC.character_id " +
            "JOIN battles_characters BC ON C.id = BC.character_id " +
            "WHERE AC.character_id = ?1 AND BC.battle_id = ?2")
    List<ActorRelDAO> findActorsByCharacterAndBattle(Long characterId, Long battleId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM actors A " +
            "JOIN actors_characters AC on A.id = AC.actor_id " +
            "WHERE AC.character_id = ?1")
    List<ActorRelDAO> findActorsByCharacter(Long characterId);

}
