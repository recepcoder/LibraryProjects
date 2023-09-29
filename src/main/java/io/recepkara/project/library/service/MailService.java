package io.recepkara.project.library.service;

import io.recepkara.project.library.repo.user.Customer;

public interface MailService {
    void  sendUserUpdatedMail(
        Customer customer);
    void  sendUserCreatedMail(
        Customer customer);

    }

