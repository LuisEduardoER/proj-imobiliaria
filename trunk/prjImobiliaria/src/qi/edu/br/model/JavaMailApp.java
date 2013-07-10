package qi.edu.br.model;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import qi.edu.br.bean.ClienteBean;

public class JavaMailApp {
	 private String destinatario;
	 
	 
	 
	 public String getDestinatario() {
		return destinatario;
	}

	 public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}



	public void enviarEmail(Proposta p) throws Exception{
		/*Imovel i = new Imovel();
		i.setId(p.getIdImovel());
		ImovelBean ibean = new ImovelBean();
		i = ibean.find();*/
		Cliente c = new Cliente();
		 c.setId(p.getIdCliente());
		 ClienteBean cbean = new ClienteBean();
		 c = cbean.find(c);
		 this.setDestinatario(c.getEmail());
		 
	    Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "587");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication("prjimobiliariajava@gmail.com", "prjimobiliariajava123");
                         }
                    });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("prjimobiliariajava@gmail.com")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(this.getDestinatario());  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Enviando Proposta");//Assunto
                  message.setText("Olá, este é um email automático siguinificando que você tem uma proposta " +
                  		"referente ao imóvel ( Cód.Imóvel: "+p.getIdImovel()+" - Cód.Proposta: "+p.getId()+")");
                  
                  Transport.send(message);
            } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }finally{
            	session.setDebug(false);
            }
      }
	
	
	public void enviarSenha(Cliente c) throws Exception{
		
		 ClienteBean cbean = new ClienteBean();
		 c = cbean.find(c);
		 this.setDestinatario(c.getEmail());
		 
		 UUID uuid = UUID.randomUUID();  
		 String myRandom = uuid.toString();
		 String senha = myRandom.substring(0,10);
		   
		c.setSenha(senha);
		cbean.update(c);
		Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication("rafael.vivaa@gmail.com", "rafinhaviva");
                         }
                    });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("rafael.vivaa@gmail.com")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(this.getDestinatario());  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Nova Senha");//Assunto
                  message.setText("Olá, sua nova senha é: "+senha);
                  
                  Transport.send(message);
            } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }finally{
            	session.setDebug(false);
            }
      }
}
