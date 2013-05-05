package cn.sunn.forensiclion.domain;



/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */

public class Dictionary  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Long parentid;
     private String name;
     private String code;
     private String content;
     private String remark;


    // Constructors

    /** default constructor */
    public Dictionary() {
    }

	/** minimal constructor */
    public Dictionary(Long id, Long parentid, String name, String code) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.code = code;
    }
    
    /** full constructor */
    public Dictionary(Long id, Long parentid, String name, String code, String content, String remark) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.code = code;
        this.content = content;
        this.remark = remark;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return this.parentid;
    }
    
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}