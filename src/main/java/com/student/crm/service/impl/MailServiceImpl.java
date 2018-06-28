package com.student.crm.service.impl;

import com.student.crm.domain.Mail;
import com.student.crm.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Override
    public void send(Mail mail) {
        if (mail != null) {
            if (mail.getEmployee() != null && mail.getEmployee().size() > 0) {
                List<String> employee = mail.getEmployee();
                Iterator<String> itEmp = employee.iterator();
                while (itEmp.hasNext()) {
                    String emailEmp = itEmp.next();
                    if (emailEmp == null) {
                        itEmp.remove();
                    } else {
                        simpleMailMessage.setTo(emailEmp);
                        simpleMailMessage.setSubject(mail.getTitle());
                        simpleMailMessage.setText(mail.getContents());
                        mailSender.send(simpleMailMessage);
                    }
                }
            }
            if (mail.getPotential() != null && mail.getPotential().size() > 0) {
                List<String> potential = mail.getPotential();
                Iterator<String> itPotential = potential.iterator();
                while (itPotential.hasNext()) {
                    String emialPotential = itPotential.next();
                    if (emialPotential == null) {
                        itPotential.remove();
                    } else {
                        simpleMailMessage.setTo(emialPotential);
                        simpleMailMessage.setSubject(mail.getTitle());
                        simpleMailMessage.setText(mail.getContents());
                        mailSender.send(simpleMailMessage);
                    }
                }
            }
        }
    }


}
