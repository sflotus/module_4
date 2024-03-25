package org.arthur.ss4_data_binding.service;

import org.arthur.ss4_data_binding.model.Email;

public interface IEmailService {
    void update(Email newEmail);
    Email getInfo();

}
