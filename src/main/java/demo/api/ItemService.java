package demo.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Item;
import demo.repository.ItemRepository;


@RequestMapping("/api/item")
@RestController
public class ItemService {

    @Inject
    ItemRepository itemRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItem(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<Item> items = new ArrayList<Item>();
            CollectionUtils.addAll(items, itemRepository.findAll().iterator());
            return items;
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "{name}")
    public List<Item> getItem(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) {

        try {
            return itemRepository.findItemByName(name);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addItem(Item item) {

        try {
            itemRepository.save(item);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
}
