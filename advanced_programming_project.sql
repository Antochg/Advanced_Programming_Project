DROP IF EXISTS TABLE Tutor CASCADE;
DROP IF EXISTS TABLE Student CASCADE;
DROP IF EXISTS TABLE Company CASCADE;
DROP IF EXISTS TABLE Internship CASCADE;

CREATE OR REPLACE TABLE Tutor(
   id_tutor INT AUTO_INCREMENT,
   name VARCHAR(50),
   lastname VARCHAR(50) NOT NULL,
   login VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_tutor),
   UNIQUE(login)
);

CREATE OR REPLACE TABLE Student(
   id_student INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   level VARCHAR(50) NOT NULL,
   id_tutor INT NOT NULL,
   PRIMARY KEY(id_student),
   FOREIGN KEY(id_tutor) REFERENCES Tutor(id_tutor)
);

CREATE OR REPLACE TABLE Company(
   id_company INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   address VARCHAR(255) NOT NULL,
   PRIMARY KEY(id_company)
);

CREATE OR REPLACE TABLE Internship(
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
   technical_note DECIMAL(2,2),
   communication_note DECIMAL(2,2),
   id_company INT NOT NULL,
   id_student INT NOT NULL,
   PRIMARY KEY(id_internship),
   FOREIGN KEY(id_company) REFERENCES Company(id_company),
   FOREIGN KEY(id_student) REFERENCES Student(id_student)
);

INSERT INTO `tutor`(`id_tutor`, `name`, `lastname`, `login`, `password`) VALUES (NULL,'Gaowei','CAO','gaowei','cao');
INSERT INTO `company`(`id_company`, `name`, `address`) VALUES (NULL,'Efrei Paris','30-32 avenue de la République 94 800 Villejuif');
INSERT INTO `student`(`id_student`, `name`, `lastname`, `level`, `id_tutor`) VALUES (NULL,'Loic','AUTRET','M2',1);
INSERT INTO `internship` (`id_internship`, `specifications`, `visit_sheet`, `company_eval_sheet`, `web_survey`, `report_delivered`, `presentation`, `planned`, `done`, `start_date`, `end_date`, `supervisor`, `technical_note`, `communication_note`, `id_company`, `id_student`) VALUES ('1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', '2023-02-01', '2023-02-02', 'Paul ANCELET', '10', '10', '1', '1');