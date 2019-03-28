package com.kbtg.course.spring.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void count_user_2() {
        userRepository.save(new User("n1",1));
        userRepository.save(new User("n2",2));

        int actual = (int)userRepository.count();

        assertEquals(2, actual);
        //Rollback transaction
    }
}