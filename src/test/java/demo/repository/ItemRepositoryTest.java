package demo.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import demo.DemoApplication;
import demo.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    @Transactional
    public void savePermit() throws Exception {

        Item item = new Item();
        item.setDueDate(new Date());
        item.setName("Test item");
        Item saved = repository.save(item);

        Item found = repository.findOne(saved.getId());
        assertEquals("Test item", found.getName());
    }

}