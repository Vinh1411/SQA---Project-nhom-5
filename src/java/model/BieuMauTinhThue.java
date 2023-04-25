/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
public class BieuMauTinhThue implements Serializable{

    protected ToKhaiThue toKhaiThue;
    
    protected long tongTienTruocThue;
    protected long tongTienDuocMienGiam;
    protected long tongTienThuePhaiDong;
    
    private long tienMienCaNhan = 11000000;
    private long tienPhuThuocTN = 4400000;
    
    private long tienThueDauTu;
    private long tienThueKinhDoanh;
    private long tienThueBDS;
    private long tienThueTrungThuong;
    private long tienThueLuong;
    private ArrayList<ThueLuongTheoBac> dsThueLuongTheoBac;

    private int[] dsBacThueLuong={5, 10, 15, 20, 25, 30, 35};
    private long [] dsKhoangBacThang={5000000, 5000000, 8000000, 14000000, 20000000, 28000000, -1};
    private long [] dsKhoangBacNam={60000000, 60000000, 96000000, 168000000, 240000000, 336000000, -1};
    
    //Thue suat kinh doanh tuong ung voi vi tri 0
    //Thue suat dau tu tuong ung voi vi tri 1
    //Thue suat bat dong san tuong ung voi vi tri 2
    //Thue suat voi trung thuong tuong ung voi vi tri 3
    //Thue suat voi doi tuong hop dong lao dong nho hon 3 thang vi tri 4
    //Thue suat voi doi tuong khong cu tru vi tri 5
    private int [] dsThueToanPhan={5, 5, 2, 10, 10, 20};
    
    private int thueSuatToanPhanLuong;
    
    public BieuMauTinhThue(){
        
    }
    
    public BieuMauTinhThue(ToKhaiThue toKhaiThue) {
        this.toKhaiThue = toKhaiThue;
        if(toKhaiThue.getKyTinhThue().compareTo("Theo tháng") != 0){
            tienMienCaNhan = 11000000*12;
            tienPhuThuocTN = 4400000*12;
        }
        this.tongTienTruocThue = toKhaiThue.getTienLuong() + toKhaiThue.getTienDauTu() + toKhaiThue.getTienKinhDoanh() + toKhaiThue.getTienTrungThuong() + toKhaiThue.getTienBatDongSan();
        this.tongTienDuocMienGiam =  toKhaiThue.getTienTuThien() + toKhaiThue.getTienDongBaoHiem() + toKhaiThue.getTienHuuTri() + tienMienCaNhan + tienPhuThuocTN * toKhaiThue.getSoNguoiPhuThuoc();
        this.tienThueDauTu = (long) (toKhaiThue.getTienDauTu() * dsThueToanPhan[1]/100);
        this.tienThueKinhDoanh = (long) (toKhaiThue.getTienKinhDoanh() * dsThueToanPhan[0]/100);
        this.tienThueBDS = (long) (toKhaiThue.getTienBatDongSan() * dsThueToanPhan[2]/100);
        if (toKhaiThue.getTienTrungThuong() >= 10000000) {
            this.tienThueTrungThuong = (long) (toKhaiThue.getTienTrungThuong() * dsThueToanPhan[3]/100);
        } else {
            this.tienThueTrungThuong = 0;
        }
        if (toKhaiThue.getDoiTuongDong().compareTo("Cư trú có hợp đồng >= 3 tháng") == 0) {
            long temp = (toKhaiThue.getTienLuong() - this.tongTienDuocMienGiam);
            if (temp < 0) {
                this.tienThueLuong = 0;
            }
            else{
                dsThueLuongTheoBac=new ArrayList<>();
                if (toKhaiThue.getKyTinhThue().compareTo("Theo tháng") == 0) {
                    int i=0;
                    while(temp!=0){
                        temp = bacGiam(dsBacThueLuong[i], temp, dsKhoangBacThang[i]);
                        i=i+1;
                    }
                } else {
                    int i=0;
                    while(temp!=0){
                        temp = bacGiam(dsBacThueLuong[i], temp, dsKhoangBacNam[i]);
                        i=i+1;
                    }
                }
            }
            this.tongTienThuePhaiDong = this.tienThueKinhDoanh + this.tienThueKinhDoanh + this.tienThueBDS+this.tienThueTrungThuong+tienThueLuong;
        } else {
            if (toKhaiThue.getDoiTuongDong().compareTo("Cư trú có hợp đồng < 3 tháng") == 0) {
                thueSuatToanPhanLuong=dsThueToanPhan[4];
                this.tienThueLuong=(toKhaiThue.getTienLuong() - this.tongTienDuocMienGiam) * dsThueToanPhan[4] / 100;
                if (this.tienThueLuong < 0) {
                    this.tienThueLuong = 0;
                }
                this.tongTienThuePhaiDong = this.tienThueKinhDoanh + this.tienThueKinhDoanh + this.tienThueBDS+this.tienThueTrungThuong+tienThueLuong;
            } else {
                thueSuatToanPhanLuong=dsThueToanPhan[5];
                this.tienThueLuong = (toKhaiThue.getTienLuong() - this.tongTienDuocMienGiam) * dsThueToanPhan[5] / 100;
                if (this.tienThueLuong < 0) {
                    this.tienThueLuong = 0;
                }
                this.tongTienThuePhaiDong += this.tienThueKinhDoanh + this.tienThueKinhDoanh + this.tienThueBDS+this.tienThueTrungThuong+tienThueLuong;
            }
        }
    }

    private long bacGiam(int thueSuat, long tienConLai, long nguong) {
        if (nguong != -1) {
            if (tienConLai <= nguong) {
                long temp=tienConLai * thueSuat / 100;
                dsThueLuongTheoBac.add(new ThueLuongTheoBac(tienConLai, temp));
                tienThueLuong+=temp;
                tienConLai = 0;
            } else {
                long temp=nguong * thueSuat / 100;
                dsThueLuongTheoBac.add(new ThueLuongTheoBac(nguong, temp));
                tienThueLuong+=temp;
                tienConLai -= nguong;
            }
            return tienConLai;
        } else {
            long temp=tienConLai * thueSuat / 100;
            dsThueLuongTheoBac.add(new ThueLuongTheoBac(tienConLai, temp));
            tienThueLuong+=temp;
            return 0;
        }
    }

    public ToKhaiThue getToKhaiThue() {
        return toKhaiThue;
    }

    public void setToKhaiThue(ToKhaiThue toKhaiThue) {
        this.toKhaiThue = toKhaiThue;
    }

    public long getTongTienTruocThue() {
        return tongTienTruocThue;
    }

    public void setTongTienTruocThue(long tongTienTruocThue) {
        this.tongTienTruocThue = tongTienTruocThue;
    }

    public long getTongTienDuocMienGiam() {
        return tongTienDuocMienGiam;
    }

    public void setTongTienDuocMienGiam(long tongTienDuocMienGiam) {
        this.tongTienDuocMienGiam = tongTienDuocMienGiam;
    }

    public long getTongTienThuePhaiDong() {
        return tongTienThuePhaiDong;
    }

    public void setTongTienThuePhaiDong(long tongTienThuePhaiDong) {
        this.tongTienThuePhaiDong = tongTienThuePhaiDong;
    }


    public long getTienPhuThuocTN() {
        return tienPhuThuocTN;
    }

    public void setTienPhuThuocTN(long tienPhuThuocTN) {
        this.tienPhuThuocTN = tienPhuThuocTN;
    }

    public long getTienThueDauTu() {
        return tienThueDauTu;
    }

    public void setTienThueDauTu(long tienThueDauTu) {
        this.tienThueDauTu = tienThueDauTu;
    }

    public long getTienThueKinhDoanh() {
        return tienThueKinhDoanh;
    }

    public void setTienThueKinhDoanh(long tienThueKinhDoanh) {
        this.tienThueKinhDoanh = tienThueKinhDoanh;
    }

    public long getTienThueBDS() {
        return tienThueBDS;
    }

    public void setTienThueBDS(long tienThueBDS) {
        this.tienThueBDS = tienThueBDS;
    }

    public long getTienThueTrungThuong() {
        return tienThueTrungThuong;
    }

    public void setTienThueTrungThuong(long tienThueTrungThuong) {
        this.tienThueTrungThuong = tienThueTrungThuong;
    }

    public long getTienThueLuong() {
        return tienThueLuong;
    }

    public void setTienThueLuong(long tienThueLuong) {
        this.tienThueLuong = tienThueLuong;
    }

    public ArrayList<ThueLuongTheoBac> getDsThueLuongTheoBac() {
        return dsThueLuongTheoBac;
    }

    public void setDsThueLuongTheoBac(ArrayList<ThueLuongTheoBac> dsThueLuongTheoBac) {
        this.dsThueLuongTheoBac = dsThueLuongTheoBac;
    }

    public int[] getDsBacThueLuong() {
        return dsBacThueLuong;
    }

    public void setDsBacThueLuong(int[] dsBacThueLuong) {
        this.dsBacThueLuong = dsBacThueLuong;
    }

    public long[] getDsKhoangBacThang() {
        return dsKhoangBacThang;
    }

    public void setDsKhoangBacThang(long[] dsKhoangBacThang) {
        this.dsKhoangBacThang = dsKhoangBacThang;
    }

    public long[] getDsKhoangBacNam() {
        return dsKhoangBacNam;
    }

    public void setDsKhoangBacNam(long[] dsKhoangBacNam) {
        this.dsKhoangBacNam = dsKhoangBacNam;
    }

    public int[] getDsThueToanPhan() {
        return dsThueToanPhan;
    }

    public void setDsThueToanPhan(int[] dsThueToanPhan) {
        this.dsThueToanPhan = dsThueToanPhan;
    }
    
    public long getTienMienGiamPhuThuoc(){
        return toKhaiThue.getSoNguoiPhuThuoc()*this.tienPhuThuocTN;
    }
    
    public long getSoTienLuongChiuThue(){
        if(toKhaiThue.getTienLuong()-this.tongTienDuocMienGiam<0){
            return 0;
        }
        else{
            return toKhaiThue.getTienLuong()-this.tongTienDuocMienGiam;
        }
    }

    public int getThueSuatToanPhanLuong() {
        return thueSuatToanPhanLuong;
    }

    public long getTienMienCaNhan() {
        return tienMienCaNhan;
    }

    public void setTienMienCaNhan(long tienMienCaNhan) {
        this.tienMienCaNhan = tienMienCaNhan;
    }
    
}
