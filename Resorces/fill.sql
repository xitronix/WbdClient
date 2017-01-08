
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Magistr','ENGLISH');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Doktor','ENGLISH');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Magistr','ROSYJSKI');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Doktor','ROSYJSKI');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Magistr','POLSKI');
INSERT INTO "Kwalifikacja"("Stopien", "Typ_kwalifikacji") VALUES ('Doktor','POLSKI');

INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','B2',45,'POSKI-B2',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','C2',30,'POLSKI-C2',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','C1',30,'POLSKI-C1',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('POLSKI','B1',30,'POLSKI-B1',6);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('ROSYJSKI','C1',45,'RUS-C1',4);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('ENGLISH','B1',20,'ENG-B1',1);
INSERT INTO "Kurs"("Nazwa_kursu", "Poziom", "Ilosc_grupy", "Nazwa_certyfikatu","ID_Kwalifikacji") VALUES ('ENGLISH','A2',20,'ENG-A2',1);


UPDATE "Kurs" SET "Nazwa_kursu"="Nazwa_certyfikatu";


INSERT INTO "Budynek"("Adres") VALUES ('ul.Warynskiego 12a, Warszawa');
INSERT INTO "Budynek"("Adres") VALUES ('ul.Ksiecia Janusza 39, Warszawa');
INSERT INTO "Budynek"("Adres") VALUES ('pl. Politechniki 1, Warszawa');

INSERT INTO "Zajecie"("ID_Kursu", "Temat", "Pojemnosc", "Czas_trwania","Typ_sali") VALUES (1,'Alfabet','2',2,'Jezyk');

select * from "Kurs";
--INSERT INTO "Pracownik"("Imie", "Nazwisko", "Wynagrodzenie", "StopieĹ„_naukowy", "Uczelnia", "Kierunek", "Adres", "Numer_konta", "Stanowisko", "Status") VALUES ();
COMMIT;
--NUMTODSINTERVAL(5,'HOUR') //MINUTE,DAY,
--NUMTOYMINTERVAL(5,'HOUR') //MONTH, YEAR