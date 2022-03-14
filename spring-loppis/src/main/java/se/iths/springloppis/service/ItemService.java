package se.iths.springloppis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.springloppis.entity.ItemEntity;
import se.iths.springloppis.repository.ItemRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    // FIELD INJECTION NOT RECOMMENDED
    //@Autowired
    ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public ItemEntity createItem(ItemEntity itemEntity){
        return itemRepository.save(itemEntity);
    }

    public void deleteItem(Long id){
        ItemEntity foundItem =  itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        itemRepository.deleteById(foundItem.getId());
    }

    public Optional<ItemEntity> findItemById(Long id){
        return itemRepository.findById(id);
    }

    public Iterable<ItemEntity> findAllItems(){
        return itemRepository.findAll();
    }

}
