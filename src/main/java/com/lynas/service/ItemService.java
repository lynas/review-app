package com.lynas.service;

import com.lynas.exception.EntityNotFoundException;
import com.lynas.model.Item;
import com.lynas.repository.ItemRepository;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(Long itemId) throws EntityNotFoundException {
        Item item = itemRepository.findOne(itemId);
        if (item == null) {
            throw new EntityNotFoundException("Item not found with id:" + itemId);
        }
        return item;
    }
}
