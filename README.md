# Teracode's School Service


## To start the application:


1) go to application.properties file and complete the root password of mysql.
2) enable liquibase on application.properties
3) go to the root folder of the project and run mvn spring-boot:run

(Assuming that you have MYSQL - REDIS installed, if not please refer to the links)

[REDIS UBUNTU](https://tecadmin.net/install-redis-ubuntu/)

[REDIS MAC (HOMEBREW)](https://medium.com/@petehouston/install-and-config-redis-on-mac-os-x-via-homebrew-eb8df9a4f298)

[MYSQL](https://www.dev2qa.com/how-to-install-mysql-on-ubuntu/)

##Test it!

There is a postman_collection.json with the available endpoints.

[POSTMAN](https://www.getpostman.com/downloads/)

## Questionnaire


### A

   Diagram-1
  
### B

  ```
  SELECT id as id, first_name as firstName, last_name as lastName, SUBSTR(last_name, 1, 1) as alpha 
  FROM person 
  where type = 'STUDENT' 
  ORDER BY SUBSTR(last_name, 1, 1)
  ```
  
### C
  ```
   SELECT p.id as id, p.first_name as firstName, p.last_name as lastName, GROUP_CONCAT(s.name) as subjects
   FROM person p 
   inner join STUDENT_SUBJECT ss on ss.student_id = p.id
   inner join SUBJECT s on ss.subject_id = s.id
   where p.type = 'STUDENT' GROUP BY p.id
  ```          

### D
 1) Table-Per-Hierarchy (TPH) (Used in this service - Diagram-1):
 
 
 TPH uses a discriminator type to define the entity type for the table rows.
 
 Advantages:
 
 - High performance of CRUD operations, because all data are stored in one table.
 - Minimum number of tables in the database.

 Disadvantages:
 
 - Data redundancy. Some columns for specific entity classes contain NULL values, and the number of these columns depends on the number of classes in the hierarchy.
 - Data redundancy leads to the data integrity violation if data was changed manually.
 - The complexity of adding and deleting new entities to/from the object model, because it is necessary to add or delete columns to/from the result table.
 
 2) Table-Per-Type (TPT) (Example in schema - Diagram-2)
 
 in TPT, each entity class in the hierarchy corresponds to the database table.
 
 Advantages:
 
 - Data integrity is preserved. 
 - All the tables in the scheme correspond to the third normal form. (https://en.wikipedia.org/wiki/Third_normal_form)
 - There is no data redundancy.
 - Flexibility in object model modification. To add or drop an entity, add or delete the corresponding table to/from the database.
 
 Disadvantages:
 
 - The speed of the CRUD operation decreases when the number of classes in the hierarchy grows. 
 For example, SELECT queries will contain JOIN clauses and their number will be equal to the number of classes in hierarchy.
 - A large number of tables in the database.
 
### E

Query:
```SELECT * FROM janitor j
   INNER JOIN employee e
   ON e.id = j.id
   INNER JOIN person p
   ON p.id = j.id
   WHERE j.workingArea = ‘Hallway’;
   ```

Query (TPH - example used on app):
```
select concat(j.firstName, ' ', j.lastName) as janitorFullname
from Person j
WHERE j.workingArea = :area AND j.type = 'JANITOR'
```

Query (TPT):
```
SELECT concat(j.firstName, ' ', j.lastName) as janitorFullName FROM janitor j
   INNER JOIN person p
   ON p.id = j.id
   WHERE j.workingArea = ‘Hallway’;
```
changes:
* Index the 'working_area' field on the Person (TPH) or Janitor (TPT)
* Use a tuple to retrieve the object (avoid initialize a full Janitor-Person)
* Remove the useless employee inner join (TPT)
* Select just the fields that i need (firstName - lastName) and concat.

### F

The app has a report endpoint to get the expenses of the school, this query is used
```
SELECT  SUM(p.salary) as totalExpenses, ROUND(AVG(p.salary),2) as averageSalary, MIN(p.salary) as minimumSalary, 
             MAX(p.salary) as maximumSalary, SUM(j.salary) 
             as janitorsSalary, SUM(t.salary) as teachersSalary,
             SUM(ppal.salary) as principalSalary 
             FROM PERSON as p 
             LEFT JOIN PERSON as j ON j.type = 'JANITOR' and j.id = p.id 
             LEFT JOIN PERSON AS t ON t.type = 'TEACHER' and t.id = p.id 
             LEFT JOIN PERSON AS ppal ON ppal.type = 'PRINCIPAL'and ppal.id = p.id
```
to make the query go faster:

* Index type
* Use a view to retrieve the results (avoid full initialization)
* As the fields do not update very often, im using a in memory cache database (redis) 
with 1 hour expiration time and cache evicting whenever a new Employee is created, or you can
use the MySQL Server Query Cache.

### G
```
SELECT p.id, p.first_name as firstName, p.last_name as lastName, TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) as age 
      from Person p 
      WHERE p.type = 'STUDENT' HAVING age BETWEEN 19 AND 21
```
to make the query go faster:

* Index type

### H

Define a trigger that intercepts the creation/update of new persons. (in the example im just setting to null the values 
that a student must not get in insertion)
```

DELIMITER $$
DROP TRIGGER IF EXISTS check_person_insert $$
CREATE TRIGGER check_person_insert BEFORE INSERT ON `person`
FOR EACH ROW BEGIN
  if NEW.type='STUDENT' THEN
    SET NEW.salary = NULL;
    SET NEW.working_area = NULL;
  END IF;
END;
$$
DELIMITER ;
```

```

# TO TEST TRIGGER - yeah...is a newborn.
INSERT INTO `person` (`id`, `first_name`, `last_name`, `salary`, `working_area`, `type`, `birth_date`)
VALUES
  (NULL, 'Test', 'Test2', 2000, 'HALLWAY', 'STUDENT', NOW());
```

Advantages:

* One place to have all the validations needed
* If the programming language needs to be changed, almost all logic will be in the database; therefore the time of implementation will be minimal.
* Databases are less prone to technology migration

Disadvantages:

* Developer efficiency (A good IDE - Expressions - Libraries - Know how if not DBA)
* Lack of reuse (in non-database-centric systems)
* Harder to version
* Harder and more expensive to scale
* Unneeded workload added to the database 
* Maintain/debug/unit testing
