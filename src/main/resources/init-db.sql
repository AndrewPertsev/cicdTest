DROP TABLE IF EXISTS Employee CASCADE;
DROP TABLE IF EXISTS Projects CASCADE;
DROP TABLE IF EXISTS Positions CASCADE;
DROP TABLE IF EXISTS employee_projects CASCADE;

CREATE TABLE Positions (
     Id SERIAL PRIMARY KEY,
     Name VARCHAR(256) NOT NULL
	);
	
CREATE TABLE Employee (
     Id SERIAL PRIMARY KEY,
     Name VARCHAR(32) NOT NULL,
	 SurName VARCHAR(32) NOT NULL,
	 Position_Id INT NOT NULL,
	 CONSTRAINT FK_Employee_REFERENCE_Positions FOREIGN KEY (Position_Id)
REFERENCES Positions(Id));

CREATE TABLE Projects (
     Id SERIAL PRIMARY KEY,
     Name VARCHAR(32) NOT NULL
);
	 	 
CREATE TABLE employee_projects(
	  employee_id INTEGER REFERENCES Employee(Id),
      project_id INTEGER REFERENCES Projects(Id),
     CONSTRAINT employee_projects_pk PRIMARY KEY(employee_id,project_id));
 
 
 INSERT INTO Positions (id, Name)
VALUES (1, 'Architect'),
       (2, 'Developer'),
       (3, 'Director'),
       (4, 'PM');
     
INSERT INTO Employee (id, Name, Surname, Position_Id)
VALUES 
(1, 'John', 'Fir', 1),
(2, 'Nick', 'Sec', 2),
(3, 'Bill', 'Thi', 3),
 (4, 'George', 'Fou', 4), 
 (5, 'Tom', 'Fif', 2), 
 (6, 'Alex', 'Six', 2),
 (7, 'Bob', 'Sev', 1)
 ;
 INSERT INTO Projects (id, Name)
VALUES (1, 'Large'),
       (2, 'Small'),
       (3, 'Medium'),
       (4, 'Huge'),
       (5, 'Amazing'),
       (6, 'Big');	
INSERT INTO employee_projects (employee_id,project_id)
VALUES (1, 1),
       (2, 3),
	   (2, 6),
       (3, 5),
	   (3, 2),
	   (3, 4),
       (4, 6);
	 
	
	

	
	
   