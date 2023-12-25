# HATA MESAJLARI LİSTESİ
    
    X   X   X   X
    |   |   |   |
    |   |   |   +-----> Mesajı
    |   |   +---------> Alt işlem kodu
    |   +-------------> Servis adı
    +-----------------> İşlem kodu
    1   0   0   0 -> İşlem başarılı
    2   0   0   0 -> İşlem beklemede
    3   0   0   0 -> Yetkisiz işlemler
    4   0   0   0 -> Hatalı işlemler

## AUTH SERVİCE
    4100: "Parametre eksik ya da hatalı",
    4110: "Kullanıcı adı veya şifre hatalı",
    4111: "Girilen şifreler uyuşmuyor",
    4112: "Kullanıcı adı zaten kayıtlı"