package com.elte.alkfejl.repositories;

import com.elte.alkfejl.entities.Label;
import com.elte.alkfejl.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
    Iterable<Label> findAllByCreatedBy(User user);
}
