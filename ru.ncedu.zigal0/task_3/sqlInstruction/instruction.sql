INSERT INTO T_GroupSelected
(id_Student, firstName, lastName, id_Group)
SELECT id_Student, firstName, lastName, id_Group
FROM T_Student
WHERE id_Group = 'b01-813b' AND dolgCount > 5
