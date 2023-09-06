package cz.ivosahlik.producer.repository;

import cz.ivosahlik.producer.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<Dummy, Integer> {
}
