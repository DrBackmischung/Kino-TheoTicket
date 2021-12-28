package de.wi2020sebgroup1.cinemachatbot.rest;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CallRepository extends CrudRepository<Call, UUID>{

}
