# studentManagmentSystem
Operation To be performed by Owner/Admin:

1.	Can admit a student to the school with information such as name, date of birth , gender, unique_student_code. A student can have many addresses(area ,state, district, pincode,addressType)  like permanent, correspondence,current.
	Hint: Student and StudentAddress will have one-to-many relationships.
2.	Can Upload course details such as (course name, description, course type, duration,topics)
3.	Can assign  courses to student
Hint: Student and Course will have many to many mapping
4.	Can get  students by name. (search)
5.	Can get students assigned to a particular course.


Operation to be performed by Student:

1.	Can update profile details such as (email, mobile number , parents name,address)
2.	Can search for topics/courses he assigned
3.	Can leave a course .



** Admin should be able to login to the portal with  credentials ( using postman)
** student can validate them self using student_code and date of birth to perform the operations.
