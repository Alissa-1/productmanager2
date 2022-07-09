package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product item1 = new Book(1, "nameqwerty1", 60, "author1");
    Product item2 = new Book(2, "name2", 70, "author2");
    Product item3 = new Smartphone(3, "name3", 80, "manuf3");
    Product item4 = new Smartphone(4, "name4", 90, "manuf4");
    Product item5 = new Smartphone(1, "nameqwerty1", 60, "author1");

    @BeforeEach
    public void setup() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
    }


    @Test
    public void shouldRemoveByIdOneProduct() {
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnMassageIfIdDoesntExist() {
        Assertions.assertThrows(NotFoundException.class, ()-> {
            repo.removeById(115);
        });
    }

    @Test
    public void shouldAddOneProductIfUniqueId() {
        repo.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnMassageIfIdAlreadyExistWhenAdd() {

        Assertions.assertThrows(AlreadyExistsException.class, ()-> {
            repo.add(item5);
        });
    }
}

