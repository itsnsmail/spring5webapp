package com.ns.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ns.spring5webapp.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
