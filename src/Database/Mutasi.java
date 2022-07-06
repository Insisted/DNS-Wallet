package Database;

import java.util.Date;

public class Mutasi {
    protected Date waktu;
    protected String namaUser;
    protected long rekUser;
    protected String namaTujuan;
    protected long rekTujuan;
    protected double total;
    protected String pesan;
    protected String jenis;
    
    public Mutasi(Date waktu, User user, User tujuan, double total, String pesan, boolean jenis){
        this.waktu = waktu;
        this.namaUser = user.getNama();
        this.rekUser = user.getNoRek();
        this.namaTujuan = tujuan.getNama();
        this.rekTujuan = tujuan.getNoRek();
        this.total = total;
        this.pesan = pesan;
        this.jenis = jenis? "Uang Masuk":"Uang Keluar";
    }

    public Date getWaktu() {
        return waktu;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public long getRekUser() {
        return rekUser;
    }

    public String getNamaTujuan() {
        return namaTujuan;
    }

    public long getRekTujuan() {
        return rekTujuan;
    }

    public double getTotal() {
        return total;
    }

    public String getPesan() {
        return pesan;
    }
    
    public String getJenis() {
        return jenis;
    }
    
}
