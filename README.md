# student-management-system
> Simple student management system with Spring Framework
# General Information
- I learn Spring Framework through this project
# Technologies Used
- Technologies: Spring boot, Spring JPA
- Languages: Java
- Database: MySQL
# Features
List the ready features here:
- Login, register
- Users can view students list, edit, delete student's information
# Api docs
## Student management:
- POST /api/v1/students: Create new student information.
- GET /api/v1/students/{id}: Get detailed information of a student by ID.
- PUT /api/v1/students/{id}: Update student information by ID.
- DELETE /api/v1/students/{id}: Delete student information by ID.
## View list of Students:
- GET /api/students: Retrieve a list of all students in the system.
- GET /api/students?classId={classId}&majorId={majorId}: Filter the list of students by class and major.
## Instructor management:
- POST /api/v1/instructors: Create new instructors information.
- GET /api/v1/instructors/{id}: Get detailed information of a instructor by ID.
- PUT /api/v1/instructors/{id}: Update instructor information by ID.
- DELETE /api/v1/instructors/{id}: Delete instructor information by ID.
## Class Management:
- POST /api/v1/classes: Create new class information.
- GET /api/v1/classes/{id}: Get detailed information of a class by ID.
- PUT /api/v1/classes/{id}: Update class information by ID.
- DELETE /api/v1/classes/{id}: Delete class information by ID.
## Major Management:
- POST /api/v1/majors: Create new major information.
- GET /api/v1/majors/{id}: Get detailed information of a major by ID.
- PUT /api/v1/majors/{id}: Update major information by ID.
- DELETE /api/v1/majors/{id}: Delete major information by ID.
# Project Status
Project is in progress
