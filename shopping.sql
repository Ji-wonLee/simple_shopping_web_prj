ALTER TABLE customer
DROP CONSTRAINT customer_gcode_fk;

ALTER TABLE price
DROP CONSTRAINT price_ino_fk;

ALTER TABLE dcpercent
DROP CONSTRAINT dcpercent_gcode_fk;
ALTER TABLE dcpercent
DROP CONSTRAINT dcpercent_ino_fk;


DROP TABLE customer;
DROP TABLE grade;
DROP TABLE item;
Drop TABLE price;
Drop TABLE dcpercent;


PURGE RECYCLEBIN;


CREATE TABLE customer(
id VARCHAR2(100),
pw VARCHAR2(100),
cname VARCHAR2(15),
caddr VARCHAR2(40),
gcode VARCHAR2(40),
CONSTRAINT customer_id_pk PRIMARY KEY(id)
);

CREATE TABLE grade(
gcode VARCHAR2(40),
gname VARCHAR2(50),
CONSTRAINT grade_gcode_pk PRIMARY KEY(gcode)
);

CREATE TABLE item(
ino NUMBER,
iname VARCHAR2(40),
icount NUMBER,
CONSTRAINT item_ino_pk PRIMARY KEy(ino)
);

CREATE TABLE price(
ino NUMBER,
pwon NUMBER,
CONSTRAINT price_ino_pk PRIMARY KEY(ino),
CONSTRAINT price_ino_fk FOREIGN KEY (ino) REFERENCES item (ino)
);

CREATE TABLE dcpercent(
gcode VARCHAR2(40),
ino NUMBER,
dc NUMBER,
CONSTRAINT dcpercent_gcode_fk FOREIGN KEY (gcode) REFERENCES grade (gcode),
CONSTRAINT dcpercent_ino_fk FOREIGN KEY (ino) REFERENCES item (ino)
);


ALTER TABLE customer
ADD CONSTRAINT customer_gcode_fk FOREIGN KEY (gcode) REFERENCES grade (gcode);


INSERT INTO grade (gcode, gname) VALUES ('V','vip');
INSERT INTO grade (gcode, gname) VALUES ('G','good');
INSERT INTO grade (gcode, gname) VALUES ('N','normal');
INSERT INTo grade (gcode, gname) VALUES ('B','black');
COMMIT;

INSERT INTO customer (id, pw, cname, caddr, gcode) VALUES ('qwer','a1234','짱구','서울','G');
INSERT INTO customer (id, pw, cname, caddr, gcode) VALUES ('asdf','b1234','철수','대전','V');
INSERT INTO customer (id, pw, cname, caddr, gcode) VALUES ('zxcv','c1234','훈이','대구','B');
INSERT INTO customer (id, pw, cname, caddr, gcode) VALUES ('vbnm','d1234','맹구','부산','N');
COMMIT;

INSERT INTO item (ino, iname, icount) VALUES (1531,'딸기맛사탕',532);
INSERT INTO item (ino, iname, icount) VALUES (1532,'포도맛사탕',415);
INSERT INTO item (ino, iname, icount) VALUES (1533,'사과맛사탕',842);
INSERT INTO item (ino, iname, icount) VALUES (1534,'레몬맛사탕',105);
INSERT INTO item (ino, iname, icount) VALUES (1535,'수박맛사탕',957);
INSERT INTO item (ino, iname, icount) VALUES (1536,'멜론맛사탕',236);
INSERT INTO item (ino, iname, icount) VALUES (1537,'체리맛사탕',85);
INSERT INTO item (ino, iname, icount) VALUES (1538,'복숭아맛사탕',102);
INSERT INTO item (ino, iname, icount) VALUES (1539,'자두맛사탕',47);
INSERT INTO item (ino, iname, icount) VALUES (1540,'용과맛사탕',345);
INSERT INTO item (ino, iname, icount) VALUES (1541,'키위맛사탕',96);
INSERT INTO item (ino, iname, icount) VALUES (1542,'라임맛사탕',481);
INSERT INTO item (ino, iname, icount) VALUES (1543,'망고맛사탕',12);
INSERT INTO item (ino, iname, icount) VALUES (1544,'자몽맛사탕',621);
INSERT INTO item (ino, iname, icount) VALUES (1545,'석류맛사탕',75);
COMMIT;

INSERT INTO price (ino, pwon) VALUES (1531,2000);
INSERT INTO price (ino, pwon) VALUES (1532,1500);
INSERT INTO price (ino, pwon) VALUES (1533,4000);
INSERT INTO price (ino, pwon) VALUES (1534,3000);
INSERT INTO price (ino, pwon) VALUES (1535,5000);
INSERT INTO price (ino, pwon) VALUES (1536,6800);
INSERT INTO price (ino, pwon) VALUES (1537,4200);
INSERT INTO price (ino, pwon) VALUES (1538,3700);
INSERT INTO price (ino, pwon) VALUES (1539,4500);
INSERT INTO price (ino, pwon) VALUES (1540,5300);
INSERT INTO price (ino, pwon) VALUES (1541,3600);
INSERT INTO price (ino, pwon) VALUES (1542,7200);
INSERT INTO price (ino, pwon) VALUES (1543,3200);
INSERT INTO price (ino, pwon) VALUES (1544,6900);
INSERT INTO price (ino, pwon) VALUES (1545,7900);
COMMIT;

INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1531,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1532,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1533,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1534,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1535,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1536,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1537,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1538,0.5);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1539,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1540,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1541,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1542,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1543,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1544,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('V',1545,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1531,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1532,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1533,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1534,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1535,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1536,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1537,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1538,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1539,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1540,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1541,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1542,0.3);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1543,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1544,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('G',1545,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1531,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1532,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1533,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1534,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1535,0.1);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1536,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1537,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1538,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1539,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1540,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1541,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1542,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1543,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1544,0);
INSERT INTO dcpercent (gcode, ino, dc) VALUES ('N',1545,0);
COMMIT;
