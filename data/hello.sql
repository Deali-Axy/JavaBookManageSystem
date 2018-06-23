PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE COMPANY (ID INT PRIMARY KEY     NOT NULL, NAME           TEXT    NOT NULL,  AGE            INT     NOT NULL,  ADDRESS        CHAR(50),  SALARY         REAL);
INSERT INTO COMPANY VALUES(1,'Paul',32,'California',25000.0);
INSERT INTO COMPANY VALUES(2,'Allen',25,'Texas',15000.0);
INSERT INTO COMPANY VALUES(3,'Teddy',23,'Norway',20000.0);
INSERT INTO COMPANY VALUES(4,'Mark',25,'Rich-Mond ',65000.0);
CREATE TABLE test(name varchar(20));
CREATE TABLE User
(
    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
    name char(200),
    password char(200),
    admin boolean
);
INSERT INTO User VALUES(1,'hello','passwd',1);
CREATE TABLE Book
(
    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
    name char(200),
    author char(200),
    publisher char(200),
    publication_date date,
    pages integer,
    ISBN char(200)
);
INSERT INTO Book VALUES(1,'Android Development','DealiAxy','SuperDA',1529718714308,100,'I-dont-konw');
CREATE TABLE Borrow
(
    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
    user integer,
    book integer,
    date date,
    CONSTRAINT Borrow_User_id_fk FOREIGN KEY (user) REFERENCES User (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT Borrow_Book_id_fk FOREIGN KEY (book) REFERENCES Book (id) ON DELETE CASCADE ON UPDATE CASCADE
);
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('User',1);
INSERT INTO sqlite_sequence VALUES('Book',1);
CREATE UNIQUE INDEX User_id_uindex ON User (id);
CREATE UNIQUE INDEX Book_id_uindex ON Book (id);
CREATE UNIQUE INDEX Borrow_id_uindex ON Borrow (id);
COMMIT;
