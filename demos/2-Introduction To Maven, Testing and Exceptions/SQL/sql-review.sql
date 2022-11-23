/*
 * 5 sublanguages:
 * 
 * DDL - data definition lang - focuses on table schema structure
 * CREATE
 * DROP - remove a table and its schema  structure from out of the db
 * TRUNCATE - remove the data from a table but keep the table schema in tact
 * ALTER
 * UPDATE
 * 
 * DML - data manpulation lang - focuses on altering the data in the records of your tables
 * CRUD
 * SELECT
 * UPDATE
 * DELETE
 * 
 * 
 * DQL - data query lang - retrieving data based on filters
 * SELECT
 * 
 * TCL - transaction control lang - focuses on tranaction management
 * 
 * What is a transaction? set of logical unit of events that happen in your database
 * SAVEPOINT - go to last saved changes in your database based on last given ROLLBACK
 * ROLLBACK
 * 
 * DCL - data control lang - focuses on user permissons on your database
 * GRANT
 * REVOKE
 * 
 * Each sublang has a set of corelating commands that describe that sublang.
 * 
 * 
 * */

--Aggregate functions allow you to query your data in groupings. There are some built-in aggregate functions, like: 
select * from "Album" a;

--query for COUNT all albums who start with the letter B
-- a in albums is just an alias for our table
select count(*) from "Album" a where a."Title" like 'B%';
--sum, count, min, max are just some examples

--Aggregate & scalar functions are two different concepts!
-- Both return single return (calculating input just differ)
-- aggregate functions will accept values from multiple rows to produce a output, 
--scalar functions will produce an output for each row of input

--all caps title for each album table
--this is a scalar function
select upper(a."Title") from "Album" a; 

-- Topic: Joins
/*
 * - What is a join?
 * - a join is used to combine rows from two or more tables based on a related column between them
 * 
 * - Types of joins:
 * 		- INNER
 * 			+ FULL
 * 			+ RIGHT
 * 			+ LEFT
 * 		- OUTER
 * 			+ FULL
 * 			+ RIGHT
 * 			+ LEFT
 * 		- SELF (a join to combine information between a table and itself)
 * 		- CROSS
 * 		- Theta joins (when your ON clause uses an arbituary comparsion <, >, >=, <=, etc.
 * 		- Equi Joins
 * 			+ "Natural joins"
 * 			+ the join occurs on a column whose name is shared between two tables
 * 			+ can use the USING clause to simplify the query (instead of the ON clause)
 */

--inner join example
--combine album + artist tables
select ab."AlbumId", ab."Title", a."Name" 
from "Album" ab
inner join "Artist" a 
on ab."ArtistId" = a."ArtistId";

--Views are temporary tables that we can use later in our queries to perform complex operations
create view artist_album as
select ab."AlbumId", ab."Title", a."Name" 
from "Album" ab
inner join "Artist" a 
on ab."ArtistId" = a."ArtistId";

select * from artist_album;

--Normalization is the process of reducing redundant data in your tables
-- 1 - 3NF (NEED TO KNOW FOR QC)