package assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment.entity.PortfolioItem;

@Repository
public interface ItemRepository extends JpaRepository<PortfolioItem, Long> {

}
