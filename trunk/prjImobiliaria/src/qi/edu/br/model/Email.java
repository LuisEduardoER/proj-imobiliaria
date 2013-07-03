package qi.edu.br.model;

import java.util.List;
import java.util.Map;

public class Email {
    //indica se o formato de texto será texto ou html
    public static final String TYPE_TEXT_PLAIN = "text/plain";
    public static final String TYPE_TEXT_HTML = "text/html";
    //indica qual será o servidor de email(gmail, hotmail...)         
    private String smtpHostMail;
    //indica a porta de acesso ao servidor
    private String smtpPortMail;
    //indica que a necessidade de autenticação no servidor(true ou false)
    private String smtpAuth;
    //indica ao servidor que ele está recebendo uma conexão segura
    private String smtpStarttls;
    //nome do remetente do email
    private String fromNameMail;
    //email do remetente
    private String userMail;
    //senha do email do remetente
    private String passMail;
    //assunto do email
    private String subjectMail;
    //corpo do email, onde estará o texto da mensagem
    private String bodyMail;
    //lista com email e nome dos destinatários
    private Map<String, String> toMailsUsers;
    //lista contendo os arquivos anexos
    private List<String> fileMails;
    //charset, no caso de html é necessário 
    private String charsetMail;
    //tipo do formato da mensagem, texto ou html
    private String typeTextMail;
 
         // gere os métodos getters and setters
}