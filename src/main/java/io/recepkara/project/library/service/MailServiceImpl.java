package io.recepkara.project.library.service;

import io.recepkara.project.library.repo.user.Customer;

public class MailServiceImpl implements MailService {
    @Override
    public void sendUserUpdatedMail(Customer customer) {
        System.out.printf("Hello your account is updated");
    }

    @Override
    public void sendUserCreatedMail(Customer customer) {
        System.out.println("Hello your account is created");

    }
}
