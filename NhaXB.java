/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Administrator
 */
public class NhaXB {
    private String maNXB;
    private String tenNXB;
    public NhaXB() {
        maNXB=null;
        tenNXB=null;
    }
    public NhaXB(String ma,String ten){
        this.maNXB=ma;
        this.tenNXB=ten;
    }
    public void setmaNXB(String ma){
        this.maNXB=ma;
    }
    public void settenNXB(String ten){
        this.tenNXB=ten;
    }
    public String getmaNXB(){
        return maNXB;
    }
    public String gettenNXB(){
        return tenNXB;
    }
}
