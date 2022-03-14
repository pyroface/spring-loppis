package se.iths.springloppis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springloppis.entity.ItemEntity;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {

}
