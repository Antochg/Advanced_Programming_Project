DROP TABLE IF EXISTS Tutor CASCADE;
DROP TABLE IF EXISTS Student CASCADE;
DROP TABLE IF EXISTS Company CASCADE;
DROP TABLE IF EXISTS Internship CASCADE;

CREATE TABLE IF NOT EXISTS Tutor(
   id_tutor INT AUTO_INCREMENT,
   name VARCHAR(50),
   lastname VARCHAR(50) NOT NULL,
   login VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_tutor),
   UNIQUE(login)
);

CREATE TABLE IF NOT EXISTS Student(
   id_student INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   level VARCHAR(50) NOT NULL,
   id_tutor INT NOT NULL,
   PRIMARY KEY(id_student),
   FOREIGN KEY(id_tutor) REFERENCES Tutor(id_tutor)
);

CREATE TABLE IF NOT EXISTS Company(
   id_company INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   address VARCHAR(255) NOT NULL,
   PRIMARY KEY(id_company)
);

CREATE TABLE IF NOT EXISTS Internship(
   id_internship INT AUTO_INCREMENT,
   specifications bit(1) NOT NULL,
   visit_sheet bit(1) NOT NULL,
   company_eval_sheet bit(1) NOT NULL,
   web_survey bit(1) NOT NULL,
   report_delivered bit(1) NOT NULL,
   presentation bit(1) NOT NULL,
   planned bit(1) NOT NULL,
   done bit(1) NOT NULL,
   start_date DATE NOT NULL,
   end_date DATE NOT NULL,
   supervisor VARCHAR(50) NOT NULL,
   technical_note DECIMAL(4,2),
   communication_note DECIMAL(4,2),
   mission_description VARCHAR(255) NOT NULL,
   comments VARCHAR(255) NOT NULL,
   id_company INT NOT NULL,
   id_student INT NOT NULL,
   PRIMARY KEY(id_internship),
   FOREIGN KEY(id_company) REFERENCES Company(id_company),
   FOREIGN KEY(id_student) REFERENCES Student(id_student)
);

INSERT INTO `Tutor`(`id_tutor`, `name`, `lastname`, `login`, `password`) VALUES (NULL,'Gaowei','CAO','gaowei','cao');
INSERT INTO `Company`(`id_company`, `name`, `address`) VALUES (NULL,'Efrei Paris','30-32 avenue de la République 94 800 Villejuif');
INSERT INTO `Student`(`id_student`, `name`, `lastname`, `level`, `id_tutor`) VALUES (NULL,'Loic','AUTRET','M2',1);
INSERT INTO `Internship` (`id_internship`, `specifications`, `visit_sheet`, `company_eval_sheet`, `web_survey`, `report_delivered`, `presentation`, `planned`, `done`, `start_date`, `end_date`, `supervisor`, `technical_note`, `communication_note`, `id_company`, `id_student`) VALUES ('1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', '2023-02-01', '2023-02-02', 'Paul ANCELET', '10', '10', '1', '1');

INSERT INTO Tutor (name, lastname, login, password) VALUES ('Harry', 'Beaux', 'HBeaux', '123');

INSERT INTO Student(name, lastname, level, id_tutor) VALUES
("Alice", "Dupont", "L3", 1),
("Bob", "Martin", "M1", 2),
("Claire", "Lefebvre", "M2", 1),
("David", "Girard", "L3", 2),
("Emily", "Roy", "M1", 1),
("François", "Tremblay", "M2", 2),
("Gabrielle", "Beaulieu", "L3", 1),
("Henri", "Leclerc", "M1", 2),
("Isabelle", "Desjardins", "M2", 1),
("Jean", "Rousseau", "L3", 2);

INSERT INTO Company (name, address) VALUES
('ABC Inc.', '123 Main Street, Anytown, USA'),
('XYZ Ltd.', '456 Park Avenue, Somewhere, Canada'),
('123 Industries', '789 Broadway, Nowhere, Australia'),
('Acme Co.', '321 Elm Street, Elsewhere, UK'),
('Global Corp.', '555 Fifth Avenue, Everywhere, USA');


INSERT INTO Internship (specifications, visit_sheet, company_eval_sheet, web_survey, report_delivered, presentation, planned, done, start_date, end_date, supervisor, technical_note, communication_note, id_company, id_student) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, '2022-06-01', '2022-09-01', 'Emma Smith', 4.5, 4.0, 1, 1),
(1, 1, 1, 1, 1, 1, 1, 1, '2022-06-01', '2022-09-01', 'William Brown', 4.0, 4.5, 1, 2),
(1, 1, 1, 1, 1, 1, 1, 1, '2022-06-01', '2022-09-01', 'Sophia Lee', 4.2, 3.8, 2, 3),
(1, 1, 1, 1, 1, 1, 1, 1, '2022-06-01', '2022-09-01', 'Ethan Davis', 4.7, 4.2, 2, 4),
(1, 1, 1, 1, 1, 1, 1, 1, '2022-06-01', '2022-09-01', 'Olivia Miller', 3.8, 3.5, 3, 5),
(1, 1, 1, 1, 1, 1, 1, 0, '2022-06-01', '2022-09-01', 'Aiden Wilson', 4.0, 4.0, 3, 6),
(1, 1, 1, 1, 1, 1, 0, 0, '2022-06-01', '2022-09-01', 'Chloe Martinez', 3.5, 3.2, 4, 7),
(1, 1, 1, 1, 1, 1, 0, 0, '2022-06-01', '2022-09-01', 'Lucas Rodriguez', 3.2, 3.8, 4, 8),
(1, 1, 1, 1, 1, 0, 0, 0, '2022-06-01', '2022-09-01', 'Ava Garcia', 4.5, 4.0, 5, 9),
(1, 1, 1, 1, 1, 0, 0, 0, '2022-06-01', '2022-09-01', 'Liam Hernandez', 4.0, 4.5, 5, 10);

