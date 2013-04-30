package cn.sunn.forensiclion.action;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.sunn.forensiclion.action.base.FileBaseAction;
import cn.sunn.forensiclion.domain.MFile;
import cn.sunn.forensiclion.domain.User;

public class FileAction extends FileBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212191959793419574L;
	private static final int BUFFER_SIZE = 2 * 1024;
	private File file;
	private String name;
	private int chunk;
	private int chunks;
	private Long id;
	private InputStream  inputstream;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChunk() {
		return chunk;
	}

	public void setChunk(int chunk) {
		this.chunk = chunk;
	}

	public int getChunks() {
		return chunks;
	}

	public void setChunks(int chunks) {
		this.chunks = chunks;
	}

	private void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true),
						BUFFER_SIZE); // plupload 配置了chunk的时候新上传的文件appand到文件末尾
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
			}
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String upload() throws Exception {
		System.out.println(Integer.toString(chunk));
		System.out.println(Integer.toString(chunks));
		System.out.println(name);
		String dstPath = ServletActionContext.getServletContext().getRealPath(
				"\\tmp")
				+ "\\" + this.getName(); // 保存目录可以自己配置 或者定义变量自行配置
		File dstFile = new File(dstPath);

		// 文件已存在删除旧文件（上传了同名的文件）
		if (chunk == 0 && dstFile.exists()) {
			dstFile.delete();
			dstFile = new File(dstPath);
		}

		copy(this.file, dstFile);
		// System.out.println(uploadFileName + " " + uploadContentType + " "
		// + chunk + " " + chunks);
		if (chunk == chunks - 1) {
			// 一个完整的文件上传完成
			MFile mfile = new MFile();
			mfile.setData(filemgr.getBytesFromFile(dstFile));
			mfile.setFilename(dstFile.getName());
			mfile.setDatetime(new Date());
			filemgr.saveasDocTemplete(mfile);
			dstFile.delete();
		}

		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String listdoctempletes() throws Exception {
		System.out
				.println("------------------listdoctempletes---------------------------");
		int intPage = Integer.parseInt((this.getPage() == null || this
				.getPage() == "0") ? "1" : this.getPage());
		// 每页显示条数
		int number = Integer
				.parseInt((this.getRows() == null || this.getRows() == "0") ? "20"
						: this.getRows());
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<MFile> mfiles = filemgr.findByPage(start, number, "doctemplete");// 每页的数据，放入list 
		for (int i = 0; i < mfiles.size(); i++) {
			MFile mfile = mfiles.get(i);
			mfile.setData(null);
			mfiles.set(i, mfile);
		}

		this.getResult().put("total", filemgr.listDoctempletes().size());
		this.getResult().put("rows", mfiles);
		return SUCCESS;
	}

	public String del() throws Exception{
		System.out.println("------------------delfile---------------------------");
		if (id != null){
			filemgr.delFile(id);
			this.getResult().put("result", "success");
		}else{
			this.getResult().put("result", "fail");
		}
		return SUCCESS;
	}
	
	public String editname() throws Exception{
		System.out.println("------------------editname---------------------------");
		MFile mfile = filemgr.listFile(id);
		if (name != null){
			mfile.setFilename(name);
			filemgr.saveasDocTemplete(mfile);
			this.getResult().put("result", "success");
		}else
		{
			this.getResult().put("result", "fail");
		}
		return SUCCESS;
	}	
	
	/**
	 * 下载相关
	 * @return
	 * @throws Exception
	 */
	
	public InputStream getInputStream() throws Exception  {
		System.out.println(id.toString());
        MFile mfile = filemgr.listFile(id);
//        File outputFile ;
//        String dstPath = ServletActionContext.getServletContext().getRealPath(
//				"\\tmp")
//				+ "\\" + mfile.getFilename();
//        outputFile = filemgr.getFileFromBytes(mfile.getData(), dstPath);
        //return new FileInputStream(outputFile);    
        return  new ByteArrayInputStream(mfile.getData());
    }
	
	public String download() throws Exception {
		
		return SUCCESS;
	}
	
}
