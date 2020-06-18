/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author ASUS
 */
public class Vipham {
    private String idbook;
    private String idcard;
    private String content;
    private String penalize;
    private String money;
    public Vipham(){
        idbook=null;
        idcard=null;
        content=null;
        penalize=null;
        money=null;
    }
    public Vipham(String masach,String mathe, String nd, String ht,String tien){
        this.idbook=masach;
        this.idcard=mathe;
        this.content=nd;
        this.penalize=ht;
        this.money=tien;
    }
    public void setidbook(String masach){
        this.idbook=masach;
    }
    public void setidcard(String mathe){
        this.idcard=mathe;
    }
    public void setcontent(String nd){
        this.content=nd;
    }
  
    public void setpenalize(String ht){
        this.penalize=ht;
    }
    public void setidmoney(String tien){
        this.money=tien;
    }
    public String getidbook(){
        return idbook;
    }
    public String getidcard(){
        return idcard;
    }
    public String getcontent(){
        return content;
    }
    
    public String getpenalize(){
        return penalize;
    }
   
    public String getidmoney(){
        return money;
    }
}
