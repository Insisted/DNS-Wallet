
package Database;

import java.util.LinkedList;
import java.util.Queue;


public class User {
    protected final String nama;
    protected final boolean gender;
    protected final String ibu;
    protected final long noRek;
    protected int umur;
    protected boolean jenisRek;
    protected String PIN;
    protected int cobaPIN;
    protected double saldo;
    protected Queue<Mutasi> mutasi;
    
    public User(long noRek, String nama, String ibu, int gender, int umur, int jenisRek, String PIN){
        this.noRek = noRek;
        this.nama = capitalize(nama);
        this.ibu = capitalize(ibu);
        this.gender = gender == 2;
        this.umur = umur;
        this.jenisRek = jenisRek == 1;
        this.PIN = PIN;
        this.cobaPIN = 3;
        this.saldo = 0;
        mutasi = new LinkedList<>();
    }
    
    User(long noRek, String nama, String ibu, int gender, String PIN, double saldo){
        this.noRek = noRek;
        this.nama = nama;
        this.ibu = ibu;
        this.gender = gender == 2;
        this.PIN = PIN;
        this.cobaPIN = 3;
        this.saldo = saldo;
        mutasi = new LinkedList<>();
    }

    private String capitalize(String x){
        String name = "";
        
        for(String i: x.split(" "))
            name += i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ";
        
        return name.trim();
    }
    
    public String getNama() {
        return nama;
    }

    public boolean isGender() {
        return gender;
    }

    public int getUmur() {
        return umur;
    }

    public boolean isJenisRek() {
        return jenisRek;
    }

    public long getNoRek() {
        return noRek;
    }

    public int getCobaPIN() {
        return cobaPIN;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public Queue<Mutasi> getMutasi() {
        return mutasi;
    }

    public void addMutasi(Mutasi mutasi) {
        this.mutasi.add(mutasi);
    }

    public boolean cekPIN(String PIN) {
        return PIN.equals(this.PIN);
    }
    
    public boolean cekIbu(String ibu) {
        return ibu.equalsIgnoreCase(this.ibu);
    }
    
    public void gantiPIN(String lama, String baru){
        if(cekPIN(lama) || cekIbu(lama))
            this.PIN = baru;
    }

    public void addSaldo(double saldo){
        this.saldo += saldo;
    }
    
}
