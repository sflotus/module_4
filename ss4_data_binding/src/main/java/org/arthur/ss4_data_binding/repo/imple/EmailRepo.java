package org.arthur.ss4_data_binding.repo.imple;

import org.arthur.ss4_data_binding.model.Email;
import org.arthur.ss4_data_binding.repo.IEmailRepo;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepo implements IEmailRepo {
    static Email email;
    static {
         email = new Email("English",25,true,"Arthur");
    }

    @Override
    public void update(Email newEmail) {
        email = newEmail;
    }

    @Override
    public Email getInfo() {
        return email;
    }

}
