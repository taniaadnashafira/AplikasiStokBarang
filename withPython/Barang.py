class Barang:
    def __init__(self, kode, nama, jumlah):
        self.kode = kode
        self.nama = nama
        self.jumlah = jumlah

    def tambah_stok(self, jumlah):
        self.jumlah += jumlah

    def kurangi_stok(self, jumlah):
        if jumlah <= self.jumlah:
            self.jumlah -= jumlah
        else:
            print("⚠️ Jumlah stok tidak mencukupi!")

    def __str__(self):
        return f"{self.kode} - {self.nama} ({self.jumlah} pcs)"
