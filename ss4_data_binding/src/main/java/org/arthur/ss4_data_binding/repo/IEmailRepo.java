package org.arthur.ss4_data_binding.repo;

import org.arthur.ss4_data_binding.model.Email;

public interface IEmailRepo {
    void update(Email newEmail);
    Email getInfo();
}
