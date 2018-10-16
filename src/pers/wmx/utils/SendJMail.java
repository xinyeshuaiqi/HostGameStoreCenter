package pers.wmx.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	
		public static boolean sendMail(String email, String emailMsg) {
		
		String from = "xinye_shuaiqi@163.com"; 							// �ʼ������˵��ʼ���ַ
		String to = email; 												// �ʼ������˵��ʼ���ַ
		final String username = "xinye_shuaiqi@163.com";  				//�����˵��ʼ��ʻ�
		final String password = "jqx1997515";   						//�����˵��ʼ�Ӧ�����룬���ǵ�½ʱ�û�����


		//����Properties����,���û�����Ϣ
		Properties props = System.getProperties();

		//�����ʼ��������ĵ�ַ
		props.setProperty("mail.smtp.host", "smtp.163.com"); // ָ����smtp������
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");//���÷����ʼ�ʹ�õ�Э��
		//����Session����,session�����ʾ�����ʼ��Ļ�����Ϣ
		Session session = Session.getInstance(props);
		//�������������Ϣ
		session.setDebug(true);
		try {
			//Message��ʵ�������ʾһ������ʼ�
			MimeMessage message = new MimeMessage(session);
			//���÷����˵ĵ�ַ
			message.setFrom(new InternetAddress(from));
			//��������
			message.setSubject("�û�����");
			//�����ʼ����ı�����
			//message.setText("Welcome to JavaMail World!");
			message.setContent(emailMsg,"text/html;charset=utf-8");
			//��session�Ļ����л�ȡ�����ʼ��Ķ���
			Transport transport=session.getTransport();
			//�����ʼ�������
			transport.connect("smtp.163.com",25, username, password);
			//�����ռ��˵�ַ,��������Ϣ
			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
