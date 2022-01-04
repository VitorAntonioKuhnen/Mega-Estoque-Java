/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.util;

import br.com.estoque.model.Usuario;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Vítor
 */
public class EnviaEmail {
    private Session session;

    public void criarSessaoEmail() {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("javacrud@outlook.com", "Crudjava");
            }
        });
        session.setDebug(true);
    }

    public void enviarEmailToken(Usuario usuario) {
        try {
            criarSessaoEmail();//faz a configuração do smtp e carrega a session
            Message mensagem = new MimeMessage(session);
            mensagem.setFrom(new InternetAddress("javacrud@outlook.com")); //Remetente
            mensagem.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(usuario.getEmail())); //Destinatário(s)
            mensagem.setSubject("Token de confirmação -=Mega Estoque=-");//Assunto
            //montando o corpo do e-mail
            StringBuilder contextoEmail = new StringBuilder();
            contextoEmail.append("Ola ").append(usuario.getNome());//Result Olá nome_pessoa Prego
            contextoEmail.append("\n\n\n");
            contextoEmail.append("Segue o seu Token para confirmação do cadastro de usuario: " + usuario.getToken());
            contextoEmail.append("\n\n\n");
            contextoEmail.append("Atenciosamente \nEquipe Mega Estoque");
            //fim da monategem o corpo do e-mail
            mensagem.setText(contextoEmail.toString());
            Transport.send(mensagem);
            System.out.println("Enviado!!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public void enviarEmailDados(Usuario usuario) {
        try {
            criarSessaoEmail();//faz a configuração do smtp e carrega a session
            Message mensagem = new MimeMessage(session);
            mensagem.setFrom(new InternetAddress("javacrud@outlook.com")); //Remetente
            mensagem.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(usuario.getEmail())); //Destinatário(s)
            mensagem.setSubject("Informações de Acesso -=Mega Estoque=-");//Assunto
            //montando o corpo do e-mail
            StringBuilder contextoEmail = new StringBuilder();
            contextoEmail.append("Ola ").append(usuario.getNome());//Result Olá nome_pessoa Prego
            contextoEmail.append("\n\n\n");
            contextoEmail.append("Segue o seus dados para acesso a conta: " + "\n\nLogin: " + usuario.getLogin() + "\nSenha: " + usuario.getSenha());
            contextoEmail.append("\n\n\n");
            contextoEmail.append("Atenciosamente \nEquipe Mega Estoque");
            //fim da monategem o corpo do e-mail
            mensagem.setText(contextoEmail.toString());
            Transport.send(mensagem);
            System.out.println("Enviado!!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
