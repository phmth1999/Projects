package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenKey {
	public GenKey(){
		
	}
	private static File CreateKeyFile(File file) throws Exception {
		if (!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		return file;
	}
	public void GenerateKey(String fileOutput, int n) throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(n);

		KeyPair kp = kpg.genKeyPair();
		PublicKey publicKey = kp.getPublic();
		PrivateKey privateKey = kp.getPrivate();

		File publicKeyFile = CreateKeyFile(new File(fileOutput + "/publicKey_" + n + "bit" + ".txt"));
		File privateKeyFile = CreateKeyFile(new File(fileOutput + "/privateKey_" + n + "bit" + ".txt"));

		FileOutputStream fosPublic = new FileOutputStream(publicKeyFile);
		BufferedOutputStream bosPublic = new BufferedOutputStream(fosPublic);
		byte[] rawDataPublicKey = publicKey.getEncoded();
		String encodedPublicKey = Base64.getEncoder().encodeToString(rawDataPublicKey);
		bosPublic.write(encodedPublicKey.getBytes());
		bosPublic.close();
		fosPublic.close();

		FileOutputStream fosPrivate = new FileOutputStream(privateKeyFile);
		BufferedOutputStream bosPrivate = new BufferedOutputStream(fosPrivate);
		byte[] rawDataPrivateKey = privateKey.getEncoded();
		String encodedPrivateKey = Base64.getEncoder().encodeToString(rawDataPrivateKey);
		bosPrivate.write(encodedPrivateKey.getBytes());
		bosPrivate.close();
		fosPrivate.close();
	}
}
