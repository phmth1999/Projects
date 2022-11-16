package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class VerSign {
	private static PublicKey readPublicKey(String key) throws Exception {
		FileInputStream fis = new FileInputStream(new File(key));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = br.readLine();
		byte[] b = Base64.getDecoder().decode(line);
		br.close();
		fis.close();

		X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey pubKey = factory.generatePublic(spec);
		return pubKey;
	}

	public void Ver(String sign, String data, String PublicKey) throws Exception {
		PublicKey pubKey = readPublicKey(PublicKey);
		
		FileInputStream signfis = new FileInputStream(new File(sign));
		byte[] signToVer = new byte[signfis.available()];
		signfis.read(signToVer);
		signfis.close();

		Signature rsa = Signature.getInstance("SHA256withRSA");
		rsa.initVerify(pubKey);
		
		FileInputStream datafis = new FileInputStream(new File(data));
		BufferedInputStream bis = new BufferedInputStream(datafis);
		byte[] input = new byte[1024];
		int len;
		while ((len = bis.read(input)) != -1) {
			rsa.update(input, 0, len);
		}
		;
		bis.close();

		boolean verfile = rsa.verify(signToVer);
		System.out.println("sign ver   " + verfile);
	}
	public static void main(String[] args) throws Exception {
		VerSign a= new VerSign();
		String Input="D:/ontap/17130222.jpg";
		String data="D:/17130222.jpg";
		String PublicKey="D:/publicKey_1024bit.txt";
		a.Ver(Input, data, PublicKey);
	}
}
