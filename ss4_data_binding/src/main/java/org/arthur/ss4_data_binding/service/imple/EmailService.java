package org.arthur.ss4_data_binding.service.imple;

import org.arthur.ss4_data_binding.model.Email;
import org.arthur.ss4_data_binding.repo.IEmailRepo;
import org.arthur.ss4_data_binding.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Autowired
    IEmailRepo emailRepo;

    @Override
    public void update(Email newEmail) {
        emailRepo.update(newEmail);
    }

    @Override
    public Email getInfo() {
        return emailRepo.getInfo();
    }
}
