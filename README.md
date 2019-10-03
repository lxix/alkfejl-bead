# Alkalmazások fejlesztése - Beadandó - 2019/20/1

## Feladat funkcionális követelményei

- **Adatbázis:**
Legalább 4 táblát, 1-sok kapcsolatot és sok-sok kapcsolatot kell tartalmaznia az órán megismert adatbázis-kezelő rendszer segítségével. A táblák a felhasználóknak, recepteknek, hozzávalóknak és [még egy tábla] lesznek létrehozva.

- **Szerveroldal:** 
Java Spring Boot, MVC modell, REST API és authorizált végpontok használatával

- **Kliensoldal:**
Angular (6+) keretrendszer használatával legalább három tábla adatait szerkeszthetősége a felületen: *lista, új, módosít, töröl (vagy inaktívvá tesz)*. Újat hozzáadni, meglévőt módosítani vagy törölni csak hitelesítés után elérhető funkció (autentikáció). A felhasználó csak a megfelelő adatokhoz férhet hozzá (autorizáció), azaz csak a saját receptjeit törölheti és módosíthatja. A szerverrel AJAX kérésekkel történik a kommunikáció.

## Feladat nem funkcionális követelményei

## Szakterületi fogalomjegyzék

- **H2 Database Engine**
A H2 és a hasonló adatbáziskezelők legfőbb előnyei közé tartozik, hogy akár kliens-szerver üzemmódban akár önálló, egygépes alkalmazásainkban is használhatjuk, nem kell külön telepíteni, jól hordozható, és 100%-ban Java, azaz ha Javaban programozunk, belül maradhatunk a használt fogalmi/gondolkodási tartományon.

- **Java Spring**
A Spring egy nyílt forráskódú, inversion of controlt megvalósító Java alkalmazás keretrendszer.

- **MVC modell**
A modell-nézet-vezérlő (MNV) (angolul model-view-controller) a szoftvertervezésben használatos szerkezeti minta.

- **REST API**
A REST (Representational State Transfer) egy szoftverarchitektúra típus, elosztott kapcsolat (loose coupling), nagy, internet alapú rendszerek számára, amilyen például a világháló. Az alkalmazásprogramozási felület vagy alkalmazásprogramozási interfész (angolul application programming interface, röviden API) egy program vagy rendszerprogram azon eljárásainak (szolgáltatásainak) és azok használatának dokumentációja, amelyet más programok felhasználhatnak.

- **Angular**
Az AngularJS egy Google által fejlesztett, nyílt forráskódú JavaScript keretrendszer dinamikus webes alkalmazásokhoz. Segítségével nagyban egyszerűsödik a webes alkalmazások frontend fejlesztése.

## Szerepkörök

- **Felhasználó**
A felhasználónak lehetősége lesz az oldalon megjelenített receptek megtekintésére. Csak olvasási jogai vannak, ezeket regisztrációval tudja bővíteni írási jogokkal.

- **Regisztrált felhasználó**
A regisztrált felhasználónak lehetősége lesz az oldalon megjelenített receptek megtekintésére és saját receptek létrehozására, szerkesztésére és törlésére. Olvasási és írási joggal rendelkezik.

- **Admin**
Az admin olvasási és írási joggal rendelkezik minden regisztrált felhasználó receptjei felett. 
