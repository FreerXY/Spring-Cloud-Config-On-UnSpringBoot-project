package spider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class RetrivePage {
	private static HttpClient httpClient = new HttpClient();

	public static boolean downloadPage(String path) throws HttpException,
			IOException {
		InputStream input = null;
		OutputStream output = null;
		// �õ�post����
		GetMethod postMethod = new GetMethod(path);
		// ����post�����Ĳ���
		/*
		 * NameValuePair[] postData = new NameValuePair[2]; postData[0] = new
		 * NameValuePair("name","lietu"); postData[1] = new
		 * NameValuePair("password","*****");
		 * postMethod.addParameters(postData);
		 */
		// ִ�У�����״̬��
		int statusCode = httpClient.executeMethod(postMethod);
		System.out.println("statusCode="+statusCode);
		System.out.println("HttpStatus.SC_MOVED_TEMPORARILY="+HttpStatus.SC_MOVED_TEMPORARILY);
		System.out.println("HttpStatus.SC_MOVED_PERMANENTLY="+HttpStatus.SC_MOVED_PERMANENTLY);
		System.out.println("HttpStatus.SC_SEE_OTHER="+HttpStatus.SC_SEE_OTHER);
		// ���״̬����д��� (�������ֻ������ֵΪ200��״̬��)
		if (statusCode == HttpStatus.SC_OK) {
			input = postMethod.getResponseBodyAsStream();
			//�õ��ļ���
			String filename = path.substring(path.lastIndexOf('/')+1);
			//����ļ������
			output = new FileOutputStream(filename);
			//������ļ�
			int tempByte = -1;
			while((tempByte=input.read())>0){
				output.write(tempByte);
			}
			//�ر����������
			if(input!=null){
				input.close();
			}
			if(output!=null){
				output.close();
			}
			return true;
		}
		//����Ҫת�������ת�����
		if ((statusCode == HttpStatus.SC_MOVED_TEMPORARILY) || 
				(statusCode == HttpStatus.SC_MOVED_PERMANENTLY) || 
				(statusCode == HttpStatus.SC_SEE_OTHER) || 
				(statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
		    //��ȡ�µ�URL��ַ
			Header header = postMethod.getResponseHeader("location");
			if(header!=null){
				String newUrl = header.getValue();
				if(newUrl==null||newUrl.equals("")){
					newUrl="/";
					//ʹ��postת��
					PostMethod redirect = new PostMethod(newUrl);
					//������������һ��������������
				}
			}
		}
		return false;
	}

	/**
	 * ���Դ���
	 */
	public static void main(String[] args) {
		// ץȡlietu��ҳ,���
		try {
			RetrivePage.downloadPage("http://localhost:8000/foobar-dev.properties");
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
