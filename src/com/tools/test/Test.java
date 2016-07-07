package com.tools.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

	private static ArrayList<String> filelist = new ArrayList<String>();

	@org.junit.Test
	public void comBinFolder() {
		List<File> flist=new ArrayList<File>();
		String filePath = "E:\\公司项目\\临沧网站\\UPLOAD";
		getFiles(filePath,flist);
		for(int i=0;i<flist.size();i++){
			File file=flist.get(i);
			String sql="insert into TBAttachmentInfo (vpath) values (\""+file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("UPLOAD")).replace("\\", "/")+"\");";
			System.out.println(sql);
		}
	}

	/*
	 * 通过递归得到某一路径下所有的目录及其文件
	 */
	static void getFiles(String filePath,List<File> flist) {
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				/*
				 * 递归调用
				 */
				getFiles(file.getAbsolutePath(),flist);
				filelist.add(file.getAbsolutePath());
				//System.out.println("显示" + filePath + "下所有子目录及其文件" + file.getAbsolutePath());
			} else {
				flist.add(file);
			}
		}
	}
}
