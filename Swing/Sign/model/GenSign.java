package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class GenSign {
	
	public GenSign(){
		
	}

	private static PrivateKey readPrivateKey(String key) throws Exception {
		FileInputStream fis = new FileInputStream(new File(key));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = br.readLine();
		byte[] b = Base64.getDecoder().decode(line);
		br.close();
		fis.close();

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey priKey = factory.generatePrivate(spec);
		return priKey;
	}

	public String Sign(String Input, String PrivateKey) throws Exception {
		PrivateKey priKey = readPrivateKey(PrivateKey);
		
		Signature rsa = Signature.getInstance("SHA256withRSA");
		rsa.initSign(priKey);
		
		FileInputStream fis = new FileInputStream(new File(Input));
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] input = new byte[1024];
		int len;
		while ((len = bis.read(input)) != -1) {
			rsa.update(input, 0, len);
		}
		;
		bis.close();
		byte[] readSign = rsa.sign();
		
		return Base64.getEncoder().encodeToString(readSign);

	}
	public static void main(String[] args) throws Exception {
		GenSign a= new GenSign();
		String Input="D:/17130222.jpg";
		String PrivateKey="D:/privateKey_1024bit.txt";
		a.Sign(Input, PrivateKey);
		System.out.println("ok");
	}
}
