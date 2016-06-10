package demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{
    List<Item> findItemByName(String name);
}
