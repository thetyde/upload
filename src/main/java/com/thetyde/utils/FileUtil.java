package com.thetyde.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	/**
	 * 小文件上传
	 * 
	 * @param file
	 * @param filePath
	 * @param fileName
	 */
	public static void uploadFile(byte[] file, String filePath, String fileName) {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try (FileOutputStream out = new FileOutputStream(filePath + fileName)) {
			out.write(file);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
