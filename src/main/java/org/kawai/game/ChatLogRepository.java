package org.kawai.game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatLogRepository extends JpaRepository<Chatlog, Long> {

}
