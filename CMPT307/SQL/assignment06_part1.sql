-- Turn on strict mode while reading this file - warnings become errors
SET SESSION sql_mode = 'STRICT_ALL_TABLES';

DROP DATABASE IF EXISTS assignment06_part1;
CREATE DATABASE assignment06_part1;
USE assignment06_part1;

CREATE TABLE Student (
    id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(64) NOT NULL,
    lname VARCHAR(64) NOT NULL
);

CREATE TABLE Course (
    prefix CHAR(4),
    number SMALLINT UNSIGNED,
    title VARCHAR(96) NOT NULL,
    credits TINYINT UNSIGNED,
    description TEXT NOT NULL,
    PRIMARY KEY (prefix, number)
);

CREATE TABLE Class (
    id CHAR(6) PRIMARY KEY,
    coursePrefix CHAR(4) NOT NULL,
    courseNumber SMALLINT UNSIGNED NOT NULL,
    section TINYINT UNSIGNED NOT NULL DEFAULT 1,
    year YEAR NOT NULL,
    semester ENUM('fall', 'spring', 'may', 'summer'),
    days SET('M', 'T', 'W', 'Th', 'F', 'S', 'Su')
);

CREATE TABLE Enrollment (
    studentId INTEGER UNSIGNED NOT NULL,
    classId CHAR(6) NOT NULL,
    enrollDate DATETIME NOT NULL,
    finalGrade ENUM(
              'A', 'A-',
        'B+', 'B', 'B-',
        'C+', 'C', 'C-',
        'D+', 'D', 'D-',
              'F',
        'CR', 'NC',
        'W', 'WF',
        'AU',
        'I',
        'T') DEFAULT NULL
);

CREATE TABLE Club (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    description TEXT DEFAULT NULL
);

CREATE TABLE PresidesOver (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    studentId INT UNSIGNED NOT NULL,
    clubId INT UNSIGNED NOT NULL,

    FOREIGN KEY (studentId) REFERENCES Student (id),
    FOREIGN KEY (clubId) REFERENCES Club (id)
);

CREATE TABLE MemberOf (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    studentId INT UNSIGNED NOT NULL,
    clubId INT UNSIGNED NOT NULL,

    FOREIGN KEY (studentId) REFERENCES Student (id),
    FOREIGN KEY (clubId) REFERENCES Club (id)
);

INSERT INTO Student (fname, lname) VALUES
    ('Ginny', 'Bynum'),
    ('Jina', 'Large'),
    ('Alla', 'Nall'),
    ('Lilian', 'Atwood'),
    ('Gavin', 'Colby'),
    ('Rosalia', 'Beard'),
    ('Eloisa', 'Rand'),
    ('Kraig', 'Gentile'),
    ('Beata', 'Marlowe'),
    ('Anitra', 'Hoover'),
    ('Erlinda', 'Woodruff'),
    ('Treena', 'Jameson'),
    ('Dinorah', 'Omalley'),
    ('Dinorah', 'Franco'),
    ('Alphonso', 'Birch'),
    ('Dominica', 'Sowell'),
    ('Bethann', 'Binkley'),
    ('Maybelle', 'Armenta'),
    ('Enedina', 'Schofield'),
    ('Lura', 'Mckeever'),
    ('Jack', 'Wilburn'),
    ('Katie', 'Johnson'),
    ('Lauren', 'Hofstra'),
    ('Ember', 'Bradbury'),
    ('Anette', 'Donald'),
    ('Abby', 'Leinbach'),
    ('Max', 'Black'),
    ('Sarah', 'Naggy'),
    ('Valeria', 'Villegas');

INSERT INTO Course (prefix, number, title, credits, description) VALUES
    ('CMPT', 140, 'Computer Science Principles', 3, 'This course is an introduction to the history, social implications, great principles, and future of computing. Relevance of computing to students and society will be emphasized. Students will learn the joy of programming a computer using a friendly, graphical language, and will discuss how computing empowers discovery and progress in other fields. (WCore: WCSAM)'),
    ('CMPT', 150, 'Math & Technology of Entertainment Arts', 3, 'Explore the math and technology behind compute animation and video game design. Ever wonder while watching a movie: \'How did they do that?\' Students will learn the mathematical and computational theory behind image processing, 2D and 3D computer graphics and special effects. This seminar will discuss the progress of computer graphics research over the last fifty years. This course fulfills the Quantitative Emphasis (QE) requirement. (WCore: WCSAM, QE)'),
    ('CMPT', 201, 'Introduction to Computer Science', 4, 'Introduction to programming fundamentals, including problem solving skills, program design, object-oriented programming, coding, testing, and debugging using the Java programming language. Three lectures and one two-hour lab. Co-requisite: MATH 101 or 105 and current computer literacy skills. Offered every Fall semester.'),
    ('CMPT', 202, 'Introduction to Data Structures', 4, 'An exploration of data structures including stacks, queues, trees, and dictionaries, and a comparison of the algorithmic efficiencies based upon their implementations. Three lectures and one two-hour lab. Prerequisites: CMPT 201. Offered every Spring semester.'),
    ('CMPT', 307, 'Database Systems', 4, 'A study of relational databases from theory through practical design, implementation, and application programming. The course also examines other topics such as relational algebra, SQL, and designing web interfaces.'),
    ('CMPT', 251, 'Computer Systems & Programming', 4, "An examination of a computer system from the programmer's perspective. We examine how your programs interact with the compiler, the assembler, the operating system, and the hardware. Such study helps explain how to write more efficient software. We will introduce and use the C programming language, the UNIX operating system, and Intel assembly. Offered every Fall semester.");

INSERT INTO Class (id, coursePrefix, courseNumber, section, year, semester, days) VALUES
    ('x03483', 'CMPT', 140, 1, 2018, 'fall', 'M,W'),
    ('x03484', 'CMPT', 201, 1, 2018, 'fall', 'T,Th'),
    ('x03485', 'CMPT', 201, 2, 2018, 'fall', 'M,W'),
    ('x03486', 'CMPT', 202, 2, 2018, 'fall', 'T,Th'),
    ('x03487', 'CMPT', 202, 1, 2018, 'fall', 'M,W'),
    ('x03488', 'CMPT', 251, 1, 2018, 'fall', 'T,Th'),
    ('x03489', 'CMPT', 307, 1, 2018, 'fall', 'T,Th');

INSERT INTO Enrollment (studentId, classId, enrollDate, finalGrade) VALUES
    (1, 'x03483', '2018-08-02 13:45:53', NULL),
    (1, 'x03483', '2018-08-02 13:45:53', NULL),
    (1, 'x03483', '2018-08-02 13:45:53', 'WF'),
    (2, 'x03485', '2018-08-26 09:47:20', 'A'),
    (21, 'x03487', '2018-08-25 23:57:30', 'A'),
    (21, 'x03488', '2018-08-24 14:45:20', 'A'),
    (21, 'x03489', '2018-08-23 10:34:51', 'A');

INSERT INTO Club (name, description) VALUES 
    ('Cornhole Club', NULL),
    ('Feminist Club','The Feminist Club’s main goal is to heighten awareness about radical feminism. This includes discussing the common misconceptions associated with feminism, empowering all feminists at Westminster and in Salt Lake City, and engaging in meaningful service projects within our community. Our club values diversity, intersectionality, inclusiveness, and acceptance of all people. We specifically focus on incorporating the voices of people of color, the queer community, trans individuals, and the LGBTQIAP+ community at large. This club is also non-hierarchical, and the various chairs within the club are task-oriented and filled on a volunteer basis.'),
    ('Lemma', NULL),
    ('Student Physics Society', 'Student Physics Society is a place for physics majors to meet other like-minded individuals to network, learn about careers in physics and the sciences, find scholarships, and participate in science-related community service.');

INSERT INTO PresidesOver (studentId, clubId) VALUES 
    (22, 1),
    (23, 1),
    (24, 2),
    (25, 2),
    (26, 2),
    (27, 3),
    (28, 4),
    (29, 4);

INSERT INTO MemberOf (studentId, clubId) VALUES 
    (12, 3),
    (20, 2),
    (13, 1),
    (2, 4),
    (4, 2),
    (7, 1);
