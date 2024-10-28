package org.example.repo;

import org.example.model.Chats;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends ReactiveCrudRepository<Chats, Long> {
}
