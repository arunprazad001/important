package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repositories.MailRepo;
import com.masai.Repositories.SessionDao;
import com.masai.Repositories.UserRepo;
import com.masai.beans.CurrentUserSession;
import com.masai.beans.Mail;
import com.masai.beans.User;
import com.masai.exceptions.MailException;
import com.masai.exceptions.UserException;

@Service
public class MailServiceImple implements MailService {
	
	@Autowired
	private MailRepo mr;
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private SessionDao sdo;
	
	
	
	@Override
	public String toSendMail(List<Mail> mails, String key) throws MailException {
		
		CurrentUserSession s = sdo.findByUuid(key);
		
		if(s==null) {
			throw new UserException("User not logged in");
		}
		
		
		
		for(Mail i:mails) {
			String uer = i.getSendto();
			String sender=s.getMailid();
			i.setSender(sender);
			
			Optional<User> user = ur.findById(uer);
	
			if(user.isPresent()) 
			{	List<Mail> maillist = user.get().getMails();
				maillist.add(i);
				ur.save(user.get());
			}
			else {
				throw new MailException("No such mailid exist");
			}
		}
		
		return "Mails sent";
		
	}

	@Override
	public Mail toStarredMail(String keyid, Integer mid) throws MailException {
		
		CurrentUserSession cus = sdo.findByUuid(keyid); 
		
		if(cus==null) throw new UserException("User not logged in");
		
		
		
		Optional<Mail> m = mr.findById(mid);
		
		if(m.isEmpty()) throw new MailException("No mail found");
		
		m.get().setStarred(true);
		
		mr.deleteById(mid);
		
		return mr.save(m.get());
		
		
		
		
		
	}

	@Override
	public String toDeleteMail(String mail, Integer mid) throws MailException {
		
		Optional<User> u = ur.findById(mail);
		
		if(u.isEmpty()) {
			throw new UserException("No User by Mail Found");
		}
		
		List<Mail> maildb = u.get().getMails();
		
		
		
			for(int i=0; i<maildb.size(); i++) {
				if(maildb.get(i).getId()==mid) {
					maildb.remove(i);
					ur.save(u.get());
					return "Mail deleted";
				}
			}
		
		
		throw new MailException("No mail found");
		
	}

}
