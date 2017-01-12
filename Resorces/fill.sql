
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Magistr','ENGLISH');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Doktor','ENGLISH');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Magistr','ROSYJSKI');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Doktor','ROSYJSKI');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Magistr','POLSKI');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Doktor','POLSKI');

INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','B2',45,'POLSKI-B2',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','C2',30,'POLSKI-C2',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','C1',30,'POLSKI-C1',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','B1',30,'POLSKI-B1',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('ROSYJSKI','C1',45,'RUS-C1',4);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('ENGLISH','B1',20,'ENG-B1',1);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('ENGLISH','A2',20,'ENG-A2',1);

UPDATE "Kurs" SET "Nazwa_kursu"="Nazwa_certyfikatu";

INSERT INTO "Typ_sali" ("Typ_sali","Minimalna_pojemnosc_sali") VALUES ('Jezykowa-PL',30);
INSERT INTO "Typ_sali" ("Typ_sali","Minimalna_pojemnosc_sali") VALUES ('Komputerowa',15);
INSERT INTO "Typ_sali" ("Typ_sali","Minimalna_pojemnosc_sali") VALUES ('Jezykowa-PL-2',45);
INSERT INTO "Typ_sali" ("Typ_sali","Minimalna_pojemnosc_sali") VALUES ('Jezykowa-PL-3',42);

INSERT INTO "Zajecie" ("ID_Kursu","Temat","Pojemnosc","Czas_trwania","Typ_sali") VALUES (3,'Alfabet',30, INTERVAL'0 02:10:00' DAY TO SECOND ,'Jezykowa-PL');
INSERT INTO "Zajecie" ("ID_Kursu","Temat","Pojemnosc","Czas_trwania","Typ_sali") VALUES (3,'Alfabet-2',30,INTERVAL '01:30' HOUR TO MINUTE ,'Jezykowa-PL');
INSERT INTO "Zajecie" ("ID_Kursu","Temat","Pojemnosc","Czas_trwania","Typ_sali") VALUES (3,'Literka A',30,INTERVAL '02:30'HOUR TO MINUTE ,'Jezykowa-PL');
INSERT INTO "Zajecie" ("ID_Kursu","Temat","Pojemnosc","Czas_trwania","Typ_sali") VALUES (3,'Sylaby',30,INTERVAL '02:30'HOUR TO MINUTE ,'Jezykowa-PL');
INSERT INTO "Zajecie" ("ID_Kursu","Temat","Pojemnosc","Czas_trwania","Typ_sali") VALUES (8,'Alphabet',30,INTERVAL '02:30'HOUR TO MINUTE ,'Jezykowa-PL');
INSERT INTO "Zajecie" ("ID_Kursu","Temat","Pojemnosc","Czas_trwania","Typ_sali") VALUES (8,'Alphabet-2',30,INTERVAL '02:30'HOUR TO MINUTE ,'Jezykowa-PL');


INSERT INTO "Budynek"("Adres") VALUES ('ul.Warynskiego 12a, Warszawa');
INSERT INTO "Budynek"("Adres") VALUES ('ul.Ksiecia Janusza 39, Warszawa');
INSERT INTO "Budynek"("Adres") VALUES ('pl. Politechniki 1, Warszawa');

INSERT INTO "Pracownik"("Imie","Nazwisko","Numer_konta","Adres","Wynagrodzenie") VALUES ('Wojciech','Sasalski',123467890,'ul.Belyje Rozy 22-59',3000);
INSERT INTO "Pracownik"("Imie","Nazwisko","Numer_konta","Adres","Wynagrodzenie") VALUES ('Anneta','Hoholska',0987654321,'ul.Czernyje Rozy 13-146',9000);
INSERT INTO "Pracownik"("Imie","Nazwisko","Numer_konta","Adres","Wynagrodzenie") VALUES ('Super','Super',9999999,'New-York',909090);
UPDATE "Pracownik" SET "Stopien_naukowy"='Magistr' WHERE "Imie"='Wojciech';
UPDATE "Pracownik" SET "Stopien_naukowy"='Magistr' WHERE "Imie"='Anneta';
UPDATE "Pracownik" SET "Stopien_naukowy"='Magistr' WHERE "Imie"='Super';

INSERT INTO "Typ_wyposazenia"("Model","Nazwa") VALUES ('Samsung','Wyswietlacz');
INSERT INTO "Typ_wyposazenia"("Model","Nazwa") VALUES ('LG','Wyswietlacz');

INSERT INTO "Sala"("ID_Budynku","Pojemnosc","Numer","Typ_sali") VALUES (1,30,204,'Jezykowa-PL');
INSERT INTO "Sala"("ID_Budynku","Pojemnosc","Numer","Typ_sali") VALUES (1,30,534,'Jezykowa-PL');
INSERT INTO "Sala"("ID_Budynku","Pojemnosc","Numer","Typ_sali") VALUES (2,30,534,'Jezykowa-PL');
INSERT INTO "Sala"("ID_Budynku","Pojemnosc","Numer","Typ_sali") VALUES (1,30,1235,'Komputerowa');
INSERT INTO "Sala"("ID_Budynku","Pojemnosc","Numer","Typ_sali") VALUES (2,30,1235,'Komputerowa');


INSERT INTO "Egzemplarz"("ID_Typu_wyposazenia","ID_Sala","Numer_seryjny") VALUES (1,1,'ABCD');
INSERT INTO "Egzemplarz"("ID_Typu_wyposazenia","ID_Sala","Numer_seryjny") VALUES (1,2,'ABCDd');
INSERT INTO "Egzemplarz"("ID_Typu_wyposazenia","ID_Sala","Numer_seryjny") VALUES (1,1,'hrenka');
INSERT INTO "Egzemplarz"("ID_Typu_wyposazenia","ID_Sala","Numer_seryjny") VALUES (2,1,'bilbos');

INSERT INTO "Przydzial_typu_wyposazenia" VALUES  (1,'Jezykowa-PL');
INSERT INTO "Przydzial_typu_wyposazenia" VALUES  (1,'Komputerowa');


select * from "Kurs";
--INSERT INTO "Pracownik"("Imie", "Nazwisko", "Wynagrodzenie", "StopieĹ„_naukowy", "Uczelnia", "Kierunek", "Adres", "Numer_konta", "Stanowisko", "Status") VALUES ();
COMMIT;
--NUMTODSINTERVAL(5,'HOUR') //MINUTE,DAY,
--NUMTOYMINTERVAL(5,'HOUR') //MONTH, YEAR