package cn.sunn.forensiclion.service.impl;

import java.io.*;
import java.util.List;

import cn.sunn.forensiclion.dao.impl.FileDAOHibernate;
import cn.sunn.forensiclion.domain.Mfile;
import cn.sunn.forensiclion.service.IFileManager;

public class FileManagerImpl implements IFileManager {
	private FileDAOHibernate filedao;

	// 从File转到byte[]
	public byte[] getBytesFromFile(File f) {
		if (f == null) {
			return null;
		}
		try {
			FileInputStream stream = new FileInputStream(f);
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = stream.read(b)) != -1)
				out.write(b, 0, n);
			stream.close();
			out.close();
			return out.toByteArray();
		} catch (IOException e) {
		}
		return null;
	}

	// byte[]转file
	public File getFileFromBytes(byte[] b, String outputFile) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return file;
	}

	public void setFiledao(FileDAOHibernate filedao) {
		this.filedao = filedao;
	}

	public int saveasDocTemplete(Mfile file) {
		// TODO Auto-generated method stub

		file.setClass_("doctemplete");
		filedao.saveOrUpdate(file);
		return SUCCESS;
	}

	public int saveasCasePic(Mfile file) {
		// TODO Auto-generated method stub
		file.setClass_("casepic");
		filedao.saveOrUpdate(file);
		return SUCCESS;
	}

	public int saveasCaseDoc(Mfile file) {
		// TODO Auto-generated method stub
		file.setClass_("casedoc");
		filedao.saveOrUpdate(file);
		return SUCCESS;
	}

	public int delFile(Long id) {
		// TODO Auto-generated method stub
		filedao.deleteByKey(id);
		return SUCCESS;
	}

	public int editFileName(Mfile file) {
		// TODO Auto-generated method stub
		filedao.saveOrUpdate(file);
		return 0;
	}

	public List listDoctempletes() {
		// TODO Auto-generated method stub
		return filedao.listDoctempletes();
	}

	public Mfile listFile(Long id) {
		// TODO Auto-generated method stub
		return filedao.get(id);
	}

	public List listCasepics() {
		// TODO Auto-generated method stub
		return filedao.listCasepics();
	}

	public List listCasedocs() {
		// TODO Auto-generated method stub
		return filedao.listCasedocs();
	}

	public List findByPage(int offset, int pageSize,String Type) {
		// TODO Auto-generated method stub
		return filedao.findByPage(
				" from Mfile f where f.class_ = '" + Type +"'", offset,
				pageSize);
	}

}
