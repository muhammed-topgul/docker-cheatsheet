package com.mtopgul.server.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author muhammed-topgul
 * @since 09/11/2023 11:24
 */
@Component
public class Init implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        UserModel mtopgul = new UserModel("mtopgul", "mtopgul@xmail.com");
        UserModel jdoe = new UserModel("jdoe", "jdoe@xmail.com");

        userRepository.save(mtopgul);
        userRepository.save(jdoe);
    }
}
