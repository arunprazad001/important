package com.masai.Service;

import java.util.List;

import com.masai.beans.Mail;
import com.masai.exceptions.MailException;

public interface MailService {

	public String toSendMail(List<Mail> mails, String key) throws MailException;

	public Mail toStarredMail(String mail, Integer mid) throws MailException;

	public String toDeleteMail(String mail, Integer mid) throws MailException;

}
